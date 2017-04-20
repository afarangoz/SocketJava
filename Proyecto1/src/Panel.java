

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.swing.JPanel;

class Panel extends JPanel {
	private int width = 960;
	private int high = 540;
	private int BorderG = 50;
	private int X []=new int [width-2*BorderG+1];
	private int maxXvalue =   1023;
	private int T = 100;
	private int maxTem = 50;
	

    public int getWidth() {
		return width;
	}


	public int getHigh() {
		return high;
	}


	public int getBorderG() {
		return BorderG;
	}






	Panel() {
        // set a preferred size for the custom panel.
        setPreferredSize(new Dimension(this.getWidth(), this.getHigh()));
    }

    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
        
        g.drawString("Planta ", width/2, 20);
        for(int i=0;i<(width-BorderG)/50;i++)
        {	
        	String num =Float.toString(((float)(i*T*50)/(1000)));
        	g.drawString(num, i*50+50, high-BorderG+20);
        }
        g.drawString("T[seg]",width- BorderG + 5 ,high-BorderG);
        
        /*******************************************************/
        for(int i=0;i<(high)/50;i++)
        {	
        	String num =Integer.toString((i*maxTem)/(9));
        	g.drawString(num+" °C", 10, (high)-(i*50+BorderG));
        }
        g.drawString("T[seg]",width- BorderG + 5 ,high-BorderG);
        
        
        g2.setColor(new Color(100,0,0));
        g2.setStroke(new BasicStroke(3));
        g.drawLine(BorderG,BorderG,BorderG,high-BorderG);
        g.drawLine(BorderG,high-BorderG,width-BorderG, high-BorderG);
        g2.setColor(Color.RED);
        
        try {
        	X[0]=(SocketCliente.getValue());
        	//X[0] = 500;
        	
        	

			for(int i = width-2*BorderG; i > 0 ; i-- )
			{
				X[i]=X[i-1];
				
			}
			for(int i = 0; i  < width-2*BorderG ; i++ )
			{
				 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				//g.drawLine(width-BorderG-i,-((i*(high-2*BorderG))/maxXvalue)+(high-BorderG),width-BorderG-i+1,-((i*(high-2*BorderG))/maxXvalue)+(high-BorderG));
				g.drawLine(width-BorderG-i,-((X[i]*(high-2*BorderG))/maxXvalue)+(high-BorderG),width-BorderG-i+1,-((X[i+1]*(high-2*BorderG))/maxXvalue)+(high-BorderG));
			}
			

        	
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
