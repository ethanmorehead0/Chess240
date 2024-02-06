package chess;

import java.util.Collection;

/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {


    private TeamColor team;
    private ChessBoard board;

    public ChessGame() {

    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return team;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        this.team = team;
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        return board.getPiece(startPosition).pieceMoves(board, startPosition);

    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to preform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
        if(isInCheck(team)){
            throw new InvalidMoveException("Check");

        } else if (isInCheckmate(team)) {
            throw new InvalidMoveException("Checkmate");

        } else if (isInStalemate(team)) {
            throw new InvalidMoveException("Stalemate");
        }else
        {
            if(move.getPromotionPiece()==null) {
                board.addPiece(move.getEndPosition(), board.getPiece(move.getStartPosition()));
                board.addPiece(move.getStartPosition(), null);
            }else {

                board.addPiece(move.getEndPosition(), new ChessPiece(team, move.getPromotionPiece()));
                board.addPiece(move.getStartPosition(), null);
            }
        }
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        return isInDanger(kingPosition(teamColor),teamColor);
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        return false;
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        return false;
    }


    public boolean isInDanger(ChessPosition positionToCheck, TeamColor teamColor){

        int row = positionToCheck.getRow();
        int column = positionToCheck.getColumn();
        int iterate=0;

        ChessPosition positionTest;
        ChessPiece spaceTest; // space to test
        ChessPiece.PieceType type;
        int[][] iterator={{-1,-1},{-1,1},{1,-1},{1,1}, {-1,0},{1,0},{0,-1},{0,1},
                        {1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
        //QUEEN 0-7
        //BISHOP 0-3
        //ROOK 4-7
        //KNIGHT 8-15
        for(int[] i:iterator){

            for(int j=1; (row+i[0]*j)>=0 && (row+i[0]*j)<8 && (column+i[1]*j)<8 && (column+i[1]*j)>=0;j++ ){
                positionTest = new ChessPosition(row+i[0]*j+1, column+i[1]*j+1);
                spaceTest = board.getPiece(positionTest);

                if (spaceTest!=null && spaceTest.getTeamColor()!=teamColor){
                    type=spaceTest.getPieceType();
                    if (iterate<8 && type == ChessPiece.PieceType.QUEEN){
                        return true;
                    }
                    else if (iterate<8 && type == ChessPiece.PieceType.KING && j==1){
                        return true;
                    }
                    else if (iterate<4 && type == ChessPiece.PieceType.BISHOP){
                        return true;
                    }
                    else if (iterate>3 && iterate<8 && type == ChessPiece.PieceType.ROOK){
                        return true;
                    }
                }
                if(iterate>7){
                    if (spaceTest!=null && spaceTest.getTeamColor()!=teamColor){
                        type=spaceTest.getPieceType();
                        if (iterate<16 && type == ChessPiece.PieceType.KNIGHT){
                            return true;
                        }

                    }
                    break;
                }


            }
            iterate+=1;
        }


        return false;
    }

    public ChessPosition kingPosition(TeamColor teamColor){
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(board.getPiece(new ChessPosition(i,j)) != null&& board.getPiece(new ChessPosition(i,j)).getPieceType()== ChessPiece.PieceType.KING && board.getPiece(new ChessPosition(i,j)).getTeamColor()==teamColor){
                    return new ChessPosition(i,j);
                }
            }
        }
        return null;

    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return board;
    }
}
