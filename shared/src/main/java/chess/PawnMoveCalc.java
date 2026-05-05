package chess;

import java.util.List;

public class PawnMoveCalc extends MoveCalc {
    public PawnMoveCalc(ChessPosition startPosition, ChessBoard board, List<ChessMove> legalMoves) {
        super(startPosition, board, legalMoves);
    }

    /**
     * Wrapper function for private member functions defining how pawns move, take, and promote depending on color
     */
    public void movePawn() {
        if (board.getPiece(startPosition).getTeamColor() == ChessGame.TeamColor.WHITE) {
            moveWhite();
            takeWhite();
            promoteWhite();
        } else {
            moveBlack();
            takeBlack();
            promoteBlack();
        }
    }

    /**
     * Private helper functions to determine how pawns move generally, without taking or promoting
     * This includes the possibility to move two squares on the first turn
     */

    private void moveWhite() {
        if (startPosition.getRow() == 2 && notBlocked(new ChessPosition(startPosition.getRow() + 1,
                startPosition.getColumn())) && notBlocked(new ChessPosition(startPosition.getRow() + 2,
                startPosition.getColumn()))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 2,
                    startPosition.getColumn()), null));
        }
        if (startPosition.getRow() + 1 < 8 && notBlocked(new ChessPosition(startPosition.getRow() + 1,
                startPosition.getColumn()))) {
            legalMoves.add(new ChessMove(startPosition,new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn()), null));
        }
    }

    private void moveBlack() {
        if (startPosition.getRow() == 7 && notBlocked(new ChessPosition(startPosition.getRow() - 1,
                startPosition.getColumn())) && notBlocked(new ChessPosition(startPosition.getRow() - 2,
                startPosition.getColumn()))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 2,
                    startPosition.getColumn()), null));
        }
        if (startPosition.getRow() - 1 > 1 && notBlocked(new ChessPosition(startPosition.getRow() - 1,
                startPosition.getColumn()))) {
            legalMoves.add(new ChessMove(startPosition,new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn()), null));
        }
    }

    /**
     * Private helper functions to determine how pawns take, except when promoting
     */

    private void takeWhite() {
        ChessPiece otherL = board.getPiece(new ChessPosition(startPosition.getRow() + 1,
                startPosition.getColumn() - 1));
        if (otherL != null && otherL.getTeamColor() != myColor && startPosition.getRow() + 1 < 8 &&
                startPosition.getColumn() - 1 > 0) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() - 1), null));
        }
        ChessPiece otherR = board.getPiece(new ChessPosition(startPosition.getRow() + 1,
                startPosition.getColumn() + 1));
        if (otherR != null && otherR.getTeamColor() != myColor && startPosition.getRow() + 1 < 8 &&
                startPosition.getColumn() + 1 <= 8) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() + 1), null));
        }
    }

    private void takeBlack() {
        ChessPiece otherL = board.getPiece(new ChessPosition(startPosition.getRow() - 1,
                startPosition.getColumn() - 1));
        if (otherL != null && otherL.getTeamColor() != myColor && startPosition.getRow() - 1 > 1 &&
                startPosition.getColumn() - 1 > 0) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() - 1), null));
        }
        ChessPiece otherR = board.getPiece(new ChessPosition(startPosition.getRow() - 1,
                startPosition.getColumn() + 1));
        if (otherR != null && otherR.getTeamColor() != myColor && startPosition.getRow() - 1 > 1 &&
                startPosition.getColumn() + 1 <= 8) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() + 1), null));
        }
    }

    /**
     * Private helper functions to determine how pawns promote
     */

    private void promoteWhite() {
        if (startPosition.getRow() + 1 == 8 && notBlocked(new ChessPosition(startPosition.getRow() + 1,
                startPosition.getColumn()))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn()), ChessPiece.PieceType.QUEEN));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn()), ChessPiece.PieceType.BISHOP));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn()), ChessPiece.PieceType.ROOK));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn()), ChessPiece.PieceType.KNIGHT));
        }
        if (startPosition.getRow() + 1 == 8 && startPosition.getColumn() + 1 <= 8 && canTake(new
                ChessPosition(startPosition.getRow() + 1, startPosition.getColumn() + 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() + 1), ChessPiece.PieceType.QUEEN));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() + 1), ChessPiece.PieceType.BISHOP));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() + 1), ChessPiece.PieceType.ROOK));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() + 1), ChessPiece.PieceType.KNIGHT));
        }
        if (startPosition.getRow() + 1 == 8 && startPosition.getColumn() - 1 > 0 && canTake(new
                ChessPosition(startPosition.getRow() + 1, startPosition.getColumn() - 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() - 1), ChessPiece.PieceType.QUEEN));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() - 1), ChessPiece.PieceType.BISHOP));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() - 1), ChessPiece.PieceType.ROOK));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + 1,
                    startPosition.getColumn() - 1), ChessPiece.PieceType.KNIGHT));
        }
    }

    private void promoteBlack() {
        if (startPosition.getRow() - 1 == 1 && notBlocked(new ChessPosition(startPosition.getRow() - 1,
                startPosition.getColumn()))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn()), ChessPiece.PieceType.QUEEN));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn()), ChessPiece.PieceType.BISHOP));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn()), ChessPiece.PieceType.ROOK));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn()), ChessPiece.PieceType.KNIGHT));
        }
        if (startPosition.getRow() - 1 == 1 && startPosition.getColumn() + 1 <= 8 && canTake(new
                ChessPosition(startPosition.getRow() - 1, startPosition.getColumn() + 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() + 1), ChessPiece.PieceType.QUEEN));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() + 1), ChessPiece.PieceType.BISHOP));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() + 1), ChessPiece.PieceType.ROOK));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() + 1), ChessPiece.PieceType.KNIGHT));
        }
        if (startPosition.getRow() - 1 == 1 && startPosition.getColumn() - 1 > 0 && canTake(new
                ChessPosition(startPosition.getRow() - 1, startPosition.getColumn() - 1))) {
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() - 1), ChessPiece.PieceType.QUEEN));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() - 1), ChessPiece.PieceType.BISHOP));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() - 1), ChessPiece.PieceType.ROOK));
            legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - 1,
                    startPosition.getColumn() - 1), ChessPiece.PieceType.KNIGHT));
        }
    }
}
