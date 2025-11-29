package pckg_fst_exc;


public class TestApp {
    static void main(String[] args) {
        Answer prvi = new Answer(true, false, 3);
        Answer drugi = new Answer(false, true, 7);
        Answer treci = new Answer(true, false, 8);
        StandardScoring standard =  new StandardScoring();
        PenaltyScoring penalty =  new PenaltyScoring();
        TimeBonusScoring timeBonus = new TimeBonusScoring();
        System.out.println(standard.calculate(prvi));
        System.out.println(standard.calculate(drugi));
        System.out.println(standard.calculate(treci));
        System.out.println(penalty.calculate(prvi));
        System.out.println(penalty.calculate(drugi));
        System.out.println(penalty.calculate(treci));
        System.out.println(timeBonus.calculate(prvi));
        System.out.println(timeBonus.calculate(drugi));
        System.out.println(timeBonus.calculate(treci));

    }
}
