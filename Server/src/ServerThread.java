
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ServerThread extends Thread {	

	 Socket socket;
	 
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	
	
	public void run (){       
		
		
			 System.out.println("Client connected");
             
             try {
             	/*Creates streams to send/receive data to/from client*/
             	DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             	//DataInputStream in = new DataInputStream(socket.getInputStream());
             	//in.readInt();
		while(true){
				Thread.sleep(100);
             	out.writeUTF(Integer.toString(1025));
                }
            }
             	
             	
             
                 
         catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
                 try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
			
		
	}	
	
	
	
	
	
}