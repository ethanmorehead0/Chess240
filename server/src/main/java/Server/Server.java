package Server;

import com.google.gson.Gson;
import spark.*;
import java.util.*;

import java.io.IOException;

public class Server {
    private ArrayList<String> names = new ArrayList<>();
    public int run(int desiredPort) {
        try {
            Spark.port(desiredPort);

            Spark.staticFiles.location("web");

            // Register your endpoints and handle exceptions here.

            Spark.get("/db", (req, res) -> "DELETE");
            // Register handlers for each endpoint using the method reference syntax
            Spark.post("/user", this::Registration);
            Spark.get("/name", this::listNames);
            Spark.delete("/session", this::Logout);
            Spark.delete("/db", this::Clear);
            Spark.put("/game", this::CreateGame);
            Spark.post("/game", this::JoinGame);
            Spark.post("/session", this::Login);
            Spark.get("/game", this::ListGames);
            //Spark.delete("/user/:name", this::);

            Spark.awaitInitialization();
            return Spark.port();
        }catch(ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            System.err.println("Specify the port number as a command line parameter");
            return 0;
        }
    }


    private Object addName(Request req, Response res) {
        names.add(req.params(":name"));
        return listNames(req, res);
    }

    private Object listNames(Request req, Response res) {
        res.type("application/json");
        return new Gson().toJson(Map.of("name", names));
    }

    private Object deleteName(Request req, Response res) {
        names.remove(req.params(":name"));
        return listNames(req, res);
    }
    private Object Clear(Request req, Response res) {
        names.remove(req.params(":name"));
        return listNames(req, res);
    }
    private Object Logout(Request req, Response res) {
        names.remove(req.params(":name"));
        return listNames(req, res);
    }

    private Object Registration(Request req, Response res) {
        res.type("application/json");
        return new Gson().toJson(Map.of("name", names));
    }
    private Object CreateGame(Request req, Response res) {
        res.type("application/json");
        return new Gson().toJson(Map.of("name", names));
    }

    private Object JoinGame(Request req, Response res) {
        res.type("application/json");
        return new Gson().toJson(Map.of("name", names));
    }

    private Object Login(Request req, Response res) {
        res.type("application/json");
        return new Gson().toJson(Map.of("name", names));
    }

    private Object ListGames(Request req, Response res) {
        res.type("application/json");
        return new Gson().toJson(Map.of("name", names));
    }


    public void stop() {
        Spark.stop();
        Spark.awaitStop();
    }
}
