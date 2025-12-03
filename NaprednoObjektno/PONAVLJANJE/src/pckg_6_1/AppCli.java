package pckg_6_1;

import java.io.File;

public class AppCli {

    public static void main(String[] args) {

        File file1 = new File("C://Documents/fileName.json");
        File file2 = new File("someFile.csv");
        File file3 = new File("Fle.txt");

        BatchProcessor bp1 = createBatchProcessor(getFileExtension(file1.getName()));
        BatchProcessor bp2 = createBatchProcessor(getFileExtension(file2.getName()));
        BatchProcessor bp3 = createBatchProcessor(getFileExtension(file3.getName()));

        if (bp1 != null) bp1.processBatch(file1);
        if (bp2 != null) bp2.processBatch(file2);
        if (bp3 != null) bp3.processBatch(file3);
    }

    private static String getFileExtension(String file) {
        if (file.contains(".")) {
            return file.substring(file.lastIndexOf(".") + 1);
        }
        return null;
    }

    private static BatchProcessor createBatchProcessor(String ext) {
        switch(ext) {
            case "txt": return new TXTBatchProcessor();
            case "csv": return new CSVBatchProcessor();
            case "json": return new JSONBatchProcessor();
            default:
                System.out.println("There is no BatchProcessor for such file type yet !!!");
                return null;
        }
    }
}
