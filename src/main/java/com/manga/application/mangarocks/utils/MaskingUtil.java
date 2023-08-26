package com.manga.application.mangarocks.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.manga.application.mangarocks.annotation.Mask;

import java.io.IOException;

public class MaskingUtil {

    public static ObjectMapper getMaskingObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector serializationAnnotationIntrospector = mapper.getSerializationConfig().getAnnotationIntrospector();
        AnnotationIntrospector deserializationAnnotationIntrospector = mapper.getDeserializationConfig().getAnnotationIntrospector();
        AnnotationIntrospector updatedSerializationAnnotationIntrospector = AnnotationIntrospectorPair.pair(serializationAnnotationIntrospector, new MaskAnnotationIntrospector());
        AnnotationIntrospector updatedDeserializationAnnotationIntrospector = AnnotationIntrospectorPair.pair(deserializationAnnotationIntrospector, new MaskAnnotationIntrospector());
        mapper.setAnnotationIntrospectors(updatedSerializationAnnotationIntrospector, updatedDeserializationAnnotationIntrospector);
        return mapper;
    }

    public static class MaskAnnotationIntrospector extends NopAnnotationIntrospector {
        @Override
        public Object findSerializer(Annotated am) {
            Mask annotation = am.getAnnotation(Mask.class);
            if (annotation != null) {
                return MaskSerializer.class;
            }
            return null;
        }
    }

    public static class MaskSerializer extends StdSerializer<String> {
        public MaskSerializer() {
            super(String.class);
        }

        @Override
        public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(value.replaceAll("[<>a-zA-Z0-9]", "*"));
        }
    }
}
