package pckg_batch_processing;

import java.io.File;

public class AppTest {

    static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        File txtFile = new File("FACTORY/src/pckg_batch_processing/data.txt");
        fileProcessor.processFile(txtFile);
        fileProcessor.setBatchProcessor(new CSVBatchProcessor());
        File csvFile = new File("FACTORY/src/pckg_batch_processing/data.csv");
        fileProcessor.processFile(csvFile);
    }
}
