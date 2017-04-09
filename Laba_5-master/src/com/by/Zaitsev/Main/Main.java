package com.by.Zaitsev.Main;
import com.google.gson.Gson;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Main {

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }

    public static  final  Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        // write your code here
        LOG.info("----->Start program");

        try {
            // SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            com.by.Zaitsev.Parser.SaxPars saxp = new com.by.Zaitsev.Parser.SaxPars();
            parser.parse(new File("xml/Engineer.xml"), saxp);
            com.by.Zaitsev.Staff.Engineer engineer = saxp.getResult();
            System.out.println(engineer);

            // DOM
            com.by.Zaitsev.Parser.DOMParser domParser = new com.by.Zaitsev.Parser.DOMParser();
            domParser.startParser("xml/Engineer.xml");
            System.out.println(domParser.engineers);


            // Серилизация
            FileOutputStream out = new FileOutputStream("xml/serialization.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(out);
            xmlEncoder.writeObject(engineer);
            xmlEncoder.flush();
            xmlEncoder.close();

            // Дессирилизация
            FileInputStream in = new FileInputStream("xml/serialization.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(in);
            com.by.Zaitsev.Staff.Engineer engineer_1 = (com.by.Zaitsev.Staff.Engineer)xmlDecoder.readObject();
            xmlDecoder.close();

            System.out.println(engineer_1);
            System.out.println(engineer_1.name);
            System.out.println(engineer_1.surname);
            System.out.println(engineer_1.middleName);
            System.out.println(engineer_1.year);
            System.out.println(engineer_1.age);
            System.out.println(engineer_1.day);
            System.out.println(engineer_1.month);

            // json
            FileWriter out_json_stream = new FileWriter("xml/serialization.json", true);
            Gson gson = new Gson();
            gson.toJson(engineer_1, out_json_stream);
            out_json_stream.close();

            FileReader in_json = new FileReader("xml/serialization.json");
            com.by.Zaitsev.Staff.Engineer engineer_2 = gson.fromJson(in_json, com.by.Zaitsev.Staff.Engineer.class);
            in_json.close();

            System.out.println(engineer_2);
            System.out.println(engineer_2.name);
            System.out.println(engineer_2.surname);
            System.out.println(engineer_2.middleName);
            System.out.println(engineer_2.year);
            System.out.println(engineer_2.age);
            System.out.println(engineer_2.day);
            System.out.println(engineer_2.month);
        }
        catch (Exception e){
            LOG.info(e.getMessage());
        }
        finally {
            LOG.info("----->End program");
        }
    }
}
