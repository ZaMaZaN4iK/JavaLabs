package com.by.Zaitsev.Parser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import com.by.Zaitsev.Staff.Personality.Skills;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {

    public List<com.by.Zaitsev.Staff.Engineer> engineers;

    public void startParser(String filepath) throws Exception {
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Engineer");

            engineers = new ArrayList<com.by.Zaitsev.Staff.Engineer>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                engineers.add(getLanguage(nodeList.item(i)));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static com.by.Zaitsev.Staff.Engineer getLanguage(Node node) {
        com.by.Zaitsev.Staff.Engineer engineer = new com.by.Zaitsev.Staff.Engineer();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            engineer.name = getTagValue("name", element);
            engineer.age = Byte.parseByte(getTagValue("age", element));
            engineer.salary = Integer.parseInt(getTagValue("salary", element));
            engineer.surname = getTagValue("surname", element);
            engineer.middleName = getTagValue("middleName", element);
            engineer.year = Byte.parseByte(getTagValue("year", element));
            engineer.month = Byte.parseByte(getTagValue("month", element));
            engineer.day = Byte.parseByte(getTagValue("day", element));
            engineer.skills.add(Skills.valueOf(getTagValue("skills", element)));
        }
        return engineer;
    }

    // получаем значение элемента по указанному тегу
    public static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}
