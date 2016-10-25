package by.it.savelyeva.jd_02_10.TaskC.Converter;

import java.io.File;
/**
 * Created by nato on 10/22/16.
 */
public class TaskC {
    private static String src = System.getProperty("user.dir") + "/src/by/it/savelyeva/jd_02_10/TaskC/";
    private static ConverterFactory converterFactory = new ConverterFactory();
    private static AbstractConverter converter;

    public static void switchConverter(String direction, Class beanClass) {
        converter = converterFactory.createConverterBuilder(direction, beanClass);
    }

    public static String fromFileXMLtoStringJSON(String fileXML, Class beanClass) {
        switchConverter("xml_to_json", beanClass);
        File file = new File(src + fileXML);
        converter.buildConverter(file);
        String json = converter.getConverterResult();
        return json;
    }

    public static void fromFileXMLtoFileJSON(String fileXML, String fileJSON, Class beanClass) {
        switchConverter("xml_to_json", beanClass);
        converter.buildConverter(new File(src + fileXML));
        File file = new File(src + fileJSON);
        converter.saveConverterResultToFile(file);
    }

    public static String fromFileJSONtoStringXML(String fileJSON, Class beanClass) {
        switchConverter("json_to_xml", beanClass);
        File file = new File(src + fileJSON);
        converter.buildConverter(file);
        String xml = converter.getConverterResult();;
        return xml;
    }

    public static String fromStringJSONtoStringXML(String jsonStr, Class beanClass) {
        switchConverter("json_to_xml", beanClass);
        converter.buildConverter(jsonStr);
        String xml = converter.getConverterResult();
        return xml;
    }
}
