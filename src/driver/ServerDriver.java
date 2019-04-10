package driver;

import server.DefaultServerSocket;
import client.DefaultSocketClient;
import java.util.Scanner;

public class ServerDriver {
    public static void main(String [] args) {
        DefaultServerSocket Server = new DefaultServerSocket(3220);
        Server.run();
    }
}