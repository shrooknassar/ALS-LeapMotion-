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
			FingerList fingers = firstHand.fingers();
			// fingers ordered from thumb to pinky in each hand 
			Finger thumbFinger = fingers.get(0) ; 
			Finger indexFinger = fingers.get(1) ; 
			Finger middleFinger = fingers.get(2) ;
			Finger ringFinger = fingers.get(3) ;
			Finger pinkyFinger = fingers.get(4) ;
			// bones are ordered from base to tip for each finger
			// thumb bones from bottom to top 
			Bone thumbFingerMetacarpalsBone = thumbFinger.bone(Bone.Type.TYPE_METACARPAL); 
			Bone thumbFingerProximalBone = thumbFinger.bone(Bone.Type.TYPE_PROXIMAL); 
			Bone thumbFingerIntermediateBone = thumbFinger.bone(Bone.Type.TYPE_INTERMEDIATE); 
			Bone thumbFingerDistalBone = thumbFinger.bone(Bone.Type.TYPE_DISTAL); 
			// index bones from bottom to top 
			Bone indexFingerMetacarpalsBone = indexFinger.bone(Bone.Type.TYPE_METACARPAL); 
			Bone indexFingerProximalBone = indexFinger.bone(Bone.Type.TYPE_PROXIMAL); 
			Bone indexFingerIntermediateBone = indexFinger.bone(Bone.Type.TYPE_INTERMEDIATE); 
			Bone indexFingerDistalBone = indexFinger.bone(Bone.Type.TYPE_DISTAL); 
			// middle bones from bottom to top 
			Bone middleFingerMetacarpalsBone = middleFinger.bone(Bone.Type.TYPE_METACARPAL); 
			Bone middleFingerProximalBone = middleFinger.bone(Bone.Type.TYPE_PROXIMAL); 
			Bone middleFingerIntermediateBone = middleFinger.bone(Bone.Type.TYPE_INTERMEDIATE); 
			Bone middleFingerDistalBone = middleFinger.bone(Bone.Type.TYPE_DISTAL); 
			// ring bones from bottom to top 
			Bone ringFingerMetacarpalsBone = ringFinger.bone(Bone.Type.TYPE_METACARPAL); 
			Bone ringFingerProximalBone = ringFinger.bone(Bone.Type.TYPE_PROXIMAL); 
			Bone ringFingerIntermediateBone = ringFinger.bone(Bone.Type.TYPE_INTERMEDIATE); 
			Bone ringFingerDistalBone = ringFinger.bone(Bone.Type.TYPE_DISTAL); 
			// pinky bones from bottom to top 
			Bone pinkyFingerMetacarpalsBone = pinkyFinger.bone(Bone.Type.TYPE_METACARPAL); 
			Bone pinkyFingerProximalBone = pinkyFinger.bone(Bone.Type.TYPE_PROXIMAL); 
			Bone pinkyFingerIntermediateBone = pinkyFinger.bone(Bone.Type.TYPE_INTERMEDIATE); 
			Bone pinkyFingerDistalBone = pinkyFinger.bone(Bone.Type.TYPE_DISTAL); 
			//thumbFinger.width()
			//float angle = thumbFinger.direction().angleTo(indexFinger.direction());
			//
			
		}
	}
}
