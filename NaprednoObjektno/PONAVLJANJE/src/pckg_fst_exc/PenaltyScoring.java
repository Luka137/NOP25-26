package pckg_fst_exc;

public class PenaltyScoring implements ScoringStrategy {
    @Override
    public int calculate(Answer answer) {
        if(answer.isCorrect()){
            return 10;
        };
        if(answer.isWrong()){
            return -5;
        }
        return 0;
    }
}
