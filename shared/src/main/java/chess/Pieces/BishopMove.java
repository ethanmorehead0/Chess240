package chess.Pieces;

import chess.ChessMove;
import chess.ChessPosition;
import chess.ChessBoard;
import java.util.ArrayList;


public class BishopMove {


    public BishopMove(ArrayList<ChessMove> a, ChessPosition myPosition, ChessBoard board){
        int isPiece=0;
        int row = myPosition.getRow();
        int column = myPosition.getColumn();
        int[][] iterator ={{-1,-1},{-1,1},{1,-1},{1,1}};
        new NormalMove(a, myPosition, board, iterator);



    }
}