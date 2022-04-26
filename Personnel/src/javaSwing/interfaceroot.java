package javaSwing;

import javax.swing.SwingUtilities;
public class interfaceroot {
	
	public static void main (String[] args){
		SwingUtilities.invokeLater(new Runnable(){ 		
			public void run() {
			new Frame("ligue");
	}
		});
	}
	
}
