package edu.utdallas.emse.hw1.serialization;

import java.util.Collection;

public class XMLSerializer extends ObjectSerializer {
    private String leadingTabs;

    public XMLSerializer(ObjectSerializable o) {
        this(o, "");
    }

    private XMLSerializer(ObjectSerializable o, String leadingTabs) {
        super(o);
        this.leadingTabs = leadingTabs;
    }

    @Override
    protected void appendObjectHeader(StringBuilder sb, String objectName) {
        appendHeader(sb, objectName, "");
    }

    @Override
    protected void appendObjectFooter(StringBuilder sb, String objectName) {
        appendFooter(sb, objectName, "");
    }

    @Override
    protected void appendField(StringBuilder sb, String tag, Object value) {
        if (Collection.class.isAssignableFrom(value.getClass())) {
            appendHeader(sb, tag, "\t");

            Collection c = (Collection) value;
            c.forEach(o -> {
                appendObject(sb, tag, o);
            });

            appendFooter(sb, tag, "\t");
        } else {
            appendObject(sb, tag, value);
        }
    }

    private void appendHeadTag(String label, StringBuilder sb) {
        sb.append("<").append(label).append(">");
    }

    private void appendFootTag(String label, StringBuilder sb) {
        sb.append("</").append(label).append(">");
    }

    private void appendHeader(StringBuilder sb, String tag, String pad) {
        sb.append(leadingTabs).append(pad);
        appendHeadTag(tag, sb);
        sb.append("\n");
    }

    private void appendFooter(StringBuilder sb, String tag, String pad) {
        sb.append(leadingTabs).append(pad);
        appendFootTag(tag, sb);
        sb.append("\n");
    }

    private void appendObject(StringBuilder sb, String tag, Object o) {
        if (ObjectSerializable.class.isAssignableFrom(o.getClass())) {
            appendSerializableObject(sb, (ObjectSerializable) o, "\t\t");
        } else {
            appendBasicObject(sb, tag, o.toString(), "\t");
        }
    }

    private void appendSerializableObject(StringBuilder sb, ObjectSerializable value, String pad) {
        XMLSerializer xmls = new XMLSerializer(value, leadingTabs + pad);
        sb.append(xmls.serialize());
    }

    private void appendBasicObject(StringBuilder sb, String tag, String value, String pad) {
        sb.append(leadingTabs).append(pad);
        appendHeadTag(tag, sb);
        sb.append(value);
        appendFootTag(tag, sb);
        sb.append("\n");
    }
}
