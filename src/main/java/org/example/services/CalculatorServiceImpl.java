package org.example.services;

import io.grpc.stub.StreamObserver;
import org.example.CalculatorRequest;
import org.example.CalculatorResponse;
import org.example.CalculatorServiceGrpc;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {
    @Override
    public void calculator(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {

        Double firstNumber = request.getNumberOne();
        Double secondNumber = request.getNumberTwo();
        String operator = request.getType();

        Double result = 0.0;

        switch(operator){
            case "+":
                result = firstNumber + secondNumber;
                break;

            case "-":
                result = firstNumber - secondNumber;
                break;

            case "*":
                result = firstNumber * secondNumber;
                break;

            case "/":
                result = firstNumber / secondNumber;
                break;

            default:
                result = 0.0;
                break;
        }

        CalculatorResponse response = CalculatorResponse.newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
