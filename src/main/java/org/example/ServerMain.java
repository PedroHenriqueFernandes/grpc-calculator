package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.services.CalculatorServiceImpl;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort (8089)
                .addService(new CalculatorServiceImpl()).build();
        server.start();
        server.awaitTermination ();
    }
}
