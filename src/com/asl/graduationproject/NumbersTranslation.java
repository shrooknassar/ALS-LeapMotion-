package com.asl.graduationproject;

import java.io.IOException;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Finger.Type;
import com.leapmotion.leap.Gesture.State;

public class NumbersTranslation extends Listener {
	public void onInit(Controller controller){
		System.out.println("Initialized");
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
			//for(Finger finger : frame.fingers() ){
			Finger finger = frame.fingers().leftmost();
				System.out.println("Finger Type: "+ finger.type() );
							//	+" ,ID: "+ finger.id()
							//	+" ,Finger Length(mm): "+finger.length()
							//	+" ,Finger width(mm): "+finger.width());
			//translate sign language number!! men 3ndy :D
			/*System.out.println("check translate sign language number!!");
			if( finger.type()==Type.TYPE_INDEX && frame.hands().count()==1)
				System.out.println("One");
			
			else if( finger.type()== Type.TYPE_INDEX && finger.type()== Type.TYPE_MIDDLE && frame.hands().count()==2)
				System.out.println("Two");
			
			else if(finger.type()== Type.TYPE_INDEX && finger.type()== Type.TYPE_MIDDLE && finger.type()==Type.TYPE_THUMB && frame.hands().count()==3)
				System.out.println("Three");
			
			else if(finger.type()== Type.TYPE_INDEX && finger.type()== Type.TYPE_MIDDLE && finger.type()==Type.TYPE_PINKY && finger.type()==Type.TYPE_RING && frame.hands().count()==4)
				System.out.println("Four");
			
			else if(finger.type()== Type.TYPE_INDEX && finger.type()== Type.TYPE_MIDDLE && finger.type()==Type.TYPE_PINKY && finger.type()==Type.TYPE_RING && finger.type()==Type.TYPE_THUMB && frame.hands().count()==5)
				System.out.println("Five");
			
			else if(finger.type()== Type.TYPE_INDEX && finger.type()== Type.TYPE_MIDDLE  && finger.type()==Type.TYPE_RING && frame.hands().count()==3)
				System.out.println("Six");
			
			else if(finger.type()== Type.TYPE_INDEX && finger.type()== Type.TYPE_MIDDLE && finger.type()==Type.TYPE_PINKY && frame.hands().count()==3)
				System.out.println("Seven");
			
			else if(finger.type()== Type.TYPE_INDEX && finger.type()==Type.TYPE_PINKY && finger.type()==Type.TYPE_RING && frame.hands().count()==3)
				System.out.println("Eight");
			
			else if(finger.type()== Type.TYPE_MIDDLE && finger.type()==Type.TYPE_PINKY && finger.type()==Type.TYPE_RING && frame.hands().count()==3)
				System.out.println("Nine");
			// 
			for(Bone.Type  boneType : Bone.Type.values()){
				Bone bone=finger.bone(boneType);
				System.out.println("Bone type: "+ bone.type()
									+" ,start: "+bone.prevJoint()
									+ " ,End: " +bone.nextJoint()
									+ " ,Direction: "+bone.direction());*/
			}
}
