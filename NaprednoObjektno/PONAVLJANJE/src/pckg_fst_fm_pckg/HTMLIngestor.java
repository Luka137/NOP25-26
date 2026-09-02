package pckg_fst_fm_pckg;

public class HTMLIngestor extends Ingestor {

    @Override
    protected DocumentParser createDocParser() {
        return new HTMLDocumentParser();
    }
}
