package pckg_zad_2;

public final class FormValidator {

    private FormValidator() {
    }

    public static void validirajOznaku(String oznaka) {
        if (oznaka == null || oznaka.trim().isEmpty()) {
            throw new IllegalArgumentException("Oznaka vozila ne smije biti prazna");
        }
    }

    public static void validirajModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model ne smije biti prazan");
        }
    }

    public static int validirajBrojSjedala(String brojSjedalaTekst) {
        int brojSjedala;
        try {
            brojSjedala = Integer.parseInt(brojSjedalaTekst);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Broj sjedala mora biti cijeli broj");
        }

        if (brojSjedala < 1 || brojSjedala > 20) {
            throw new IllegalArgumentException("Broj sjedala mora biti u rasponu 1-20");
        }

        return brojSjedala;
    }
}