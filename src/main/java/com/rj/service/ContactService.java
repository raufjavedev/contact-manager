package com.rj.service;

import com.rj.model.Contact;

import java.util.List;

/**
 * Servicio para la gestión de contactos a través de una API.
 * <p>
 * Define los métodos para realizar operaciones CRUD sobre los contactos,
 * interactuando con la API correspondiente.
 */
public interface ContactService {
    /**
     * Crea un nuevo contacto enviándolo a la API.
     *
     * @param contact El contacto a crear.
     */
    void createContact(Contact contact);

    /**
     * Obtiene todos los contactos desde la API.
     *
     * @return Una lista de contactos.
     */
    List<Contact> getAllContacts();

    /**
     * Busca un contacto por su ID consultando la API.
     *
     * @param id El ID del contacto.
     * @return El contacto correspondiente o {@code null} si no se encuentra.
     */
    Contact getContactById(Long id);

    /**
     * Actualiza la información de un contacto enviando los cambios a la API.
     *
     * @param contact El contacto con los datos actualizados.
     */
    void updateContact(Contact contact);

    /**
     * Elimina un contacto a través de la API usando su ID.
     *
     * @param id El ID del contacto a eliminar.
     */
    void deleteContact(Long id);
}
