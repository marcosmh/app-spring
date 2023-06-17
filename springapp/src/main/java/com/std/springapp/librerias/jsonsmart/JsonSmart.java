package com.std.springapp.librerias.jsonsmart;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;


public class JsonSmart {

    private static final String JSON_VALUE = "{\n" +
            "        \"rfc\": \"GAGC900101\",\n" +
            "        \"buc\": \"52524629\",\n" +
            "        \"producto\": \"75\",\n" +
            "        \"subproducto\": \"2103\"\n" +
            "    }";

    public static void main(String[] args) {
        System.out.println("Inicializando JSON SMART");
        System.out.println("JSON a manipular: " + JSON_VALUE);
        try {
            JSONObject data = (JSONObject) JSONValue.parseWithException(JSON_VALUE);
            System.out.println("Agrega nuevo campo: 'cuenta: 2010'");
            data.put("cuenta", "2010");
            System.out.println("JSON actualizado: " + data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
