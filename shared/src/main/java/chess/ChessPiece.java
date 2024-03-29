package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import chess.Pieces.*;
/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    ChessGame.TeamColor color;
    ChessPiece.PieceType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return color == that.color && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "color=" + color +
                ", type=" + type +
                '}';
    }

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type1) {
        color=pieceColor;
        type=type1;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return color;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        ArrayList<ChessMove> a=new ArrayList<>();
        switch (board.getPiece(myPosition).getPieceType()){
            case PieceType.BISHOP: new BishopMove(a,myPosition,board);
                break;
            case PieceType.ROOK: new RookMove(a,myPosition,board);
                break;
            case PieceType.QUEEN: new QueenMove(a,myPosition,board);
                break;
            case PieceType.KING: new KingMove(a,myPosition,board);
                break;
            case PieceType.KNIGHT: new KnightMove(a,myPosition,board);
                break;
            case PieceType.PAWN: new PawnMove(a,myPosition,board);
                break;
        }
        return a;
    }
}
