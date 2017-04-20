import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerVector {
    public static void main(String[] args) throws IOException {
    	ServerSocket listener = new ServerSocket(3385);
    	
    	int i =0;
        try {
            while (true) {
                Socket socket = listener.accept();
                new ServerThread(socket).start();
                
                i++;
                System.out.println("Cliente: "+i);
               
            }
        }
        finally {
            listener.close();
        }
    }

	

}