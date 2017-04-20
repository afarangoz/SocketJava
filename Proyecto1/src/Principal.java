import java.io.IOException;
import java.security.SecurityPermission;

import javax.swing.event.TreeWillExpandListener;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) throws IllegalArgumentException, IOException, InterruptedException {
		
		int T = 100; // 200 milis

	      
		//new Frame().setVisible(true);
		Frame frame1 = new Frame();
		 Panel Graph = new Panel();
		 frame1.add(Graph);
		 frame1.setVisible(true);

		 SocketCliente cliente  = new SocketCliente();
		 
		 
		 while(true)		 {
			 
			 Graph.repaint();
			 Thread.sleep(T);
		 }
		 
		 
		
		
		
	}

}