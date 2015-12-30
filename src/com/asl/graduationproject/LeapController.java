package com.asl.graduationproject;

import java.io.IOException;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Finger.Type;
import com.leapmotion.leap.Gesture.State;



public class LeapController {
	public static void main(String[] args) {
		
		Controller controller = new Controller();
		NumbersTranslation listener = new NumbersTranslation();

		controller.addListener(listener);
		
		System.out.println("press enter to quit");
		
		try{
			System.in.read();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		controller.removeListener(listener);

	}
}
