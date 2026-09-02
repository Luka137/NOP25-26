package pckg_batch_processing;

public class TXTBatchProcessor extends BatchProcessor {

    @Override
    protected FileParser createFilePaerser() {
        return new TxtFileParser();
    }

    @Override
    protected void processRecords() {
        for(Record record : records){
            System.out.println(record);
        }
    }

    @Override
    protected void writeSummary() {
        System.out.println("Total records in this file: " + records.size());
        System.out.println("Type of the record: " + (records.isEmpty() ? "N/A" : records.get(0).getClass().getSimpleName()));
    }
}
