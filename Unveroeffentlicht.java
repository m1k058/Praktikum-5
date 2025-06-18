// Datei: Unveroeffentlicht.java
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import java.io.FileReader;

public class Unveroeffentlicht extends LiteraturImpl implements Literatur {
    /** Konstruktor aus JSON-Datei */
    public Unveroeffentlicht(String filename) throws Exception {
        super((JSONObject) new JSONParser().parse(new FileReader(filename)));
    }

    /** JSON-Konstruktor */
    public Unveroeffentlicht(JSONObject jsonObject) {
        super(jsonObject);
    }

    /** Convenience-Konstruktor mit Einzelparametern */
    public Unveroeffentlicht(String citekey, String author, String title,
                             long year, String comment) {
        super(buildJson(citekey, author, title, year, comment));
    }

    private static JSONObject buildJson(String citekey, String author, String title,
                                        long year, String comment) {
        JSONObject obj = new JSONObject();
        obj.put(CK, citekey);
        obj.put(AUT, author);
        obj.put(TIT, title);
        obj.put(YR, year);
        obj.put(COM, comment);
        obj.put(CLS, "unpublished");
        return obj;
    }

    @Override
    protected void getSpezifischeFelder(JSONObject obj) {
        // keine zusätzlichen Felder
    }

    @Override
    protected void addSpezifischeFelder() {
        // keine zusätzlichen Felder
    }
}
