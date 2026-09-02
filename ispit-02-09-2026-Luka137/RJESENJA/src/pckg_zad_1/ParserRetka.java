package pckg_zad_1;

public class ParserRetka {

    private static final String RAZDJELNIK = ";";
    private static final int OCEKIVANI_BROJ_POLJA = 5;
    private static final int MIN_DANA = 0;
    private static final int MAX_DANA = 60;
    private static final int MIN_OSTECENJA = 0;
    private static final int MAX_OSTECENJA = 5;

    public PovratGradje parsiraj(String redak) throws NeispravanZapisException {
        if (redak == null || redak.trim().isEmpty()) {
            throw new NeispravanZapisException("prazan redak");
        }
        String[] polja = redak.split(RAZDJELNIK, -1);
        if (polja.length != OCEKIVANI_BROJ_POLJA) {
            throw new NeispravanZapisException("ocekivano " + OCEKIVANI_BROJ_POLJA + " polja, pronadeno " + polja.length);
        }

        String inventarniBroj = provjeriTekst(polja[0], "inventarni broj");
        String naslov = provjeriTekst(polja[1], "naslov");
        String korisnik = provjeriTekst(polja[2], "korisnik");
        int daniKasnjenja = provjeriBroj(polja[3], "dani kasnjenja", MIN_DANA, MAX_DANA);
        int brojOstecenja = provjeriBroj(polja[4], "broj ostecenja", MIN_OSTECENJA, MAX_OSTECENJA);

        return new PovratGradje(inventarniBroj, naslov, korisnik, daniKasnjenja, brojOstecenja);
    }

    private String provjeriTekst(String vrijednost, String nazivPolja) throws NeispravanZapisException {
        String ocisceno = vrijednost.trim();
        if (ocisceno.isEmpty()) {
            throw new NeispravanZapisException("prazno polje: " + nazivPolja);
        }
        return ocisceno;
    }

    private int provjeriBroj(String vrijednost, String nazivPolja, int min, int max) throws NeispravanZapisException {
        String ocisceno = vrijednost.trim();
        int broj;
        try {
            broj = Integer.parseInt(ocisceno);
        } catch (NumberFormatException e) {
            throw new NeispravanZapisException(nazivPolja + " nije cijeli broj: '" + ocisceno + "'");
        }
        if (broj < min || broj > max) {
            throw new NeispravanZapisException(nazivPolja + " izvan raspona " + min + "-" + max + ": " + broj);
        }
        return broj;
    }
}