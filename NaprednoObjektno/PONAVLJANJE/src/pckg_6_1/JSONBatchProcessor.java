package pckg_6_1;

public class JSONBatchProcessor extends BatchProcessor{
    @Override
    public FileParser createFileParser() {
        return new JSONFileParser();
    }
}
