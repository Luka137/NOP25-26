package pckg_fst_fm_pckg;

public class DOCXIngestor extends Ingestor{

    @Override
    protected DocumentParser createDocParser() {
        return new DOCXDocumentParser();
    }
}
