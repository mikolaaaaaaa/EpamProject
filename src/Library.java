import java.io.PrintWriter;
import java.util.ArrayList;

public class Library {
    private ArrayList<Printing> science = new ArrayList<Printing>();
    private ArrayList<Printing> art = new ArrayList<Printing>();
    private ArrayList<Printing> fiction = new ArrayList<Printing>();
    private int cntOfPages;

    public void add(Printing printing) {
        switch (printing.getGenre()) {
            case "science" -> {
                science.add(printing);
            }
            case "art" -> {
                art.add(printing);
            }
            case "fiction" -> {
                fiction.add(printing);
            }
        }
        cntOfPages += printing.getCntPages();
    }

    public void printXML(PrintWriter writer) {
        writer.printf("\t<%s>\n", "Printing");
        for (Printing printing : science) {
            printing.printXML(writer);
        }
        for (Printing printing : art) {
            printing.printXML(writer);
        }
        for (Printing printing : fiction) {
            printing.printXML(writer);
        }
        writer.printf("\t\t<Result>\n");
        writer.printf("\t\t\t<NumberOfPages>%d</NumberOfPages>\n", cntOfPages);
        writer.printf("\t\t\t<NumberOfScience>%d</NumberOfScience>\n", science.size());
        writer.printf("\t\t\t<NumberOfArt>%d</NumberOfArt>\n", art.size());
        writer.printf("\t\t\t<NumberOfFiction>%d</NumberOfFiction>\n", fiction.size());
        writer.printf("\t\t</Result>\n");
        writer.printf("\t</%s>\n\n", "Printing");
    }

    public void printLibrary() {
        System.out.println("Всего страниц " + cntOfPages);
        System.out.println("наука :");
        for (Printing i : science) {
            i.print();
        }
        System.out.println("искусство :");
        for (Printing i : art) {
            i.print();
        }
        System.out.println("художественная литература :");
        for (Printing i : fiction) {
            i.print();
        }
    }

    public int getCntOfPages() {
        return cntOfPages;
    }

    public int getCntOfScience() {
        return science.size();
    }

    public int getCntOfArt() {
        return art.size();
    }

    public int getCntOfFiction() {
        return fiction.size();
    }

}
