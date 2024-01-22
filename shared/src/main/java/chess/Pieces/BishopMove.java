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
        int[][] interater ={{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int[] i:interater){
            for(int j=1; (row+i[0]*j)>=0 && (row+i[0]*j)<8 && (column+i[1]*j)<8 && (column+i[1]*j)>=0;j++ ){
                    if (board.getPiece(new ChessPosition(row+i[0]*j+1, column+i[1]*j+1))==null) {
                        a.add(new ChessMove(myPosition, new ChessPosition(row + i[0] * j + 1, column + i[1] * j + 1), null));
                    } else if (board.getPiece(new ChessPosition(row+i[0]*j+1, column+i[1]*j+1)).getTeamColor()!=board.getPiece(myPosition).getTeamColor()){
                        a.add(new ChessMove(myPosition, new ChessPosition(row + i[0] * j + 1, column + i[1] * j + 1), null));
                        break;
                    } else {
                        break;
                    }
                    //System. out. println(column+i[1]*j);
                    //System. out. println(j);
            }
        }

        /*while (testRow>0&&testColumn>0){
            //a.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(),testColumn), null));
            testRow-=1;
            testColumn-=1;
        }*/


    }
}

