package pckg_fst_exc;

public class Answer {
    private boolean correct;
    private boolean wrong;
    private int timeInSeconds;

    public Answer(boolean correct, boolean wrong, int timeInSeconds) {
        this.correct = correct;
        this.wrong = wrong;
        this.timeInSeconds = timeInSeconds;
    }

    public boolean isCorrect(){
        return correct;
    }
    public boolean isWrong(){
        return wrong;
    }
    public int getTimeInSeconds(){
        return timeInSeconds;
    }
}
