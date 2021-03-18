package com.kevin.demo.service;

import com.kevin.demo.api.HelloReply;
import com.kevin.demo.api.HelloRequest;
import com.kevin.demo.api.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @Description:
 * @Author: god_ole
 * @Date: 2021/3/4 15:46
 */
@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
