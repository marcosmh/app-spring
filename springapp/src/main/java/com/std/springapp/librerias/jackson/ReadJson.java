package com.std.springapp.librerias.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {

    private static final String JSON_VALUE = "{\n" +
            "        \"rfc\": \"GAGC900101\",\n" +
            "        \"buc\": \"52524629\",\n" +
            "        \"producto\": \"75\",\n" +
            "        \"subproducto\": \"2103\"\n" +
            "    }";

    public static void main(String[] args) {
        try {
            System.out.println("Inicializando lectura de: " + JSON_VALUE);
            CustomerData customerData = new ObjectMapper().readValue(JSON_VALUE, CustomerData.class);

            System.out.println(customerData);
            System.out.println("POJO generado: " + customerData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
