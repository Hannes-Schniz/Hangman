import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

public class Terminal {

    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public static char getGuess(List<Character> guesses) throws ParseException {
        try {
            System.out.println("Enter a guess: ");
            String input = readline();
            char guess = Parser.parseCaps(input.charAt(0));
            if (guesses.contains(guess)) {
                System.out.println("You already guessed that!");
                getGuess(guesses);
            }
            return guess;
        } catch (Exception e) {
            throw new ParseException("Error reading input", 0);
        }
    }

    public static void printHangman(String[] hangman) {
        for (String line : hangman) {
            System.out.println(line);
        }
    }

    public static void printWelcome() {
        System.out.println("Welcome to Hangman!");
    }

    public static void printWin() {
        System.out.println("You win!");
    }

    public static void printLose() {
        System.out.println("You lose!");
    }

    public static void revealWord(char[] word) {
        System.out.println("The word was: ");
        for (char c : word) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void printException(Exception e) {
        System.out.println("A error Occured:\n" + e);
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printGuesses(List<Character> guesses) {
        System.out.println("Guesses: ");
        for (char guess : guesses) {
            System.out.print(guess + " ");
        }
        System.out.println();
    }

    public static void printCurrentWord(char[] currWord) {
        System.out.println("Current word: ");
        for (char c : currWord) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static boolean restart() {
        System.out.println("Would you like to play again? (y/n)");
        String input = readline();
        return input.equals("y");
    }

    private static String readline() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            return "";
        }
    }
}
