package pckg_batch_processing;

import java.lang.Record;

public class JSONBatchProcessor extends BatchProcessor {
    protected FileParser createFilePaerser() {
        return new JSONFileParser();
    }

    protected void processRecords() {
        for(Record record : records){
            System.out.println(record);
        }
    }

    protected void writeSummary() {
        System.out.println("Total number of records: " + records.size());
        System.out.println("Type of the records in a file: " + (records.isEmpty() ? "N/A" : records.get(0).getClass().getSimpleName()));
    }
}
