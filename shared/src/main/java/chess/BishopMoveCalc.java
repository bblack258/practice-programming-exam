package chess;

import java.util.List;

/**
 * Child class to extend MoveCalc for Bishops
 */

public class BishopMoveCalc extends MoveCalc {
    public BishopMoveCalc(ChessPosition startPosition, ChessBoard board, List<ChessMove> legalMoves) {
        super(startPosition, board, legalMoves);
    }
}
