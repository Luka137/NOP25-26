package pckg_batch_processing;

import java.io.File;

public class FileProcessor {

    private BatchProcessor batchProcessor;

    public FileProcessor(){
        System.out.println("Default is TXT batch Processor - initialized!");
        this.batchProcessor = new TXTBatchProcessor();
    }

    public void setBatchProcessor(BatchProcessor batchProcessor){
        this.batchProcessor = batchProcessor;
    }


    public void processFile(File file){
        batchProcessor.processBatch(file);
    }
}
