package src.gamestate;

public class StateMachine {
    static private State currState = State.Setup;

    public static void nextState() {
        switch (currState) {
            case Setup -> currState = State.Stage_One;
            case Stage_One -> currState = State.Stage_Two;
            case Stage_Two -> currState = State.Stage_Three;
            case Stage_Three -> currState = State.Stage_Four;
            case Stage_Four -> currState = State.Stage_Five;
            case Stage_Five -> currState = State.Stage_Six;
            case Stage_Six -> currState = State.Stage_Seven;
            case Stage_Seven -> currState = State.Game_Over;
            default -> {
            }
        }
    }

    public static State getState() {
        return currState;
    }

    public static void reset() {
        currState = State.Setup;
    }

    public static void endGame() {
        if (currState == State.Game_Over) {
            currState = State.Lost;
        } else {
            currState = State.Win;
        }
    }
}
