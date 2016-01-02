package com.asl.graduationproject;

import java.io.*;

import com.leapmotion.leap.*;

public class UpdateServosLocation extends Listener {
	public void onFrame(Controller controller)  {
		Frame frame =controller.frame();
		
		try {
			BufferedWriter out;
			out = new BufferedWriter(new FileWriter("PalmData.txt"));
			HandList hands = frame.hands(); 
			Hand firstHand =  hands.get(0) ; 
			out.write((int) firstHand.palmPosition().getX());
			out.write((int) firstHand.palmPosition().getY());
			out.write((int) firstHand.palmPosition().getZ());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
