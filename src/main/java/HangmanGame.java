public class HangmanGame {

    public static void main(String[] args) {

        Hangman hangman = new Hangman("autopilot");
        System.out.println(hangman.getGuessedWord());
    }
}
