import java.util.HashSet;
import java.util.Scanner;

public class Hangman {

    private String secretWord;
    private int attempts;
    private StringBuilder guessedWord;
    private HashSet<Character> guessedLetters;
    private HangmanParts hangmanStage;

    public Hangman(String secretWord) {
        this.secretWord = secretWord;
        this.attempts = 7;
        this.guessedWord = new StringBuilder("_".repeat(secretWord.length()));
        this.guessedLetters = new HashSet<>();
        this.hangmanStage = HangmanParts.START;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int remainingAttempts = attempts;

        while (remainingAttempts > 0) {
            System.out.printf("Attempts remaining: %d\n", remainingAttempts);
            System.out.printf("Secret word: %s\n", guessedWord);
            System.out.println("Enter a letter: ");
            char guessedLetter = scanner.next().charAt(0);

            if (guessedLetters.contains(guessedLetter)) {
                System.out.println("Invalid attempt. You already guessed this letter before.");
                continue;
            }

            guessedLetters.add(guessedLetter);

            // If the letter player guessed is in the secret word => replace all "_" at correct positions by that letter
            if (secretWord.indexOf(guessedLetter) >= 0) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if(secretWord.charAt(i) == guessedLetter) {
                        guessedWord.setCharAt(i, guessedLetter);
                    }
                }
                // Checks if there are no more "_" characters in a guessed word  => player wins, if that is the case
                if (guessedWord.indexOf("_") < 0) {
                    System.out.printf("Congratulations, you guessed the secret word: %s\n", secretWord);
                    break;
                }
            } else {
                System.out.printf("I'm sorry, letter '%c' is not contained in a secret word.\n", guessedLetter);
                hangmanStage = hangmanStage.getNextStage();
                System.out.printf("Hangman stage:\n%s", hangmanStage.getArt());
                remainingAttempts--;
            }

            if (remainingAttempts == 0) {
                System.out.println("Game over! You are out of attempts.");
            }
        }
    }

    public String getSecretWord() {
        return secretWord;
    }

    public int getAttempts() {
        return attempts;
    }

    public StringBuilder getGuessedWord() {
        return guessedWord;
    }

    public HashSet<Character> getGuessedLetters() {
        return guessedLetters;
    }
}
