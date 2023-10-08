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
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);




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
