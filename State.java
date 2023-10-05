public enum State {
    Setup(Hangman.HANGMAN_8), Stage_One(Hangman.HANGMAN_7), Stage_Two(Hangman.HANGMAN_6),
    Stage_Three(Hangman.HANGMAN_5), Stage_Four(Hangman.HANGMAN_4),
    Stage_Five(Hangman.HANGMAN_3), Stage_Six(Hangman.HANGMAN_2), Stage_Seven(Hangman.HANGMAN_1),
    Game_Over(Hangman.HANGMAN);

    public final String[] hangman;

    private State(String[] hangman) {
        this.hangman = hangman;
    }
}
