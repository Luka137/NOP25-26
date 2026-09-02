package pckg_fst_fm_pckg;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DOCXDocumentParser implements DocumentParser {

    @Override
    public IngestedDocument parseDocument(RAWDocument rawDocument) {

        String extractedContent = "[DOCX-TEXT] - " + new String(rawDocument.getFileByteContent(), StandardCharsets.UTF_8);
        Map<String, String> metaData = new LinkedHashMap<>();

        metaData.put("mime", "app/docx");
        metaData.put("extraction", "poi-like");
        metaData.put("author", "Name...");

        return new IngestedDocument(rawDocument.getSourceID(), "DOCX",  extractedContent, metaData);
    }
}
