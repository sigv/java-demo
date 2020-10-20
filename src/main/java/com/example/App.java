package com.example;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/sum/:numberOne/:numberTwo", (req, res) -> {
            int numberOne, numberTwo;
            try {
                numberOne = Integer.parseInt(req.params(":numberOne"));
                numberTwo = Integer.parseInt(req.params(":numberTwo"));
            } catch (NumberFormatException e) {
                res.status(400);
                res.type("text/plain");
                return "Bad input";
            }

            res.type("text/plain");
            return numberOne + numberTwo;
        });
    }
}
