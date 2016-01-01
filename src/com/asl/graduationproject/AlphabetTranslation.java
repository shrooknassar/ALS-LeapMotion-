package com.asl.graduationproject;
import com.leapmotion.leap.*; 

public class AlphabetTranslation extends Listener {
	public void onInit(Controller controller){
		System.out.println("Alphabet Initialized");
	}
	public void onConnect(Controller controller){
		System.out.println("connected to motion Sensor");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	}
	
	public void onDisconnect(Controller controller){
		System.out.println("Motion Sensor Disconnection");
	}
	
	public void onExit(Controller controller){
		System.out.println("Exited");
	}
	
	public void onFrame(Controller controller){
		Frame frame =controller.frame();
		HandList hands = frame.hands(); 
		Hand firstHand =  hands.get(0) ; 
		
		if(firstHand.isValid())
		{
			
		}
	}
}
