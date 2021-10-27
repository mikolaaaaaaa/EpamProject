import java.io.PrintWriter;
import java.util.*;

public class Library {

    private SortedMap<String,ArrayList<Printing>> literatureMap = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.hashCode() - o2.hashCode();
        }
    });
    private int cntOfPages;

    public void add(Printing printing) {

        if (literatureMap.containsKey(printing.getGenre())) {
            literatureMap.get(printing.getGenre()).add(printing);
        }
        else {
            ArrayList<Printing> temp = new ArrayList<Printing>();
            temp.add(printing);
            literatureMap.put(printing.getGenre(),temp);
        }
        cntOfPages += printing.getCntPages();
    }

    public void printXML(PrintWriter writer) {
        writer.printf("\t<%s>\n", "Printing");
        for (Printing printing : literatureMap.get("science")) {
            printing.printXML(writer);
        }
        for (Printing printing : literatureMap.get("art")) {
            printing.printXML(writer);
        }
        for (Printing printing : literatureMap.get("fiction")) {
            printing.printXML(writer);
        }
        writer.printf("\t\t<Result>\n");
        writer.printf("\t\t\t<NumberOfPages>%d</NumberOfPages>\n", cntOfPages);
        writer.printf("\t\t\t<NumberOfScience>%d</NumberOfScience>\n", literatureMap.get("science").size());
        writer.printf("\t\t\t<NumberOfArt>%d</NumberOfArt>\n", literatureMap.get("art").size());
        writer.printf("\t\t\t<NumberOfFiction>%d</NumberOfFiction>\n", literatureMap.get("fiction").size());
        writer.printf("\t\t</Result>\n");
        writer.printf("\t</%s>\n\n", "Printing");
    }

    public int getCntOfPages() {
        return cntOfPages;
    }

}
