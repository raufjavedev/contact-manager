package com.rj.controller;

import com.rj.model.Contact;
import com.rj.view.ContactFormView;
import com.rj.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import com.rj.service.ContactService;

/**
 * Controlador que gestiona la interacción entre la vista y la lógica de negocio para los contactos.
 * <p>
 * Implementa {@code ActionListener} para manejar eventos de la interfaz de usuario.
 */
public class ContactController implements ActionListener {

    private final ContactService contactService;
    private final MainView mainView;
    private final ContactFormView contactFormView;

    public ContactController(ContactService contactService, MainView mainView, ContactFormView contactFormView) {
        this.contactService = contactService;
        this.mainView = mainView;
        this.contactFormView = contactFormView;

        mainView.btnNew.addActionListener(this);
        mainView.btnEdit.addActionListener(this);
        mainView.btnDelete.addActionListener(this);

        contactFormView.btnSave.addActionListener(this);
        contactFormView.btnedit.addActionListener(this);
        contactFormView.btnCancel.addActionListener(this);

        loadAllContacts();
        KeyListener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainView.btnNew) {
            contactFormView.clearFields();
            contactFormView.setFormTitle("Nuevo Contacto");
            contactFormView.btnSave.setVisible(true);
            contactFormView.btnedit.setVisible(false);
            contactFormView.setVisible(true);
        }
        if (e.getSource() == mainView.btnEdit) {
            contactFormView.clearFields();
            contactFormView.setFormTitle("Editar Contacto");
            contactFormView.btnSave.setVisible(false);
            contactFormView.btnedit.setVisible(true);
            loadContactById();
        }
        if (e.getSource() == mainView.btnDelete) {
            deleteContact();
        }
        if (e.getSource() == contactFormView.btnSave) {
            addContact();
        }
        if (e.getSource() == contactFormView.btnedit) {
            updateContact();
        }
        if (e.getSource() == contactFormView.btnCancel) {
            contactFormView.dispose();
        }
    }

    /**
     * Agrega un listener al campo de búsqueda para ejecutar la búsqueda en tiempo real.
     * <p>
     * Escucha eventos de teclado en {@code mainView.txtSearch} y llama a {@code searchContact()}
     * cuando se suelta una tecla, permitiendo la actualización dinámica de los resultados.
     */
    private void KeyListener() {
        mainView.txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchContact();
            }
        });
    }

    /**
     * Agrega un nuevo contacto a través de la API.
     * <p>
     * Válida los campos del formulario y, si están completos, crea un objeto {@code Contact}
     * y lo envía a {@code contactService.createContact()}. Muestra un mensaje de éxito o error
     * según el resultado.
     */
    private void addContact() {
        // Verificar campos vacíos
        if (contactFormView.isFieldsEmpty()) {
            contactFormView.errorMessage("Todos los campos deben ser llenados.");
            return;
        }

        // Obtener datos del formulario
        String firstName = contactFormView.getFirstName();
        String lastName = contactFormView.getLastName();
        String email = contactFormView.getEmail();
        String phoneNumber = contactFormView.getPhoneNumber();
        String address = contactFormView.getAddress();

        try {
            // Crear un objeto Contact
            Contact contact = new Contact();
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setEmail(email);
            contact.setPhoneNumber(phoneNumber);
            contact.setAddress(address);

            // Enviar el contacto a la API para su creación
            contactService.createContact(contact);

            // Mostrar mensaje de éxito si no hay excepciones
            contactFormView.successMessage("Contacto guardado exitosamente.");
            contactFormView.clearFields(); // Limpiar los campos
            loadAllContacts();
        } catch (Exception e) {
            // Manejo genérico para errores no esperados
            contactFormView.errorMessage("Error inesperado: " + e.getMessage());
        }
    }

    /**
     * Carga y muestra todos los contactos desde la API.
     * <p>
     * Obtiene la lista de contactos a través de {@code contactService.getAllContacts()}
     * y la muestra en la vista con {@code mainView.setAllContact(contacts)}.
     * Si ocurre un error, muestra un mensaje de error.
     */
    private void loadAllContacts() {
        try {
            // Obtener todos los contactos del servicio
            List<Contact> contacts = contactService.getAllContacts();

            // Cargar los contactos en la vista (tabla)
            mainView.setAllContact(contacts);
        } catch (Exception e) {
            mainView.errorMessage("Error loading contacts: " + e.getMessage());
        }
    }

    /**
     * Actualiza un contacto existente a través de la API.
     * <p>
     * Válida los campos del formulario y, si están completos, crea un objeto {@code Contact}
     * con los nuevos datos y lo envía a {@code contactService.updateContact()}.
     * Muestra un mensaje de éxito o error según el resultado.
     */
    private void updateContact() {
        // Verificar campos vacíos en el formulario
        if (contactFormView.isFieldsEmpty()) {
            return; // Salir si hay campos vacíos
        }

        // Obtener los datos del formulario
        Long contactId = contactFormView.getContactId(); // Id del contacto a actualizar
        String firstName = contactFormView.getFirstName();
        String lastName = contactFormView.getLastName();
        String email = contactFormView.getEmail();
        String phoneNumber = contactFormView.getPhoneNumber();
        String address = contactFormView.getAddress();

        try {
            // Crear un objeto Contact con los nuevos datos
            Contact contact = new Contact();
            contact.setId(contactId);
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setEmail(email);
            contact.setPhoneNumber(phoneNumber);
            contact.setAddress(address);

            // Llamar al servicio para actualizar el contacto
            contactService.updateContact(contact);

            // Mostrar mensaje de éxito en la vista
            contactFormView.successMessage("Contacto actualizado exitosamente.");
            contactFormView.clearFields(); // Limpiar los campos
            loadAllContacts();
            contactFormView.dispose();
        } catch (Exception e) {
            // Mostrar mensaje de error en la vista si ocurre una excepción
            contactFormView.errorMessage("Error al actualizar el contacto: " + e.getMessage());
        }
    }

    /**
     * Elimina un contacto a través de la API.
     * <p>
     * Verifica que se haya seleccionado un contacto válido y solicita confirmación
     * antes de enviarlo a {@code contactService.deleteContact()}.
     * Si la eliminación es exitosa, actualiza la lista de contactos.
     * En caso de error, muestra un mensaje correspondiente.
     */
    private void deleteContact() {
        // Verificar si se ha introducido un ID de contacto válido
        Long contactId = mainView.getContactId(); // Obtener el ID del contacto a eliminar
        if (contactId == null) {
            mainView.errorMessage("Por favor, selecciona un contacto válido.");
            return;
        }

        int option = mainView.confirmMessage("¿Está seguro de eliminar el contacto?");
        if (option == JOptionPane.NO_OPTION) {
            return; // Si el usuario elige "No", se cancela la acción
        }

        try {
            // Llamar al servicio para eliminar el contacto
            contactService.deleteContact(contactId);

            // Mostrar mensaje de éxito en la vista
            contactFormView.successMessage("Contacto eliminado exitosamente");
            loadAllContacts();
        } catch (Exception e) {
            // Mostrar mensaje de error en la vista si ocurre una excepción
            contactFormView.errorMessage("Error al eliminar el contacto: " + e.getMessage());
        }
    }

    /**
     * Carga un contacto por ID y muestra sus datos en el formulario de edición.
     * <p>
     * Verifica que se haya seleccionado un contacto válido y lo obtiene a través de
     * {@code contactService.getContactById()}. Si el contacto existe, rellena el formulario
     * con sus datos y lo muestra. Si no, muestra un mensaje de error.
     */
    public void loadContactById() {
        // Verificar si se ha introducido un ID de contacto válido
        Long contactId = mainView.getContactId(); // Obtener el ID del contacto a eliminar
        if (contactId == null) {
            mainView.errorMessage("Por favor, selecciona un contacto válido.");
            return;
        }

        Contact contact = contactService.getContactById(contactId);

        if (contact != null) {
            // Rellenar los campos del formulario con los datos del contacto
            contactFormView.setContactById(contact);
            contactFormView.setVisible(true);
        } else {
            mainView.errorMessage("Error al obtener el contacto por ID.");
        }
    }

    /**
     * Busca contactos por nombre o apellido y actualiza la vista con los resultados.
     * <p>
     * Obtiene la lista de contactos desde {@code contactService.getAllContacts()}
     * y la filtra según el término de búsqueda ingresado. Luego, actualiza la tabla
     * con los resultados. En caso de error, muestra un mensaje correspondiente.
     */
    public void searchContact() {
        String searchTerm = mainView.getSearchTerm();

        try {
            // Obtener todos los contactos del servicio
            List<Contact> contacts = contactService.getAllContacts();

            // Filtrar los contactos según el término de búsqueda
            List<Contact> filteredContacts = contacts.stream()
                    .filter(contact -> contact.getFirstName().toLowerCase().contains(searchTerm.toLowerCase())
                            || contact.getLastName().toLowerCase().contains(searchTerm.toLowerCase()))
                    .toList();

            // Actualizar la tabla en la vista
            mainView.setAllContact(filteredContacts);
        } catch (Exception e) {
            mainView.errorMessage("Error al cargar contactos: " + e.getMessage());
        }
    }
}
