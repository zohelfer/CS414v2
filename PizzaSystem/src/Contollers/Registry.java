package Contollers;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by nljohnso on 11/9/14.
 */
public class Registry {

    public Registry() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 8000);
        server.start();
    }

    

}
