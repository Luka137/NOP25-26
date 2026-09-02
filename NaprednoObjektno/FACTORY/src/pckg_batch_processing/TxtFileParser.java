package pckg_batch_processing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtFileParser implements FileParser {
    @Override
    public List<Record> parseFile(File file) {
        List<Record> records = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            int cntrLine = 0;
            while((line = br.readLine()) != null) {
                String lineName = "Line-"+cntrLine++;
                LineRecord lineRecord = new LineRecord(lineName, line);
                records.add(lineRecord);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found on the path!");
        } catch (IOException e) {
            System.out.println("I/O exception - unable to read from a file!");
        }
        return records;
    }
}
