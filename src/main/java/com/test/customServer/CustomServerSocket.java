package com.test.customServer;


import org.springframework.util.SocketUtils;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomServerSocket {

    private final static int  PORT = 2023;
    public static void main(String[] args) throws IOException{
        startWebServer();
    }

    public static void startWebServer() throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        try(ServerSocket serverSocket = new ServerSocket(PORT)){

        System.out.println("The Request is running on Port : " + PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client Ip Address : "+((InetSocketAddress) socket.getRemoteSocketAddress()).getHostString());

                service.submit(() -> {
                    try {
                        try(InputStream is = socket.getInputStream();
                            OutputStream os = socket.getOutputStream()) {
                            byte[] bytes = new byte[is.available()];
                            int length = is.read(bytes);
                            String requestData = new String(bytes, 0, length);
                            System.out.println("The Server is running on : " + Thread.currentThread().getName());
                            Thread.sleep(2000);
                            System.out.println(requestData);
                            os.write("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<h1>Welcome! You Created a New Server</h1>".getBytes("UTF-8"));
                            socket.close();
                        }

                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

            }
        }
    }

}
