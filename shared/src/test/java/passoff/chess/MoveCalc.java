package passoff.chess;

import java.util.List;

import chess.*;

/**
 * Parent class for finding allowed moves given a piece and position, checking for blocking and taking
 */

public class MoveCalc {

    ChessPosition startPosition;
    ChessBoard board;
    List<ChessMove> legalMoves;
    ChessPiece myPiece;
    ChessGame.TeamColor myColor;

    public MoveCalc(ChessPosition startPosition, ChessBoard board, List<ChessMove> legalMoves) {
        this.startPosition = startPosition;
        this.board = board;
        this.legalMoves = legalMoves;
        myPiece = board.getPiece(startPosition);
        myColor = myPiece.getTeamColor();
    }

    /**
     * Function to add legal moves in straight lines, checking if a square is blocked or can be taken
     */

    public void moveStraight() {
        for (int i = 1; i < 8; i++) {
            if (startPosition.getRow() - i > 0 && notBlocked(new ChessPosition(startPosition.getRow() - i,
                    startPosition.getColumn()))) {
                legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - i,
                        startPosition.getColumn()), null));
            } else {
                break;
            }
            if (canTake(new ChessPosition(startPosition.getRow() - i, startPosition.getColumn()))) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (startPosition.getRow() + i <= 8 && notBlocked(new ChessPosition(startPosition.getRow() + i,
                    startPosition.getColumn()))) {
                legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + i,
                        startPosition.getColumn()), null));
            } else {
                break;
            }
            if (canTake(new ChessPosition(startPosition.getRow() + i, startPosition.getColumn()))) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (startPosition.getColumn() - i > 0 && notBlocked(new ChessPosition(startPosition.getRow(),
                    startPosition.getColumn() - i))) {
                legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow(),
                        startPosition.getColumn() - i), null));
            } else {
                break;
            }
            if (canTake(new ChessPosition(startPosition.getRow(), startPosition.getColumn() - i))) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (startPosition.getColumn() + i <= 8 && notBlocked(new ChessPosition(startPosition.getRow(),
                    startPosition.getColumn() + i))) {
                legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow(),
                        startPosition.getColumn() + i), null));
            } else {
                break;
            }
            if (canTake(new ChessPosition(startPosition.getRow(), startPosition.getColumn() + i))) {
                break;
            }
        }

    }

    /**
     * Function to add legal moves in diagonal lines, checking if a square is blocked or can be taken
     */

    public void moveDiagonal() {
        for (int i = 1; i < 8; i++) {
            if (startPosition.getRow() + i <= 8 && startPosition.getColumn() + i <= 8 && notBlocked(new
                    ChessPosition(startPosition.getRow() + i, startPosition.getColumn() + i))) {
                legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + i,
                        startPosition.getColumn() + i), null));
            } else {
                break;
            }
            if (canTake(new ChessPosition(startPosition.getRow() + i, startPosition.getColumn() + i))) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (startPosition.getRow() - i > 0 && startPosition.getColumn() + i <= 8 && notBlocked(new
                    ChessPosition(startPosition.getRow() - i, startPosition.getColumn() + i))) {
                legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - i,
                        startPosition.getColumn() + i), null));
            } else {
                break;
            }
            if (canTake(new ChessPosition(startPosition.getRow() - i, startPosition.getColumn() + i))) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (startPosition.getRow() + i <= 8 && startPosition.getColumn() - i > 0 && notBlocked(new
                    ChessPosition(startPosition.getRow() + i, startPosition.getColumn() - i))) {
                legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() + i,
                        startPosition.getColumn() - i), null));
            } else {
                break;
            }
            if (canTake(new ChessPosition(startPosition.getRow() + i, startPosition.getColumn() - i))) {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (startPosition.getRow() - i > 0 && startPosition.getColumn() - i > 0 && notBlocked(new
                    ChessPosition(startPosition.getRow() - i, startPosition.getColumn() - i))) {
                legalMoves.add(new ChessMove(startPosition, new ChessPosition(startPosition.getRow() - i,
                        startPosition.getColumn() - i), null));
            } else {
                break;
            }
            if (canTake(new ChessPosition(startPosition.getRow() - i, startPosition.getColumn() - i))) {
                break;
            }
        }
    }

    /**
     * Function to check if a space is blocked
     */

    public boolean notBlocked(ChessPosition endPosition) {
        ChessPiece other = board.getPiece(endPosition);
        return other == null || other.getTeamColor() != myColor;
    }

    /**
     * Function to check if a piece from the opposite team can be taken
     */

    public boolean canTake(ChessPosition endPosition) {
        ChessPiece other = board.getPiece(endPosition);
        return other != null && other.getTeamColor() != myColor;
    }


}
