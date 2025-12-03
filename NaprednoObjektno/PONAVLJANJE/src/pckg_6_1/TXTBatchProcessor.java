package pckg_6_1;

public class TXTBatchProcessor extends BatchProcessor{

    @Override
    public FileParser createFileParser() {
        return new TextFileParser();
    }
}
