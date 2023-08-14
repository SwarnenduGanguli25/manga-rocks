package com.manga.application.mangarocks.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class JsonParser {

    public static String objectToJson(final Object obj) {
        final ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            jsonInString = mapper.writeValueAsString(obj);
        } catch (final IOException e1) {
            log.error("Error: ", e1);
        }
        return jsonInString;
    }
}
