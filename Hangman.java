import java.util.*;

public class Hangman {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = { "hangman", "apple", "java", "programming", "computer" };
        String word = words[(int) (Math.random() * words.length)];
        char[] hiddenWord = new char[word.length()];

        for (int i = 0; i < hiddenWord.length; i++) {
            hiddenWord[i] = '_';
        }

        int attempts = 6;
        boolean wordGuessed = false;

        while (attempts > 0 && !wordGuessed) {
            System.out.print("Guess a letter: ");
            char guess = sc.nextLine().charAt(0);
            boolean letterGuessed = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    hiddenWord[i] = guess;
                    letterGuessed = true;
                }
            }

            if (!letterGuessed) {
                attempts--;
                System.out.println("Wrong guess! Attempts left: " + attempts);
            }

            if (word.equals(String.valueOf(hiddenWord))) {
                wordGuessed = true;
            }

            System.out.println(hiddenWord);
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word correctly: " + word);
        } else {
            System.out.println("Game over! You ran out of attempts. The word was: " + word);
        }
    }
}