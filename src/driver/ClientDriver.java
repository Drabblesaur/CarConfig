package driver;

import client.DefaultSocketClient;

public class ClientDriver {
    public static void main(String [] args){
        DefaultSocketClient client = new DefaultSocketClient("10.41.239.77",3220);
        client.run();
    }
}
