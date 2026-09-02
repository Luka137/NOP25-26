package pckg_fst_fm_pckg;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class IngestedDocument {

    private final String sourceID;

    private final String docFormat;

    private final String plainDocContent;

    private final Map<String, String> metaData;

    public IngestedDocument(String sourceID, String docFormat, String plainDocContent, Map<String, String> metaData) {
        this.sourceID = Objects.requireNonNull(sourceID);
        this.docFormat = Objects.requireNonNull(docFormat);
        this.plainDocContent = Objects.requireNonNull(plainDocContent);
        this.metaData = Collections.unmodifiableMap(metaData);
    }

    @Override
    public String toString() {
        return "IngestedDocument{" +
                "sourceID='" + sourceID + '\'' +
                ", docFormat='" + docFormat + '\'' +
                ", plainDocContent='" + plainDocContent + '\'' +
                ", metaData=" + metaData +
                '}';
    }
}
