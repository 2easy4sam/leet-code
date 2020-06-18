package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Array, Easy
 * On an 8 x 8 chessboard, there is one white rook.
 * There also may be empty squares, white bishops, and black pawns.
 * These are given as characters 'R', '.', 'B', and 'p' respectively.
 * Uppercase characters represent white pieces, and lowercase
 * characters represent black pieces.
 * <p>
 * The rook moves as in the rules of Chess:
 * it chooses one of four cardinal directions (north, east, west, and
 * south), then moves in that direction until it chooses to stop,
 * reaches the edge of the board, or captures an opposite colored
 * pawn by moving to the same square it occupies.  Also, rooks cannot
 * move into the same square as other friendly bishops.
 * <p>
 * Return the number of pawns the rook can capture in one move.
 */
public class AvailableRookCaptures {
    private static final char WHITE_BISHOP = 'B';
    private static final char WHITE_ROOK = 'R';
    private static final char BLACK_PAWN = 'p';
    private static final int LENGTH = 8;

    public int numRookCaptures(char[][] board) {
        Map<Integer, Character> chessPieceMap = new HashMap<>();
        int[] rookCoords = new int[2];
        int nCaptures = 0;

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                int coords = i * LENGTH + j;
                char piece = board[i][j];
                chessPieceMap.put(coords, piece);

                if (piece == WHITE_ROOK) {
                    rookCoords[0] = i;
                    rookCoords[1] = j;
                }
            }
        }

        final int rook1DIdx = rookCoords[0] * LENGTH + rookCoords[1];
        final int farNorth = LENGTH - 1;
        final int farEast = rookCoords[0] * LENGTH + LENGTH - 1;
        final int farSouth = LENGTH * LENGTH - LENGTH;
        final int farWest = rookCoords[0] * LENGTH;

        // N traverse
        if (rook1DIdx > farNorth) {
            int currentIdx = rook1DIdx;

            while (currentIdx - LENGTH >= 0) {
                currentIdx -= LENGTH;
                char piece = chessPieceMap.get(currentIdx);
                if (piece == WHITE_BISHOP) break;
                if (piece == BLACK_PAWN) {
                    nCaptures++;
                    break;
                }
            }
        }

        // E traverse
        if (rook1DIdx < farEast) {
            int currentIdx = rook1DIdx;

            while (currentIdx + 1 <= farEast) {
                currentIdx += 1;
                char piece = chessPieceMap.get(currentIdx);
                if (piece == WHITE_BISHOP) break;
                if (piece == BLACK_PAWN) {
                    nCaptures++;
                    break;
                }
            }
        }

        // S traverse
        if (rook1DIdx < farSouth) {
            int currentIdx = rook1DIdx;

            while (currentIdx + LENGTH <= farSouth) {
                currentIdx += LENGTH;
                char piece = chessPieceMap.get(currentIdx);
                if (piece == WHITE_BISHOP) break;
                if (piece == BLACK_PAWN) {
                    nCaptures++;
                    break;
                }
            }
        }

        // W traverse
        if (rook1DIdx > farWest) {
            int currentIdx = rook1DIdx;

            while (currentIdx - 1 >= farWest) {
                currentIdx -= 1;
                char piece = chessPieceMap.get(currentIdx);
                if (piece == WHITE_BISHOP) break;
                if (piece == BLACK_PAWN) {
                    nCaptures++;
                    break;
                }
            }
        }

        return nCaptures;
    }

    public int numRookCaptures2(char[][] b) {
        for (int i = 0; i < b.length; ++i)
            for (int j = 0; j < b[i].length; ++j)
                if (b[i][j] == 'R')
                    return cap(b, i, j, 0, 1) + cap(b, i, j, 0, -1) +
                            cap(b, i, j, 1, 0) + cap(b, i, j, -1, 0);
        return 0;
    }

    private int cap(char[][] b, int x, int y, int dx, int dy) {
        while (x >= 0 && x < b.length && y >= 0 && y < b[x].length && b[x][y] != 'B') {
            if (b[x][y] == 'p') return 1;
            x += dx;
            y += dy;
        }
        return 0;
    }
}
