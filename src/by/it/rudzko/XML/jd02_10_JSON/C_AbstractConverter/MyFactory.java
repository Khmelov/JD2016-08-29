package by.it.rudzko.XML.jd02_10_JSON.C_AbstractConverter;

class MyFactory {
    private enum Direction{
        XML_TO_JSON, JSON_TO_XML
    }

    Converter createConverter(String s, Class beanClass)throws EnumConstantNotPresentException{
        Direction d= Direction.valueOf(s.toUpperCase());
        switch (d) {
            case XML_TO_JSON:
            {
                return new XmlToJson(beanClass);
            }
            case JSON_TO_XML:
            {
                return new JsonToXml(beanClass);
            }
            default: throw new EnumConstantNotPresentException(
                    d.getDeclaringClass(),d.name()
            );
        }
    }
}
