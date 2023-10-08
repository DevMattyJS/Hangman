import java.util.HashSet;
import java.util.Scanner;

public class Hangman {

    private String secretWord;
    private int attempts;
    private StringBuilder guessedWord;
    private HashSet<Character> guessedLetters;

    public Hangman(String secretWord) {
        this.secretWord = secretWord;
        this.attempts = 7;
        this.guessedWord = new StringBuilder("_".repeat(secretWord.length()));
        this.guessedLetters = new HashSet<>();
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

            if (secretWord.indexOf(guessedLetter) >= 0) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if(secretWord.charAt(i) == guessedLetter) {
                        guessedWord.setCharAt(i, guessedLetter);
                    }
                }
            } else {
                remainingAttempts--;
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
