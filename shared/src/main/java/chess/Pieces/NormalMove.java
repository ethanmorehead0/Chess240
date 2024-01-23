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
                //System. out. println(column+i[1]*j);
                //System. out. println(j);
            }
        }
        //[4:0, 3:5, 3:4, 3:3, 3:2, 2:0, 3:1]
        //[0:3, 1:2, 2:1, 4:1, 5:2, 6:3, 7:4]


        //Until edge 1:2
        //[7:2, 6:2, 5:2, 4:2, 1:0, 3:2, 1:1, 2:2, 1:3, 0:2, 1:4, 1:5, 1:6, 1:7]
        //[0:1, 2:3, 3:4, 4:5, 5:6, 6:7, 0:3, 3:0, 2:1]

        /*while (testRow>0&&testColumn>0){
            //a.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(),testColumn), null));
            testRow-=1;
            testColumn-=1;
        }*/


    }
}