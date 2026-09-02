package pckg_fst_fm_pckg;

public class IngestorManager {

    private Ingestor ingestor;

    public IngestorManager(){
        this.ingestor = new PDFIngestor();
    }

    public void setIngestor(Ingestor ingestor){
        this.ingestor = ingestor;
    }

    public void ingestDocument(RAWDocument rawDocument){
        IngestedDocument ingestedDocument = ingestor.ingestDocument(rawDocument);
        System.out.println(ingestedDocument);
    }
}
