package by.it.tsiamruk.jd02_08;

/**
 * Created by waldemar on 25/10/2016.
 */
public class Run {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir").concat("/src/by/it/tsiamruk/");
        String filePath = path + "jd02_07/paymentSystem.xml";
        SAXPars.saxParse(filePath);
        StAXPars.staxParce();
    }
}
