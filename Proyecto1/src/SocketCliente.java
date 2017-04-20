
import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;


/**
 * Clase que crea un socket cliente, establece la conexión y lee los datos
 * del servidor, escribiéndolos en pantalla.
 */
public class SocketCliente
 {
	static Socket socket;
     /** Programa principal, crea el socket cliente */
     public void Init()
     {
         try
         {
             /* Se crea el socket cliente */
             Socket socket = new Socket("127.0.0.1", 3385);
             System.out.println ("conectado");
             this.socket = socket;

           
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
     }
     
     /**
      * Crea el socket cliente y lee los datos
      */
     public SocketCliente()
     {

         Init(); 	
     }

     
     public void finish() throws IOException
     {
         socket.close();	 
    	 
     }
     
     
     public static int getValue() throws IOException {
	
	DataInputStream in = new DataInputStream(socket.getInputStream());

    	String answer =in.readUTF();
    	int x = Integer.parseInt(answer);	 
    	
    	/*Shows response from server*/
    	System.out.println("Answer from sever is: " +answer);

         return x;
     }
}
