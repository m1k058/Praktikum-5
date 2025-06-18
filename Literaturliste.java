import java.util.List;
import java.util.ArrayList;
// first standard java libs then further libs
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * Eine Klasse, deren Instanzen Informationen über eine BuecherListe halten.
 * Dies könnte Teil einer größeren Anwendung sein, einer
 * Bibliothekssoftware beispielsweise.
 *
 * @author Wolfgang Renz
 * @version April 2025
 */
class Literaturliste
{
    // konstante Klassenvariable, die unabhängig von Instanzen existiert
    private static final String DefaultFILE = "Literatur.json";

    // Instanzvariablen
    private final List<Literatur> literatur;

    /**
     * default constructor, reads from default file
     * 
     */
    public Literaturliste() throws Exception
    {
        this(DefaultFILE);
    }

    /**
     * constructor by reading booklist from JSON file.
     */
    public Literaturliste(String filename) throws Exception
    {
        this.literatur = new ArrayList<Literatur>();
        fillFromJSONfile(filename);
    }

    private void fillFromJSONfile(String filename) throws Exception
    {
        assert (filename != null && filename.contains(".json"));
        JSONParser parser = new JSONParser();
        // now read json file content:
        JSONObject bibliography = (JSONObject) 
            parser.parse(new java.io.FileReader(filename));
        // now parse top JSONObject:
        // first you get the value of key "bibliography" which is an array:
        JSONArray books = (JSONArray) bibliography.get("bibliography");
        // now you iterate over the array of books:
        for( Object obj: books){ // the json map just contains objects
            // we know these are JSONObjects:
            JSONObject jsonObject = (JSONObject) obj;
            String klasse = (String) jsonObject.get("class");
            switch (klasse) {
                case "book":
                    literatur.add(new Buch(jsonObject));
                    break;
                case "misc":
                    literatur.add(new Website(jsonObject));
                    break;
                case "unpublished":
                    literatur.add(new Unveroeffentlicht(jsonObject));
                    break;
                }
        }
    }

    public void fuegeLiteraturHinzu(Literatur buch)
    {
        literatur.add(buch);
    }

    public void ausgeben()
    {
        System.out.println("{\n\t\"bibliography\":[");
        for( Literatur b: literatur){
            b.ausgeben();
        }
        System.out.println("\t]\n}");
    }
    // weitere Methoden hier einfügen ...
}
