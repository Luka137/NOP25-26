package pckg_batch_processing;

import java.io.File;
import java.util.List;

public abstract class BatchProcessor {

    protected List<Record> records;

    public void processBatch(File file){
        FileParser fileParser = createFilePaerser();
        if(fileParser != null){
            records = fileParser.parseFile(file);
            processRecords();
            writeSummary();
        }
    }

    protected abstract FileParser createFilePaerser();
    protected abstract void processRecords();
    protected abstract void writeSummary();
}
