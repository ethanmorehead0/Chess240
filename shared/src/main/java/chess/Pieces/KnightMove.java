package chess.Pieces;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;


public class KnightMove {


    public KnightMove(ArrayList<ChessMove> a, ChessPosition myPosition, ChessBoard board){
        int row = myPosition.getRow();
        int column = myPosition.getColumn();
        int nextRow;
        int nextColumn;
        ChessPosition positionTest; //position to test
        ChessPiece spaceTest; // space to test
        int[][] iterator={{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};

        for (int[] i: iterator) {
            nextRow=myPosition.getRow()+i[0]+1;
            nextColumn=myPosition.getColumn()+i[1]+1;
            if(i[0]==0||i[1]==0||nextRow<=0||nextRow>8||nextColumn<=0||nextColumn>8){continue;}
            positionTest = new ChessPosition(myPosition.getRow()+i[0]+1, myPosition.getColumn()+i[1]+1);
            spaceTest = board.getPiece(positionTest);
            if (spaceTest==null) {
                a.add(new ChessMove(myPosition, positionTest, null));
            } else if (spaceTest.getTeamColor()!=board.getPiece(myPosition).getTeamColor()){
                a.add(new ChessMove(myPosition, positionTest, null));
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
