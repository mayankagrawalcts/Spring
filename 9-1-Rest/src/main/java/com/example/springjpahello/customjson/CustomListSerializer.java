package com.example.springjpahello.customjson;

import com.example.springjpahello.entity.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomListSerializer extends StdSerializer<User> {

    public CustomListSerializer() {
        this(null);
    }

    public CustomListSerializer(Class<User> t) {
        super(t);
    }

    @Override
    public void serialize(
            User user,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {
        generator.writeObject(user.getFirstname()+"  "+user.getLastname());

    }}
