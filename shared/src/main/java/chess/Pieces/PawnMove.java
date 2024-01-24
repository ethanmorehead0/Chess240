package chess.Pieces;

import chess.*;

import java.util.ArrayList;


public class PawnMove {
    int[][] colorVar={{1,7,1},{-1,0,6}};
    int color;

    public PawnMove(ArrayList<ChessMove> a, ChessPosition myPosition, ChessBoard board){

        int row = myPosition.getRow();
        int column = myPosition.getColumn();
        ChessPosition positionTest; //position to test
        ChessPiece spaceTest; // space to test//{direction, promotion, start}
        //which color to use
        //positionTest = new ChessPosition(myPosition.getRow()+i+1, myPosition.getColumn()+j+1);
        //spaceTest = board.getPiece(positionTest);


        if(board.getPiece(myPosition).getTeamColor()== ChessGame.TeamColor.WHITE){
            color=0;
        }else{
            color=1;
        }
        positionTest=new ChessPosition(myPosition.getRow()+1+colorVar[color][0], myPosition.getColumn()+1);
        if(board.getPiece(positionTest)==null){
            promotion(myPosition, positionTest, a, board);
            positionTest=new ChessPosition(myPosition.getRow()+1+colorVar[color][0]*2, myPosition.getColumn()+1);

            if(myPosition.getRow()==colorVar[color][2] && board.getPiece(positionTest)==null){
                promotion(myPosition, positionTest, a, board);
            }
        }
        if(myPosition.getColumn()!=7){
            positionTest=new ChessPosition(myPosition.getRow()+1+colorVar[color][0], myPosition.getColumn()+2);
            if(board.getPiece(positionTest)!=null && board.getPiece(positionTest).getTeamColor()!=board.getPiece(myPosition).getTeamColor()){
                promotion(myPosition, positionTest, a, board);
            }
        }
        if(myPosition.getColumn()!=0){
            positionTest=new ChessPosition(myPosition.getRow()+1+colorVar[color][0], myPosition.getColumn());
            if(board.getPiece(positionTest)!=null && board.getPiece(positionTest).getTeamColor()!=board.getPiece(myPosition).getTeamColor()){
                promotion(myPosition, positionTest, a, board);
            }
        }


        /*
        for (int i=-1; i<=1; i++) {
            for (int j = -1; j <= 1; j++) {
                if((i==0&&j==0)||myPosition.getRow()+i+1<=0||myPosition.getRow()+i+1>8||myPosition.getColumn()+j+1<=0||myPosition.getColumn()+j+1>8){continue;}
                positionTest = new ChessPosition(myPosition.getRow()+i+1, myPosition.getColumn()+j+1);
                spaceTest = board.getPiece(positionTest);
                if (spaceTest==null) {
                    a.add(new ChessMove(myPosition, positionTest, null));
                } else if (spaceTest.getTeamColor()!=board.getPiece(myPosition).getTeamColor()){
                    a.add(new ChessMove(myPosition, positionTest, null));
                }
            }
        }*/



    }
    private void promotion(ChessPosition myPosition, ChessPosition positionTest, ArrayList<ChessMove> a, ChessBoard board){
        if(positionTest.getRow()==colorVar[color][1]){
            for(ChessPiece.PieceType type: ChessPiece.PieceType.values()){
                if (type== ChessPiece.PieceType.PAWN){continue;}
                if (type== ChessPiece.PieceType.KING){continue;}
                a.add(new ChessMove(myPosition, positionTest, type));


            }

        }else {
            a.add(new ChessMove(myPosition, positionTest, null));
        }
    }
}
