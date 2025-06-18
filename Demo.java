
/**
 * class Demo demonstrates capabilities of depending classes
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demo
{
    // We do not need to define a default Constructor
    // if no initializaions of any fields are required

    /**
     * Methode bookdemo
     * 
     * Ein Buch-Objekt soll aus der json-Datei "book.json" erzeugt werden
     * und sich auf dem Terminal ausgeben
     *
     */
    public void bookdemo() throws Exception
    {
        new Buch("book.json").ausgeben();
    } 

    /**
     * Methode booklistdemo
     * 
     * Ein Buecherliste-Objekt soll mit dem default constructor erzeugt werden
     * und sich auf dem Terminal ausgeben
     *
     */
    public void booklistdemo() throws Exception
    {
        new Literaturliste("Literatur.json").ausgeben();
    } 

    /**
     * Methode finaldemo
     * 
     * ein Buch-Objekt soll mit Autor, Erscheinungsjahr und ferner
     * Titel ("title")
     * Verlag ("publisher")
     * und Kommentar ("comment")
     * erzeugt, der Buecherliste hinzugefügt
     * und auf dem Terminal ausgegeben werden.
     *
     */
    public void finaldemo() throws Exception
    {
        Literaturliste buchliste = new Literaturliste();
        buchliste.fuegeLiteraturHinzu(new Buch("cedric2025", "Wilke", "Das Buch", "Der Verlag", "Die Adresse", 2010, "12345678901", "Gutes Buch"));
        buchliste.ausgeben();
    }

    /**
     * Methode unpublishedDemo
     * 
     * Instanziiert ein Unveroeffentlicht-Objekt und gibt es aus.
     *
     */
    void unpublishedDemo() throws Exception
    {
        Unveroeffentlicht unveroeffentlicht = new Unveroeffentlicht("Unveroeffentlicht.json");
        unveroeffentlicht.ausgeben();
    }

    /**
     * Methode miscDemo
     * 
     * Instanziiert ein Website-Objekt und gibt es aus.
     *
     */
    void miscDemo() throws Exception
    {
        Website website = new Website("Website.json");
        website.ausgeben();
    }

    void literaturlisteDemo() throws Exception
    {
        Literaturliste liste = new Literaturliste("Literatur.json");
        liste.ausgeben();
    }
}
