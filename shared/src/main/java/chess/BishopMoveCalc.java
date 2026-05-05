package chess;

import java.util.List;

public class BishopMoveCalc extends MoveCalc {
    public BishopMoveCalc(ChessPosition startPosition, ChessBoard board, List<ChessMove> legalMoves) {
        super(startPosition, board, legalMoves);
    }
}
