package pckg_batch_processing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser implements FileParser {
    @Override
    public List<Record> parseFile(File file) {
        List<Record> records = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] columns = br.readLine().split(",");
            String line = null;
            while( (line = br.readLine()) != null ) {
                String [] values = line.split(",");
                CSVRecord csvRecord = new CSVRecord(columns, values);
                records.add(csvRecord);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Some I/O exception!");
        }
        return records;
    }
}
