package pckg_fst_exc;

public class TimeBonusScoring implements ScoringStrategy {
    @Override
    public int calculate(Answer answer) {
        if(!answer.isCorrect()){
            return 0;
        };
        int bonus = 0;
        if(answer.getTimeInSeconds() < 5){
            bonus = 5;
        }
        return 10 + bonus;
    }
}


