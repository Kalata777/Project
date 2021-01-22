package paket2;
import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.math.*;
import java.io.File; 
import java.io.IOException;
import java.awt.Canvas;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
public class Gui {
	
	
	public static void main(String[] args) {
	
		Timer timer = new Timer();
		JFrame frame = new JFrame("Frame");	
		 frame.setSize(1000, 800);
		  frame.setLayout(null);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		//frame.pack();
		frame.setVisible(true);
		
		int broi[]= {5,5};
		boolean playing=true;
		boolean sequence=false;
	//	int position=0;
		Graphics canvas=null;
		
		//canvas.draw3DRect(20, 200, 3, 4, true);
		Klavish klavishi[][]=new Klavish[broi[0]][broi[1]];
		for(int i=0;i<broi[0];i++) {
			for(int j=0;j<broi[0];j++) {
				klavishi[i][j]=new Klavish(j+1+".wav",i,j);
				frame.add(klavishi[i][j].checkBox);
				//System.out.println("F");
			//	klavishi[i][j].paint(canvas,i,j,frame);
			}
			
		}

	
	while(frame.isVisible()) {
		if(playing) {
		timer.schedule(new TimerTask() {
			int position=0;

			public void run() {
           position++;
           for(int j=0;j<broi[1];j++) {
			klavishi[position][j].play();
           }
           if(position==broi[0]-1) {
        	   position=0;
           }
				
			}
		}, 2*60*1000);


		}
	}
	}
	
}
