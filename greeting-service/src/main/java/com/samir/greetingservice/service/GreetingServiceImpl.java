package com.samir.greetingservice.service;

import com.samir.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();

        GreetingResponse response = GreetingResponse.newBuilder()
                .setMessage(String.format("Hello, %s %s", firstName, lastName))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
