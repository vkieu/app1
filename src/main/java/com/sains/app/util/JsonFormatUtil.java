package com.sains.app.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

public class JsonFormatUtil {
	
	/**
	 * Utility method for formatting and convert JSON objects into String for readable 
	 * 
	 * @param jsonObject
	 * @return
	 */
	public static String prettyFormat(JsonObject jsonObject) {

		Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory jwf = Json.createWriterFactory(config);
        StringWriter sw = new StringWriter();
        try (JsonWriter jsonWriter = jwf.createWriter(sw)) {
            jsonWriter.writeObject(jsonObject);
        }
        return sw.toString();
	}
}
