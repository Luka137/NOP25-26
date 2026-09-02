package pckg_fst_fm_pckg;

public class PDFIngestor extends Ingestor{
    @Override
    protected DocumentParser createDocParser() {
        return new PDFDocumentParser();
    }
}
