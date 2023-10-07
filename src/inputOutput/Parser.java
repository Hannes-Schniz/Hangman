package src.inputOutput;

public class Parser {

    public static char[] parseCaps (char[] input){
        for (int i = 0; i < input.length; i++) {
            input[i] = Character.toUpperCase(input[i]);
        }
        return input;
    }

    public static char parseCaps(char input) {
        return Character.toUpperCase(input);
    }
}
