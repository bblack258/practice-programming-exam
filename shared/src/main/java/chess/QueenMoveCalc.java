package chess;

import java.util.List;

/**
 * Child class to extend MoveCalc for Queens
 */

public class QueenMoveCalc extends MoveCalc {
    public QueenMoveCalc(ChessPosition startPosition, ChessBoard board, List<ChessMove> legalMoves) {
        super(startPosition, board, legalMoves);
    }

    /**
     * Adds legal moves for a queen
     */
    public void moveQueen() {
        moveStraight();
        moveDiagonal();
    }
}
