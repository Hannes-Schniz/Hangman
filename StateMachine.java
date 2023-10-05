public class StateMachine {
    static private State currState = State.Setup;

    public static State nextState() {
        switch (currState) {
            case Setup:
                currState = State.Stage_One;
                break;
            case Stage_One:
                currState = State.Stage_Two;
                break;
            case Stage_Two:
                currState = State.Stage_Three;
                break;
            case Stage_Three:
                currState = State.Stage_Four;
                break;
            case Stage_Four:
                currState = State.Stage_Seven;
                break;
            case Stage_Seven:
                currState = State.Stage_Eight;
                break;
            case Stage_Eight:
                currState = State.Stage_Nine;
                break;
            case Stage_Nine:
                currState = State.Game_Over;
                break;
            default:
                break;
        }
        return currState;
    }

    public static State getState() {
        return currState;
    }

    public static void reset() {
        currState = State.Setup;
    }
}
