package com.rj.service.impl;

import com.rj.dao.impl.ContactDAOImpl;
import com.rj.model.Contact;

import java.util.List;
import com.rj.service.ContactService;
import com.rj.dao.ContactDAO;

/**
 * Implementación de {@code ContactService} para gestionar contactos a través de una API.
 * <p>
 * Proporciona la lógica para realizar operaciones CRUD sobre los contactos,
 * enviando y recibiendo datos desde una API externa.
 */
public class ContactServiceImpl implements ContactService {
    private final ContactDAO contactDAO;

    public ContactServiceImpl() {
        contactDAO = new ContactDAOImpl();
    }

    @Override
    public void createContact(Contact contact) {
        if (contact.getFirstName() == null
                || contact.getLastName() == null
                || contact.getEmail() == null
                || contact.getPhoneNumber() == null
                || contact.getAddress() == null) {
            throw new IllegalArgumentException("Los datos no son válidos.");
        }
        contactDAO.createContact(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactDAO.getContactById(id);
    }

    @Override
    public void updateContact(Contact contact) {
        if (contact.getFirstName() == null
                || contact.getLastName() == null
                || contact.getEmail() == null
                || contact.getPhoneNumber() == null
                || contact.getAddress() == null) {
            throw new IllegalArgumentException("Los datos no son válidos.");
        }
        contactDAO.updateContact(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactDAO.deleteContact(id);
    }
}
