package pckg_6_1;

import java.io.File;
import java.util.List;

public class XMLFileParser implements FileParser{

    public XMLFileParser() {
        System.out.println("\nCreating JSON file parser... ");
    }

    @Override
    public List<Record> parse(File file) {
        System.out.println("Parsing process specific to the XML file type!!!");
        System.out.println("Parsing file -> " + file.toString() + " and creating records...");
        return null;
    }
}
