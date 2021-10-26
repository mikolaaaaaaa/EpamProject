import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String args[]) throws ParserConfigurationException, IOException, SAXException {

        File file = setFile("C:\\Users\\Mikola\\IdeaProjects\\EpamProject\\src\\Printing.xml");
        Document doc = setFactory(file);
        Library library = parser(doc);


        File out = setFile("C:\\Users\\Mikola\\IdeaProjects\\EpamProject\\src\\Result.xml");
        try (PrintWriter writer = new PrintWriter(out)) {
            library.printXML(writer);
        }

    }

    public static File setFile(String PATH) {
        return new File(PATH);
    }

    private static Document setFactory(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse(file);
        return doc;
    }

    private static Library parser(Document doc) {

        Library library = new Library();
        Node root = doc.getFirstChild();
        NodeList nodeList = root.getChildNodes();



        for (int i = 0; i < nodeList.getLength(); i++) {
            Printing printing = new Printing();
            if (nodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            NodeList obj = nodeList.item(i).getChildNodes();
            printing.setType(nodeList.item(i).getNodeName());

            for (int j = 0; j < obj.getLength(); j++) {

                if (obj.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch (obj.item(j).getNodeName()) {
                    case "name" -> {
                        printing.setName(obj.item(j).getTextContent());
                    }
                    case "cntPages" -> {
                        printing.setCntPages(Integer.parseInt(obj.item(j).getTextContent()));
                    }
                    case "yearOfPublished" -> {
                        printing.setYearOfPublishing(Integer.parseInt(obj.item(j).getTextContent()));
                    }
                    case "publisher" -> {
                        printing.setPublisher(obj.item(j).getTextContent());
                    }
                    case "genre" -> {
                        printing.setGenre(obj.item(j).getTextContent());
                    }
                }
            }
            library.add(printing);
        }
        return library;
    }

}
