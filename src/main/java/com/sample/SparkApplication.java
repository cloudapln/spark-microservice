package com.sample;

import com.sample.api.MyMessage;
import com.sample.transform.JsonTransformer;

import static spark.Spark.get;

public class SparkApplication {
    public static void main(String[] args)
    {
        get("/hello", (req, res) -> "Hello World");
        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });

        //Response Transformation
        get("/hello", "application/json", (request, response) -> {
            return new MyMessage("Hello World");
        }, new JsonTransformer());
    }
}