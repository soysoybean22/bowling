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

    @Test
    @DisplayName("매 투구 1핀씩 쓰러뜨리면 20점이다")
    void allOnesScoresTwenty() {
        rollMany(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    @DisplayName("스트라이크 후 다음 두 투구가 보너스로 더해진다")
    void strikeFollowedByThreeAndFourScoresTwentyFour() {
        game.roll(10);           // 스트라이크
        game.roll(3); game.roll(4);
        rollMany(16, 0);

        assertEquals(24, game.score());
    }

    @Test
    @DisplayName("퍼펙트 게임은 300점이다")
    void perfectGameScoresThreeHundred() {
        rollMany(12, 10);

        assertEquals(300, game.score());
    }

    @Test
    @DisplayName("스페어 후 다음 투구가 보너스로 더해진다")
    void spareFollowedByThreeScoresSixteen() {
        game.roll(5); game.roll(5); // 스페어
        game.roll(3); game.roll(0);
        rollMany(16, 0);

        assertEquals(16, game.score());
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}
