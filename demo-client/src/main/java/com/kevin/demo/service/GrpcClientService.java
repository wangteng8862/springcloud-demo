package com.kevin.demo.service;

import com.kevin.demo.api.HelloReply;
import com.kevin.demo.api.HelloRequest;
import com.kevin.demo.api.SimpleGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: god_ole
 * @Date: 2021/3/4 15:48
 */
@Service
public class GrpcClientService {

    @GrpcClient("cloud-grpc-server-consul")
    private SimpleGrpc.SimpleBlockingStub simpleStub;

    public String sendMessage(final String name) {
        try {
            final HelloReply response = this.simpleStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode();
        }
    }

}
