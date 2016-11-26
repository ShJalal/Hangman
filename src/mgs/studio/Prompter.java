package mgs.studio;

import java.util.Scanner;

public class Prompter {
    Scanner id = new Scanner(System.in);
    private Game mGame;

    public Prompter(Game game){
        mGame = game;
    }

    public void play(){
        while (mGame.getRemainingTries() > 0 && !mGame.isSolved()){
            displayProgress();
            promptForGuess();
        }
        if (mGame.isSolved()){
            System.out.printf("Congratulations you won with %d tries remaining " +
                            "and the Word is %s" ,
                    mGame.getRemainingTries(),mGame.mAnswer);
        }else{
            System.out.printf("Bummer the word Was \"%s\" \n",
                    mGame.getAnswer());
        }
    }

    public boolean promptForGuess(){
       Boolean isHit = false;
       Boolean isValidGuess = false;
       while (! isValidGuess){
           System.out.print("Enter a Letter : " );
           String guessAsString = id.next();
           char guess = guessAsString.charAt(0);
            try {
                isHit = mGame.applyGuess(guess);
                isValidGuess = true;
            }catch (IllegalArgumentException iae){
                System.out.printf("%s . Please try again \n", iae.getMessage());
            }
       }
       return isHit;
    }

    public void displayProgress(){
        System.out.printf("You have %d tries  to solve : %s\n",
                mGame.getRemainingTries(),
                mGame.getCurrentProgress());
    }

}
