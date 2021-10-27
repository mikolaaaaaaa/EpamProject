import java.io.PrintWriter;

public class Printing {
    String name;
    private int cntPages;
    private int yearOfPublished;
    private String publisher;
    private String genre;
    private String type;

    Printing(){}

    public Printing(int cntPages, int yearOfPublishing, String publisher, String genre, String type) {
        this.cntPages = cntPages;
        this.yearOfPublished = yearOfPublishing;
        this.publisher = publisher;
        this.genre = genre;
    }

    public void printXML(PrintWriter writer) {
        writer.printf("\t\t<%s>\n", this.type);
        writer.printf("\t\t\t<name>%s</name>\n",  this.name);
        writer.printf("\t\t\t<cntPages>%s</cntPages>\n",  this.cntPages);
        writer.printf("\t\t\t<yearOfPublished>%s</yearOfPublished>\n", this.yearOfPublished);
        writer.printf("\t\t\t<publisher>%s</publisher>\n",this.publisher);
        writer.printf("\t\t\t<genre>%s</genre>\n", this.genre);
        writer.printf("\t\t</%s>\n",this.type);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCntPages() {
        return cntPages;
    }

    public void setCntPages(int cntPages) {
        this.cntPages = cntPages;
    }

    public int getYearOfPublishing() {
        return yearOfPublished;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublished = yearOfPublishing;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}
