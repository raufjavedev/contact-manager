package com.rj.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Convertir un objeto en JSON
    public static String toJson(Object obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }
}
