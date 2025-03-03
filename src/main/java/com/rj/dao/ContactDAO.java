package com.rj.dao;

import com.rj.model.Contact;

import java.util.List;

/**
 * Interfaz DAO para la gestión de contactos a través de una API.
 * <p>
 * Define los métodos CRUD para la creación, lectura, actualización y eliminación de contactos.
 */
public interface ContactDAO {
    /**
     * Crea un nuevo contacto en la base de datos.
     *
     * @param contact El contacto a crear.
     */
    void createContact(Contact contact);

    /**
     * Obtiene todos los contactos almacenados en la base de datos.
     *
     * @return Una lista de contactos.
     */
    List<Contact> getAllContacts();

    /**
     * Busca un contacto por su ID.
     *
     * @param id El ID del contacto.
     * @return El contacto correspondiente o {@code null} si no se encuentra.
     */
    Contact getContactById(Long id);

    /**
     * Actualiza la información de un contacto existente.
     *
     * @param contact El contacto con los datos actualizados.
     */
    void updateContact(Contact contact);

    /**
     * Elimina un contacto de la base de datos por su ID.
     *
     * @param id El ID del contacto a eliminar.
     */
    void deleteContact(Long id);
}
