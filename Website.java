// Datei: Website.java
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import java.io.FileReader;

public class Website extends LiteraturImpl implements Literatur {
    private static final String HPU = "howpublished";

    private String howpublished;

    /** Konstruktor aus JSON-Datei */
    public Website(String filename) throws Exception {
        super((JSONObject) new JSONParser().parse(new FileReader(filename)));
    }

    /** JSON-Konstruktor */
    public Website(JSONObject jsonObject) {
        super(jsonObject);
    }

    /** Convenience-Konstruktor mit Einzelparametern */
    public Website(String citekey, String author, String title,
                   long year, String howpublished, String comment) {
        super(buildJson(citekey, author, title, year, howpublished, comment));
    }

    private static JSONObject buildJson(String citekey, String author, String title,
                                        long year, String howpublished, String comment) {
        JSONObject obj = new JSONObject();
        obj.put(CK, citekey);
        obj.put(AUT, author);
        obj.put(TIT, title);
        obj.put(YR, year);
        obj.put(HPU, howpublished);
        obj.put(COM, comment);
        obj.put(CLS, "misc");
        return obj;
    }

    @Override
    protected void getSpezifischeFelder(JSONObject obj) {
        this.howpublished = (String) obj.get(HPU);
    }

    @Override
    protected void addSpezifischeFelder() {
        jsonObject.put(HPU, howpublished);
    }
}
