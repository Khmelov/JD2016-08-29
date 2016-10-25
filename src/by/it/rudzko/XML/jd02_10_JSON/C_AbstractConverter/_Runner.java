package by.it.rudzko.XML.jd02_10_JSON.C_AbstractConverter;

import by.it.rudzko.XML.jd02_10_JSON.AB_XMLtoJSON.Periodicals;

import java.io.File;

public class _Runner {
    public static void main(String[] args) {

        File xml=new File("src/by/it/rudzko/XML/jd02_10_JSON/C_AbstractConverter/plain_xml.xml");
        File json=new File ("src/by/it/rudzko/XML/jd02_10_JSON/C_AbstractConverter/json.JSON");
        //XML file ---> JSON file
        Performer.doConvert("xml_to_json", Periodicals.class, xml, json);
        //JSON file ---> XML file
        Performer.doConvert("json_to_xml", Periodicals.class, json, xml);
        //XML file ---> JSON string
        String jsonString=Performer.doConvert("xml_to_json", Periodicals.class, xml);
        System.out.println("JSON from XML:\n"+jsonString);
        //JSON file ---> XML string
        String xmlString=Performer.doConvert("json_to_xml", Periodicals.class, json);
        System.out.println("XML from JSON:\n"+xmlString);
        //XML string ---> JSON file
        Performer.doConvert("xml_to_json", Periodicals.class, xmlString, json);
        //JSON string ---> XML file
        Performer.doConvert("json_to_xml", Periodicals.class, jsonString, xml);
    }
}
