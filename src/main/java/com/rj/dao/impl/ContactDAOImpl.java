package com.rj.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rj.model.Contact;
import com.rj.util.JSONUtil;
import com.rj.util.JacksonUtil;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import com.rj.dao.ContactDAO;

/**
 * Implementación de {@code ContactDAO} para gestionar contactos a través de una API.
 * <p>
 * Proporciona la lógica para realizar operaciones CRUD sobre los contactos,
 * enviando solicitudes a la API correspondiente.
 */
public class ContactDAOImpl implements ContactDAO {
    // Establecer conexión con API
    private static final String API_URL = "http://localhost:8080/contacts";

    @Override
    public void createContact(Contact contact) {
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Convertir objeto Contact a JSON
            String json = JSONUtil.toJson(contact);

            // Construir solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL)) // Crear URI a partir del string de la URL
                    .header("Content-Type", "application/json") // Especificar formato de datos
                    .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8)) // Establecer cuerpo de la
                                                                                             // solicitud
                    .build();

            // Enviar solicitud y obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado HTTP
            if (response.statusCode() == 200) {
                // Mostrar contacto creado si se devuelve 201 Created
                System.out.println("Contacto creado exitosamente: " + response.body());
            } else {
                // Manejar errores devolviendo un mensaje claro
                throw new RuntimeException("Error al crear el contacto: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            // Imprimir error y lanzar excepción genérica para manejarla en capas superiores
            e.printStackTrace();
            throw new RuntimeException("No se pudo crear el contacto: " + e.getMessage());
        }
    }

    @Override
    public List<Contact> getAllContacts() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Si la respuesta es exitosa (status code 200)
            if (response.statusCode() == 200) {
                ObjectMapper objectMapper = JacksonUtil.createObjectMapper();
                return objectMapper.readValue(response.body(),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Contact.class));
            } else {
                System.err.println("Error al obtener contactos: " + response.body());
                return Collections.emptyList(); // Retornar una lista vacía en caso de error
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error durante la solicitud: " + e.getMessage());
            return Collections.emptyList(); // Retornar una lista vacía en caso de error
        }
    }

    @Override
    public Contact getContactById(Long id) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + "/" + id)) // URI para obtener el contacto por ID
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Si la respuesta es exitosa (status code 200)
            if (response.statusCode() == 200) {
                ObjectMapper objectMapper = JacksonUtil.createObjectMapper();
                // Convertir la respuesta JSON a un objeto de tipo Contact
                return objectMapper.readValue(response.body(), Contact.class);
            } else {
                System.err.println("Error al obtener el contacto por ID: " + response.body());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error durante la solicitud: " + e.getMessage());
            return null; // Retornamos null en caso de error
        }
    }

    @Override
    public void updateContact(Contact contact) {
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Convertir objeto Contact a JSON
            String json = JSONUtil.toJson(contact);

            // Construir solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + "/" + contact.getId())) // Incluir el ID del contacto en la URL
                    .header("Content-Type", "application/json") // Especificar formato de datos
                    .PUT(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8)) // Establecer cuerpo de la
                                                                                            // solicitud con PUT
                    .build();

            // Enviar solicitud y obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado HTTP
            if (response.statusCode() == 200) {
                // Mostrar contacto actualizado si se devuelve 200 OK
                System.out.println("Contacto actualizado exitosamente: " + response.body());
            } else {
                // Manejar errores devolviendo un mensaje claro
                throw new RuntimeException("Error al actualizar el contacto: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            // Imprimir error y lanzar excepción genérica para manejarla en capas superiores
            e.printStackTrace();
            throw new RuntimeException("No se pudo actualizar el contacto: " + e.getMessage());
        }
    }

    @Override
    public void deleteContact(Long id) {
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Construir solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + "/" + id)) // Incluir el ID del contacto en la URL
                    .header("Content-Type", "application/json") // Especificar formato de datos
                    .DELETE() // Método DELETE para eliminar
                    .build();

            // Enviar solicitud y obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado HTTP
            if (response.statusCode() == 204) {
                // Mostrar mensaje si la eliminación fue exitosa
                System.out.println("Contacto eliminado exitosamente: " + response.body());
            } else {
                // Manejar errores devolviendo un mensaje claro
                throw new RuntimeException("Error al eliminar el contacto: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            // Imprimir error y lanzar excepción genérica para manejarla en capas superiores
            e.printStackTrace();
            throw new RuntimeException("No se pudo eliminar el contacto: " + e.getMessage());
        }
    }
}
