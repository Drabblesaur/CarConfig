package driver;

import client.DefaultSocketClient;

public class ClientDriver {
    public static void main(String [] args){
        DefaultSocketClient client = new DefaultSocketClient("IP ADDRESS","PORT");
        client.run();
    }
}
