package pckg_6_1;

public class CSVBatchProcessor extends BatchProcessor{
    @Override
    public FileParser createFileParser() {
        return new CSVFileParser();
    }
}
