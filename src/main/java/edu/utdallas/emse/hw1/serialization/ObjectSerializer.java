package edu.utdallas.emse.hw1.serialization;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public abstract class ObjectSerializer {
    private final Object object;
    private final Class<?> objectClass;
    private final String objectClassName;
    private final String serializedName;
    private final Map<Field, String> fields = Collections.synchronizedMap(new LinkedHashMap<>());

    public ObjectSerializer(ObjectSerializable o) {
        object = o;
        objectClass = o.getClass();
        objectClassName = objectClass.getSimpleName();

        Serialized serialized = objectClass.getAnnotation(Serialized.class);
        serializedName = (serialized == null || serialized.tag().isEmpty()) ?
                objectClassName.toLowerCase() : serialized.tag();

        List<Field> fields = new ArrayList<>();
        for(Class<?> c = objectClass; c.getSuperclass() != null; c = c.getSuperclass()) {
            fields.addAll(
                    Arrays.stream(c.getDeclaredFields())
                          .filter(f -> !Modifier.isStatic(f.getModifiers()))
                          .filter(f -> f.getAnnotation(Serialized.class) != null)
                          .collect(Collectors.toList())
            );
        }

        fields.forEach(f -> {
            Serialized sField = f.getAnnotation(Serialized.class);
            String tag = sField.tag().isEmpty() ?
                    f.getName().toLowerCase() : sField.tag();
            this.fields.put(f, tag);
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
            String.format("%s%n%s%n%s%n",
                    object.toString(), objectClass.toString(), objectClassName));

        fields.forEach((f, t) -> sb.append(f.toString()).append("\tTAG: ").append(t).append("\n"));

        return sb.toString();
    }

    protected Object getObject() {
        return object;
    }

    protected String getObjectClassName() {
        return objectClassName;
    }

    protected Map<Field, String> getFields() {
        return fields;
    }

    protected String getObjectSerializedName() {
        return serializedName;
    }

    public String serialize() {
        StringBuilder sb = new StringBuilder();

        appendObjectHeader(sb, getObjectSerializedName());

        getFields().forEach((field, tag) -> {
            field.setAccessible(true);

            Object value;
            try {
                value = field.get(getObject());
            } catch (Exception e) {
                System.err.println(e);
                return;
            }

            /* TODO: Create objectType handlers rather than large if-else clause */
            appendField(sb, tag, value);

        });

        appendObjectFooter(sb, getObjectSerializedName());
        return sb.toString();
    }

    protected abstract void appendObjectHeader(StringBuilder sb, String objectName);

    protected abstract void appendObjectFooter(StringBuilder sb, String objectName);

    protected abstract void appendField(StringBuilder sb, String tag, Object value);
}
