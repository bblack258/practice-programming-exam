package chess;

import java.util.List;

/**
 * Child class to extend MoveCalc for Rooks
 */

public class RookMoveCalc extends MoveCalc {
    public RookMoveCalc(ChessPosition startPosition, ChessBoard board, List<ChessMove> legalMoves) {
        super(startPosition, board, legalMoves);
    }
}
