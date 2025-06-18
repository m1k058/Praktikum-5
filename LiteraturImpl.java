// Datei: LiteraturImpl.java
import org.json.simple.JSONObject;

/**
 * Abstrakte Basisklasse für alle Literaturtypen.
 * Diese implementiert das Interface Literatur und enthält gemeinsamen Code.
 */
public abstract class LiteraturImpl implements Literatur {
    protected static final String CLS = "class";
    protected static final String CK  = "citekey";
    protected static final String AUT = "author";
    protected static final String TIT = "title";
    protected static final String YR  = "year";
    protected static final String COM = "comment";

    protected String citekey;
    protected String author;
    protected String title;
    protected long year;
    protected String comment;
    protected JSONObject jsonObject;

    public LiteraturImpl(JSONObject jsonObject) {
        parseGemeinsameFelder(jsonObject);
    }

    private void parseGemeinsameFelder(JSONObject obj) {
        this.citekey = (String) obj.get(CK);
        this.author  = (String) obj.get(AUT);
        this.title   = (String) obj.get(TIT);
        this.year    = (Long)   obj.get(YR);
        this.comment = (String) obj.get(COM);
        getSpezifischeFelder(obj);
        erzeugeJson();
    }

    protected void erzeugeJson() {
        this.jsonObject = new JSONObject();
        this.jsonObject.put(CLS, getClass().getSimpleName().toLowerCase());
        this.jsonObject.put(CK,  citekey);
        this.jsonObject.put(AUT, author);
        this.jsonObject.put(TIT, title);
        this.jsonObject.put(YR,  year);
        this.jsonObject.put(COM, comment);
        addSpezifischeFelder();
    }

    protected abstract void getSpezifischeFelder(JSONObject obj);
    protected abstract void addSpezifischeFelder();

    @Override
    public void ausgeben() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return jsonObject.toString()
                         .replace("{", "\t{\n\t")
                         .replaceAll(",\"", ",\n\t\t\"")
                         .replace("}", "\n\t}");
    }
}