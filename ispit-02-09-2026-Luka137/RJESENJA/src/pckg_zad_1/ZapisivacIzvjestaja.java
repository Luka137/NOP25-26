package pckg_zad_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ZapisivacIzvjestaja {

    public void zapisiIzvjestaj(String relativnaPutanja, List<PovratGradje> zapisi) throws IOException {
        try (BufferedWriter pisac = new BufferedWriter(new FileWriter(relativnaPutanja))) {
            for (int i = 0; i < zapisi.size(); i++) {
                pisac.write(zapisi.get(i).toString());
                pisac.newLine();
            }

            SazetakIzvjestaja sazetak = new SazetakIzvjestaja(zapisi);
            pisac.newLine();
            pisac.write("SAZETAK");
            pisac.newLine();
            pisac.write("Ukupno ispravnih zapisa: " + sazetak.getUkupnoZapisa());
            pisac.newLine();
            pisac.write("Uredno: " + sazetak.getBrojUrednih());
            pisac.newLine();
            pisac.write("Kašnjenje: " + sazetak.getBrojKasnjenja());
            pisac.newLine();
            pisac.write("Oštećeno: " + sazetak.getBrojOstecenih());
            pisac.newLine();
            pisac.write(String.format(Locale.ROOT, "Ukupna naknada: %.2f EUR", sazetak.getUkupnaNaknada()));
            pisac.newLine();
        }
    }

    public void zapisiGreske(String relativnaPutanja, List<GreskaUcitavanja> greske) throws IOException {
        try (BufferedWriter pisac = new BufferedWriter(new FileWriter(relativnaPutanja))) {
            for (int i = 0; i < greske.size(); i++) {
                pisac.write(greske.get(i).toString());
                pisac.newLine();
            }
        }
    }
}