package edu.utdallas.emse.hw1.serialization;

import java.lang.reflect.Field;
import java.util.*;

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

        List<Field> fs = new ArrayList<>();
        for(Class<?> c = objectClass; c.getSuperclass() != null; c = c.getSuperclass()) {
            fs.addAll(Arrays.asList(c.getDeclaredFields()));
        }

        fs.forEach(f -> {
            Serialized sField = f.getAnnotation(Serialized.class);
            if(sField != null) {
                String tag = sField.tag().isEmpty() ?
                        f.getName().toLowerCase() : sField.tag();
                fields.put(f, tag);
            }
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

    public abstract String serialize();
}
