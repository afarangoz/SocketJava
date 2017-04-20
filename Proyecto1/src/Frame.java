


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;




public class Frame extends JFrame implements ActionListener{
	
	private Panel jpanel1;
	JTextField jtextfield = new JTextField();   


	
	//Contructor de la clase 
	public Frame(){
		
		initComponents();
		
	}

	
	private void initComponents(){
		jpanel1 = new Panel();
		
		
		setSize(jpanel1.getWidth(),jpanel1.getHigh());
		setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//Termina el programa
		this.setContentPane(jpanel1);
		
		
		/*************************************************************/

		
	}
	
		
    
	
	
	
	
	
	
	//http://www.tutorialesprogramacionya.com/javaya/detalleconcepto.php?codigo=109&punto=&inicio=
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
