package mgs.studio;

public class Game {
    public static final int MAX_MISSES = 7;
    public String mAnswer;
    private String mHints;
    private String mMisses;
    public Game(String answer){
        mAnswer = answer.toLowerCase();
        mHints = "";
        mMisses ="";
    }
    private char validateGuess(char letter){
        if (! Character.isLetter(letter)){
            throw new  IllegalArgumentException("A Letter is required ");
        }
        letter = Character.toLowerCase(letter);
        if (mMisses.indexOf(letter) >= 0 || mHints.indexOf(letter) >=0 ){
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
        return letter;
    }

    public boolean applyGuess(char letter){
        letter = validateGuess(letter);
        boolean isHit = mAnswer.indexOf(letter) >= 0;
        if (isHit){
            mHints += letter;
        }else{
            mMisses += letter;
        }
        return isHit;
    }

    public String getCurrentProgress(){
        String progress = "";
        for (char letter: mAnswer.toCharArray()) {
            char display = '-';
            if (mHints.indexOf(letter) >= 0){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public int getRemainingTries(){
        return MAX_MISSES - mMisses.length();
    }
    public String getAnswer(){
        return mAnswer;
    }
    public boolean isSolved(){
        return getCurrentProgress().indexOf('-') == -1;
    }
}
