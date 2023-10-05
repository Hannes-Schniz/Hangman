import java.util.ArrayList;
import java.util.List;

public class Game {

    private static char[] word;

    private static char[] currWord;

    private static boolean hit = false;

    private static List<Character> guesses = new ArrayList<Character>();

    public static void setup() {
        StateMachine.reset();
        Terminal.clearTerminal();
        Terminal.printWelcome();
        word = Terminal.getWord();
        initWord();
    }

    public static void start() {
        setup();

        while (StateMachine.getState() != State.Game_Over) {
            Terminal.clearTerminal();
            Terminal.printHangman(StateMachine.getState().hangman);
            Terminal.printCurrentWord(currWord);
            Terminal.printGuesses(guesses);
            try {
                char guess = Terminal.getChar();
                guesses.add(guess);
                updateCurrWord(guess);
                if (!hit) {
                    StateMachine.nextState();
                }
                hit = false;
            } catch (Exception e) {
                start();
            }
        }
        Terminal.printHangman(StateMachine.getState().hangman);

    }

    private static void initWord() {
        currWord = new char[word.length];
        for (int i = 0; i < word.length; i++) {
            currWord[i] = '_';
        }
    }

    private static void updateCurrWord(char guess) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guess) {
                currWord[i] = word[i];
                hit = true;
            }
        }
    }

}
