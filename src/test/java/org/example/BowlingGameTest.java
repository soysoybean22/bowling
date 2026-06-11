package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    @DisplayName("거터 게임은 0점이다")
    void gutterGameScoresZero() {
        rollMany(20, 0);

        assertEquals(0, game.score());
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}
