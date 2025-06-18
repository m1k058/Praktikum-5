// Datei: Buch.java
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import java.io.FileReader;

public class Buch extends LiteraturImpl implements Literatur {
    private static final String PUB = "publisher";
    private static final String ADD = "address";
    private static final String ISB = "isbn";

    private String publisher;
    private String address;
    private String isbn;

    /** Konstruktor aus JSON-Datei */
    public Buch(String filename) throws Exception {
        super((JSONObject) new JSONParser().parse(new FileReader(filename)));
    }

    /** JSON-Konstruktor */
    public Buch(JSONObject jsonObject) {
        super(jsonObject);
    }

    /** Convenience-Konstruktor mit Einzelparametern */
    public Buch(String citekey, String author, String title,
                String publisher, String address, long year,
                String isbn, String comment) {
        super(buildJson(citekey, author, title, publisher, address, year, isbn, comment));
    }

    private static JSONObject buildJson(String citekey, String author, String title,
                                        String publisher, String address, long year,
                                        String isbn, String comment) {
        JSONObject obj = new JSONObject();
        obj.put(CK, citekey);
        obj.put(AUT, author);
        obj.put(TIT, title);
        obj.put(PUB, publisher);
        obj.put(ADD, address);
        obj.put(YR, year);
        obj.put(ISB, isbn);
        obj.put(COM, comment);
        obj.put(CLS, "book");
        return obj;
    }

    @Override
    protected void getSpezifischeFelder(JSONObject obj) {
        this.publisher = (String) obj.get(PUB);
        this.address   = (String) obj.get(ADD);
        this.isbn      = (String) obj.get(ISB);
    }

    @Override
    protected void addSpezifischeFelder() {
        jsonObject.put(PUB, publisher);
        jsonObject.put(ADD, address);
        jsonObject.put(ISB, isbn);
    }
}

