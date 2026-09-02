package pckg_batch_processing;

import java.util.Arrays;

public record CSVRecord(String[] colNames, String[] vals) {

    @Override
    public String toString() {
        return "CSVRecord{" +
                "colNames=" + Arrays.toString(colNames) +
                ", vals=" + Arrays.toString(vals) +
                '}';
    }
}
