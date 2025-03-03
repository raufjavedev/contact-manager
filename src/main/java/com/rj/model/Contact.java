package com.rj.model;

import java.time.LocalDateTime;

/**
 * Modelo que representa un contacto en la aplicación.
 * <p>
 * Contiene los atributos de un contacto y se utiliza para enviar y recibir datos
 * a través de la API.
 */
public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Contact() {
    }

    /**
     * Constructor para inicializar un objeto {@code Contact} con todos sus atributos.
     * <p>
     * Se utiliza para crear instancias de contactos con datos completos,
     * ya sea al recibir información desde la API o al enviarla.
     *
     * @param id          Identificador único del contacto.
     * @param firstName   Nombre del contacto.
     * @param lastName    Apellido del contacto.
     * @param email       Correo electrónico del contacto.
     * @param phoneNumber Número de teléfono del contacto.
     * @param address     Dirección del contacto.
     * @param createdAt   Fecha y hora de creación del contacto.
     * @param updatedAt   Fecha y hora de la última actualización del contacto.
     */
    public Contact(Long id, String firstName, String lastName, String email, String phoneNumber, String address, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
