package com.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @Author mahl
 * @Date 2017-11-15
 */
public class UserSerializer extends JsonSerializer<String> {

    public static final String s = "{\"name\":true,\"content\":false}";

    @Override
    public void serialize(String o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.getOutputContext().getCurrentName();
        jsonGenerator.writeString(o);
        System.out.println(o.toString());
    }
}
