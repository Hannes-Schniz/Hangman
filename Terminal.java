import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Terminal {

    private static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public static char getChar() throws ParseException {
        // reads a input from console
        try {
            System.out.println("Enter a character: ");
            String input = readline();
            return input.charAt(0);
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

    public static char[] getWord() {
        System.out.println("Enter a word: ");
        return readline().toCharArray();
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

    private static String readline() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            return "";
        }
    }
}
