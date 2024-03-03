package dataAccess;

import chess.ChessGame;

/**
 * Indicates there was an error connecting to the database
 */
public class DataAccessException extends Exception{
    public DataAccessException(String message) {
        super(message);
    }
    /*ChessGame clear(){//add throws exception (aka ResponseException)

    }*/
}
