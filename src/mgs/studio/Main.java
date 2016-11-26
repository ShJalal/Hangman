package mgs.studio;

public class Main {

    public static void main(String[] args) {
        Game game = new Game("fAtIhUlulum");
        Prompter prompter = new Prompter(game);
        prompter.play();
    }
}
