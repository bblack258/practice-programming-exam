package chess;

import java.util.List;

/**
 * Child class to extend MoveCalc for Kings
 */

public class KingMoveCalc extends MoveCalc {
    public KingMoveCalc(ChessPosition startPosition, ChessBoard board, List<ChessMove> legalMoves) {
        super(startPosition, board, legalMoves);
    }

    /**
     * Add valid moves for kings, not including rules about check, checkmate, and castling
     */
    public void moveKing() {
        if (startPosition.getRow() + 1 <= 8 && notBlocked(new ChessPosition(startPosition.getRow() + 1,
                startPosition.getColumn()))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn()), null));
        }
        if (startPosition.getRow() - 1 > 0 && notBlocked(new ChessPosition(startPosition.getRow() - 1,
                startPosition.getColumn()))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn()), null));
        }
        if (startPosition.getColumn() + 1 <= 8 && notBlocked(new ChessPosition(startPosition.getRow(),
                startPosition.getColumn() + 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow(),
                    startPosition.getColumn() + 1), null));
        }
        if (startPosition.getColumn() - 1 > 0 && notBlocked(new ChessPosition(startPosition.getRow(),
                startPosition.getColumn() - 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow(),
                    startPosition.getColumn() - 1), null));
        }
        if (startPosition.getRow() + 1 <= 8 && startPosition.getColumn() + 1 <= 8 && notBlocked(new
                ChessPosition(startPosition.getRow() + 1, startPosition.getColumn() + 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() + 1), null));
        }
        if (startPosition.getRow() + 1 <= 8 && startPosition.getColumn() - 1 > 0 && notBlocked(new
                ChessPosition(startPosition.getRow() + 1, startPosition.getColumn() - 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() - 1), null));
        }
        if (startPosition.getRow() - 1 > 0 && startPosition.getColumn() + 1 <= 8 && notBlocked(new
                ChessPosition(startPosition.getRow() - 1, startPosition.getColumn() + 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() + 1), null));
        }
        if (startPosition.getRow() - 1 > 0 && startPosition.getColumn() - 1 > 0 && notBlocked(new
                ChessPosition(startPosition.getRow() - 1, startPosition.getColumn() - 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() - 1), null));
        }
    }
}
