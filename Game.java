import java.util.ArrayList;
import java.util.List;

public class Game {

    private static char[] word;

    private static char[] currWord;

    private static final List<Character> guesses = new ArrayList<>();

    public static void setup() {
        StateMachine.reset();
        guesses.clear();
        Terminal.clearTerminal();
        Terminal.printWelcome();
       try {
           word = Parser.parseCaps(Reader.getRandomLine().toCharArray());
       } catch (Exception e) {
           Terminal.printException(e);
       }
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
                char guess = Terminal.getGuess(guesses);
                guesses.add(guess);
                boolean hit = updateCurrWord(guess);
                if (!hit) {
                    StateMachine.nextState();
                }
            } catch (Exception e) {
                start();
            }

            if (isEqual(word, currWord)) {
                break;
            }
        }
        StateMachine.endGame();
        printResult();
        Terminal.revealWord(word);

        if (Terminal.restart()) {
            start();
        }
    }

    private static void initWord() {
        currWord = new char[word.length];
        for (int i = 0; i < word.length; i++) {
            currWord[i] = '_';
        }
    }

    private static boolean updateCurrWord(char guess) {
        boolean returnvalue = false;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guess) {
                currWord[i] = word[i];
                returnvalue = true;
            }
        }
        return returnvalue;
    }

    private static boolean isEqual(char[] inputOne, char[] inputTwo) {
        for (int i = 0; i < inputOne.length; i++) {
            if (inputOne[i] != inputTwo[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printResult() {
        if (StateMachine.getState() == State.Win) {
            Terminal.printWin();
        } else {
            Terminal.printLose();
        }
    }

}
