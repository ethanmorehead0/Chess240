package chess.Pieces;

import chess.ChessMove;
import chess.ChessPosition;
import chess.ChessBoard;
import java.util.ArrayList;


public class RookMove {


    public RookMove(ArrayList<ChessMove> a, ChessPosition myPosition, ChessBoard board){
        int[][] iterator ={{-1,0},{1,0},{0,-1},{0,1}};
        new NormalMove(a, myPosition, board, iterator);

    }
}

