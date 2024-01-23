package chess.Pieces;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;


public class KingMove {


    public KingMove(ArrayList<ChessMove> a, ChessPosition myPosition, ChessBoard board){
        int row = myPosition.getRow();
        int column = myPosition.getColumn();
        ChessPosition positionTest; //position to test
        ChessPiece spaceTest; // space to test


        for (int i=-1; i<=1; i++) {
            for (int j = -1; j <= 1; j++) {
                if((i==0&&j==0)||row<0||row>=7||column<0||column>=7){continue;}
                positionTest = new ChessPosition(myPosition.getRow()+i+1, myPosition.getColumn()+j+1);
                spaceTest = board.getPiece(positionTest);
                if (spaceTest==null) {
                    a.add(new ChessMove(myPosition, positionTest, null));
                } else if (spaceTest.getTeamColor()!=board.getPiece(myPosition).getTeamColor()){
                    a.add(new ChessMove(myPosition, positionTest, null));
                }
            }
        }
        /*
        int[][] iterator ={{-1,-1},{-1,1},{1,-1},{1,1}};

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
            }*/
            //System. out. println(column+i[1]*j);
            //System. out. println(j);



    }
}
