package com.kodilla.rps;

import java.util.Arrays;
import java.util.Random;

import static com.kodilla.rps.Result.*;

public enum Move {
    LIZARD {
        public Move[] beats() {
            return new Move[]{SPOCK, PAPER};
        }

        public Move[] loses() {
            return new Move[]{ROCK, SCISSORS};
        }
    },
    SPOCK {
        public Move[] beats() {
            return new Move[]{SCISSORS, ROCK};
        }

        public Move[] loses() {
            return new Move[]{LIZARD, PAPER};
        }
    },
    SCISSORS  {
        public Move[] beats() {
            return new Move[]{PAPER, LIZARD};
        }

        public Move[] loses() {
            return new Move[]{ROCK, SPOCK};
        }
    },
    ROCK {
        public Move[] beats() {
            return new Move[]{SCISSORS, LIZARD};
        }

        public Move[] loses() {
            return new Move[]{PAPER, SPOCK};
        }
    },
    PAPER {
        public Move[] beats() {
            return new Move[]{ROCK, SPOCK};
        }

        public Move[] loses() {
            return new Move[]{SCISSORS, LIZARD};
        }
    };

    abstract Move[] beats();
    abstract Move[] loses();

    public Result getResult(Move move) {
        if (this == move) {
            return DRAW;
        } else if(Arrays.stream(move.loses())
                .filter(m -> m == move)
                .count() > 0) {
            return LOSE;
        } else {
            return WIN;
        }
    }

    public static Move getComputerMove(Move playerMove, Result playerResult){
        if (playerResult == DRAW) {
            return playerMove;
        }
        Move[] moves = (playerResult == LOSE) ?  playerMove.loses() : playerMove.beats();
        int randomMove = new Random().nextInt(moves.length);

        return moves[randomMove];
    }
}
