package com.by.Zaitsev.Parser;
import com.by.Zaitsev.Staff.Personality.Skills;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class SaxPars extends DefaultHandler {

    com.by.Zaitsev.Staff.Engineer engineer = new com.by.Zaitsev.Staff.Engineer();
    String thisElement = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("----> Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    public com.by.Zaitsev.Staff.Engineer getResult(){
        return engineer;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("name")) {
            engineer.name = new String(ch, start, length);
        }
        if (thisElement.equals("surname")) {
            engineer.surname = new String(ch, start, length);
        }
        if (thisElement.equals("middleName")) {
            engineer.middleName = new String(ch, start, length);
        }
        if (thisElement.equals("age")) {
            engineer.age = new Byte(new String(ch, start, length));
        }
        if (thisElement.equals("day")) {
            engineer.day = new Byte(new String(ch, start, length));
        }
        if (thisElement.equals("month")) {
            engineer.month = new Byte(new String(ch, start, length));
        }
        if (thisElement.equals("year")) {
            engineer.year = new Byte(new String(ch, start, length));
        }
        if (thisElement.equals("salary")) {
            engineer.salary = new Integer(new String(ch, start, length));
        }
        if (thisElement.equals("skills")) {
            engineer.skills.add(Skills.valueOf(new String(ch, start, length)));
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void endDocument() {
        System.out.println("----> Stop parse XML...");
    }
}
