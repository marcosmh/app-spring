package com.std.springapp.librerias.jettison;


import org.codehaus.jettison.AbstractXMLStreamReader;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.MappedXMLStreamReader;

import javax.xml.stream.XMLStreamException;

public class Jettison {

	public static void main(String[] args) {
        try {
            JSONObject obj = new JSONObject("{\"dependency\":{\"groupId\": \"org.codehaus.jettison\", \"artifact\":\"jettison\"}}");

            for (AbstractXMLStreamReader reader = new MappedXMLStreamReader(obj); reader.hasNext(); reader.next()) {
                String s = reader.getLocalName();
                String t = reader.getText();
                System.out.println(String.format("Name: %s, text: %s", s, t));
            }
        } catch (XMLStreamException | JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
