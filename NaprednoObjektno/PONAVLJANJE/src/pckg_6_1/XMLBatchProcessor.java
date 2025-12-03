package pckg_6_1;

public class XMLBatchProcessor extends BatchProcessor{

    @Override
    public FileParser createFileParser() {
        return new XMLFileParser();
    }
}
