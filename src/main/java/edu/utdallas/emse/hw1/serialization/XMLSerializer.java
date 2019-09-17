package edu.utdallas.emse.hw1.serialization;

import java.lang.reflect.Modifier;
import java.util.Collection;

public class XMLSerializer extends ObjectSerializer {
    private int leadingTabs;

    public XMLSerializer(ObjectSerializable o) {
        this(o, 0);
    }

    private XMLSerializer(ObjectSerializable o, int leadingTabs) {
        super(o);
        this.leadingTabs = leadingTabs;
    }


    /* TODO: Move as much of this as possible to super class */
    @Override
    public String serialize() {
        String buffer = getLeadingTabString();
        StringBuilder sb = new StringBuilder();

        sb.append(buffer);
        header(getObjectSerializedName(), sb);
        sb.append("\n");

        getFields().forEach((field, tag) -> {
            field.setAccessible(true);

            if (Modifier.isStatic(field.getModifiers())) {
                //Ignore static fields
                return;
            }

            Class type = field.getType();

            try {
                Object value = field.get(getObject());

                /* TODO: Create objectType handlers rather than large if-else clause */
                if (Collection.class.isAssignableFrom(type)) {
                    sb.append(buffer).append("\t");
                    header(tag, sb);
                    sb.append("\n");

                    Collection c = (Collection) value;
                    c.forEach(o -> {
                        if (ObjectSerializable.class.isAssignableFrom(o.getClass())) {
                            XMLSerializer xmls = new XMLSerializer((ObjectSerializable) o, leadingTabs + 2);
                            sb.append(xmls.serialize());
                        }
                    });

                    sb.append(buffer).append("\t");
                    footer(tag, sb);
                    sb.append("\n");
                } else if (ObjectSerializable.class.isAssignableFrom(type)) {
                    XMLSerializer xmls = new XMLSerializer((ObjectSerializable) value, leadingTabs + 1);
                    sb.append(xmls.serialize());
                } else {
                    sb.append(buffer).append("\t");
                    header(tag, sb);
                    sb.append((value != null ? value.toString() : ""));
                    footer(tag, sb);
                    sb.append("\n");
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        });

        sb.append(buffer);
        footer(getObjectSerializedName(), sb);
        sb.append("\n");
        return sb.toString();
    }

    private void header(String label, StringBuilder sb) {
        sb.append("<").append(label).append(">");
    }

    private void footer(String label, StringBuilder sb) {
        sb.append("</").append(label).append(">");
    }

    private String getLeadingTabString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leadingTabs; i++) {
            sb.append("\t");
        }

        return sb.toString();
    }
}
