package chess.Pieces;

import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.ChessBoard;
import java.util.ArrayList;


public class NormalMove {


    public NormalMove(ArrayList<ChessMove> a, ChessPosition myPosition, ChessBoard board, int[][] iterator){

        int row = myPosition.getRow();
        int column = myPosition.getColumn();
        ChessPosition positionTest; //position to test
        ChessPiece spaceTest; // space to test


        for(int[] i:iterator){
            for(int j=1; (row+i[0]*j)>=0 && (row+i[0]*j)<8 && (column+i[1]*j)<8 && (column+i[1]*j)>=0;j++ ){
                positionTest = new ChessPosition(row+i[0]*j+1, column+i[1]*j+1);
                spaceTest = board.getPiece(positionTest);
                if (spaceTest==null) {
                    a.add(new ChessMove(myPosition, positionTest, null));
                } else if (spaceTest.getTeamColor()!=board.getPiece(myPosition).getTeamColor()){
                    a.add(new ChessMove(myPosition, positionTest, null));
                    break;
                } else {
                    break;
                }
            }
        }


    }
}