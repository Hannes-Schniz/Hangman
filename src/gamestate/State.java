package src.gamestate;

import src.data.Hangman;

public enum State {
    Setup(Hangman.HANGMAN_1), Stage_One(Hangman.HANGMAN_2), Stage_Two(Hangman.HANGMAN_3),
    Stage_Three(Hangman.HANGMAN_4), Stage_Four(Hangman.HANGMAN_5),
    Stage_Five(Hangman.HANGMAN_6), Stage_Six(Hangman.HANGMAN_7), Stage_Seven(Hangman.HANGMAN_8),
    Game_Over(Hangman.HANGMAN), Win(Hangman.HANGMAN), Lost(Hangman.HANGMAN);

    public final String[] hangman;

    private State(String[] hangman) {
        this.hangman = hangman;
    }
}

