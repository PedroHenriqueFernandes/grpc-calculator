package org.example;

import javax.swing.JOptionPane;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientMain {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8089)
                .usePlaintext()
                .build();

        CalculatorServiceGrpc.CalculatorServiceBlockingStub stub = CalculatorServiceGrpc.newBlockingStub(channel);

        Double valueOne = Double.parseDouble(JOptionPane.showInputDialog("Enter first number"));
        Double valueTwo = Double.parseDouble(JOptionPane.showInputDialog("Enter second number"));
        String operator = JOptionPane.showInputDialog("Enter operator");

        CalculatorResponse response = stub.calculator(CalculatorRequest.newBuilder()
                .setNumberOne(valueOne)
                .setNumberTwo(valueTwo)
                .setType(operator)
                .build());

        JOptionPane.showMessageDialog(null, "Result: " + response.getResult());
        System.out.println("Result: " + response.getResult());
        channel.shutdown();
    }
}
