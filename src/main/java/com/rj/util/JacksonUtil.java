package com.rj.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonUtil {
    // Crear un ObjectMapper configurado para manejar fechas de Java 8
    public static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Registra el módulo para fechas de Java 8
        return objectMapper;
    }
}
