package pckg_fst_fm_pckg;

import java.nio.charset.StandardCharsets;

public class TestApp {
    static void main(String[] args) {
        RAWDocument pdf = new RAWDocument("123123123", "title.pdf", "Deep learning is the subfield of the ML ...".getBytes(StandardCharsets.UTF_8));
        RAWDocument docx = new RAWDocument("123123", "seminar.docx", "U okviru ovog seminarskog rada ...".getBytes(StandardCharsets.UTF_8));
        RAWDocument html = new RAWDocument("123", "web_page_1.html", "<html- Welcome to the jungle".getBytes(StandardCharsets.UTF_8));

        IngestorManager ingestorManager = new IngestorManager();
        ingestorManager.ingestDocument(pdf);
        ingestorManager.setIngestor(new DOCXIngestor());
        ingestorManager.ingestDocument(docx);
        ingestorManager.setIngestor(new HTMLIngestor());
        ingestorManager.ingestDocument(html);
    }
}
