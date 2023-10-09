import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Hangman {

    private String secretWord;
    private int attempts;
    private StringBuilder guessedWord;
    private HashSet<Character> guessedLetters;
    private HangmanParts hangmanStage;

    public Hangman() {
        this.secretWord = takeRandomWordFromFile("nouns.txt");
        this.attempts = 7;
        this.guessedWord = new StringBuilder("_".repeat(secretWord.length()));
        this.guessedLetters = new HashSet<>();
        this.hangmanStage = HangmanParts.START;
    }

    // A method, that contains game loop
    public void play() {
        Scanner scanner = new Scanner(System.in);
        int remainingAttempts = attempts;

        while (remainingAttempts > 0) {
            System.out.printf("Attempts remaining: %d\n", remainingAttempts);
            System.out.printf("Secret word: %s\n", guessedWord);
            System.out.print("Enter a letter: ");

            char guessedLetter = scanner.next().charAt(0);

            // Checks if the letter was entered by a player in this game
            if (guessedLetters.contains(guessedLetter)) {
                System.out.println("Invalid attempt. You already guessed this letter before.");
                continue;
            }

            // Each letter, that was already entered by a player is inserted to guessedLetters set
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
                // If guessed letter is not in a secret word, a message and next hangman stage is printed, remainingAttempts are deducted
                System.out.printf("I'm sorry, letter '%c' is not contained in a secret word.\n", guessedLetter);
                hangmanStage = hangmanStage.getNextStage();
                System.out.printf("Hangman stage:\n%s", hangmanStage.getArt());
                remainingAttempts--;
            }

            // If there are no more remaining attempts left => game over
            if (remainingAttempts == 0) {
                System.out.println("Game over! You are out of attempts.");
                System.out.printf("The secret word was: %s\n", secretWord);
            }
        }
    }

    // Picks a random word from a file (words must be each on a separate line)
    private String takeRandomWordFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        Random random = new Random();
        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String word = bf.readLine();
            while (word != null) {
                words.add(word);
                word = bf.readLine();
            }
        } catch (IOException e) {
            System.out.printf("I/O error: %s\n", e.getMessage());
        }

        return words.get(random.nextInt(words.size()));
    }
}
