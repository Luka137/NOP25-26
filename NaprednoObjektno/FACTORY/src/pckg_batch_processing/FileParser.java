package pckg_batch_processing;

import java.io.File;
import java.util.List;

public interface FileParser {

    List<Record> parseFile(File file);


}
