package pckg_batch_processing;

public class CSVBatchProcessor extends BatchProcessor {
    @Override
    protected FileParser createFilePaerser() {
        return new CSVFileParser();
    }

    @Override
    protected void processRecords() {
        for(Record record : records){
            System.out.println(record);
        }
    }

    @Override
    protected void writeSummary() {
        System.out.println("Total number of records in csv file: " + records.size());
        System.out.println("Type of the record is: " + (records.isEmpty() ? "N/A" : records.get(0).getClass().getSimpleName()));
    }
}
