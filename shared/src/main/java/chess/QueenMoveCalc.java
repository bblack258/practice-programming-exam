package chess;

import java.util.List;

public class QueenMoveCalc extends MoveCalc {
    public QueenMoveCalc(ChessPosition startPosition, ChessBoard board, List<ChessMove> legalMoves) {
        super(startPosition, board, legalMoves);
    }

    public void moveQueen() {
        moveStraight();
        moveDiagonal();
    }
}
