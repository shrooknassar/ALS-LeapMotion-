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
			float angleBetweenThumbAndIndex = thumbFinger.direction().angleTo(indexFinger.direction());
			float angleBetweeIndexAndMiddle = indexFinger.direction().angleTo(middleFinger.direction());
			float angleBetweenMiddleAndRing = middleFinger.direction().angleTo(ringFinger.direction());
			float angleBetweenRingAndPinky = ringFinger.direction().angleTo(pinkyFinger.direction());
			
			
			if( (thumbFinger.tipPosition().getY() > indexFinger.tipPosition().getY() && thumbFinger.tipPosition().getY() > middleFinger.tipPosition().getY() &&  thumbFinger.tipPosition().getY() > ringFinger.tipPosition().getY() && thumbFinger.tipPosition().getY() > pinkyFinger.tipPosition().getY() ) && 
					 (Math.abs(indexFinger.tipPosition().getZ()-firstHand.palmPosition().getZ() ) <= 10 &&  Math.abs(middleFinger.tipPosition().getZ()-firstHand.palmPosition().getZ() ) <= 10  && Math.abs(ringFinger.tipPosition().getZ()-firstHand.palmPosition().getZ() ) <= 10 &&  Math.abs(pinkyFinger.tipPosition().getZ()-firstHand.palmPosition().getZ() ) <= 10 ))
			{
				System.out.println("A|A|A|A|A|A|A|A|A|A|A|A|A|A|A|A|A|A|A|A|A|A|A");
			}
			
			if( (pinkyFinger.tipPosition().getY()-thumbFinger.tipPosition().getY() >=20 && ringFinger.tipPosition().getY()-thumbFinger.tipPosition().getY() >=25 && middleFinger.tipPosition().getY()-thumbFinger.tipPosition().getY() >=30 && indexFinger.tipPosition().getY()-thumbFinger.tipPosition().getY() >=25) &&
					(thumbFinger.tipPosition().getX()>=(pinkyFinger.tipPosition().getX()-pinkyFinger.width() ) &&  (thumbFinger.tipPosition().getX()<=(middleFinger.tipPosition().getX() ) ) ) )
			{
				System.out.println("B|B|B|B|B|B|B|B|B|B|B|B|B|B|B|B|B|B|B|B|B|B|B");
			}
			
			if( (indexFinger.tipPosition().getY()-thumbFinger.tipPosition().getY() >= 40 &&  indexFinger.tipPosition().getY()-middleFinger.tipPosition().getY() >= 40 && indexFinger.tipPosition().getY()-ringFinger.tipPosition().getY() >= 40 && indexFinger.tipPosition().getY()-pinkyFinger.tipPosition().getY() >= 40 ) &&
					(thumbFinger.tipPosition().getY()-firstHand.palmPosition().getY() <=10 && middleFinger.tipPosition().getY()-firstHand.palmPosition().getY() <=10 && ringFinger.tipPosition().getY()-firstHand.palmPosition().getY() <=10 && pinkyFinger.tipPosition().getY()-firstHand.palmPosition().getY() <=10) )
			{
				System.out.println("D|D|D|D|D|D|D|D|D|D|D|D|D|D|D|D|D|D|D|D|D|D|D");
			}
			
			if( (indexFinger.tipPosition().getY()>thumbFinger.tipPosition().getY()  && middleFinger.tipPosition().getY()>thumbFinger.tipPosition().getY() && ringFinger.tipPosition().getY()>thumbFinger.tipPosition().getY() && ringFinger.tipPosition().getY()>thumbFinger.tipPosition().getY() )
					&& ( ( indexFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15  && ( middleFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15  && ( ringFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15  && ( pinkyFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15 ) )
			{
				System.out.println("E|E|E|E|E|E|E|E|E|E|E|E|E|E|E|E|E|E|E|E|E|E|E|E");
			}
			
			if( (Math.abs(thumbFinger.tipPosition().getY() - indexFinger.tipPosition().getY()) <= 5 ) && (pinkyFinger.tipPosition().getY() - thumbFinger.tipPosition().getY() >=20 &&  ringFinger.tipPosition().getY() - thumbFinger.tipPosition().getY() >=30  && middleFinger.tipPosition().getY() - thumbFinger.tipPosition().getY() >=35   ) )
			{
				System.out.println("F|F|F|F|F|F|F|F|F|F|F|F|F|F|F|F|F|F|F|F|F|F|F");
			}
			
			if ((indexFinger.direction().roll() < 0 && indexFinger.direction().roll() > (-1.0*(22.0*7.0))) &&
					Math.abs(thumbFinger.tipPosition().getY() - indexFingerProximalBone.center().getY()) < 3 &&
					middleFinger.tipPosition().getX()> indexFinger.tipPosition().getX())
			{
				System.out.println("g");
			}
			
			if ((indexFinger.direction().roll() < 0 && indexFinger.direction().roll() > (-1.0*(22.0*7.0))) &&
					middleFinger.direction().roll() < 0 && middleFinger.direction().roll() > (-1.0*(22.0*7.0)) &&
					Math.abs(thumbFinger.tipPosition().getY() - middleFingerProximalBone.center().getY()) < 3 )
			{
				System.out.println("H");
			}
			
			
			if( (angleBetweenThumbAndIndex>=60 ) && (indexFinger.tipPosition().getY() - firstHand.palmPosition().getY() >=40 ) &&
					(indexFinger.tipPosition().getY() - middleFinger.tipPosition().getY() >=40 && indexFinger.tipPosition().getY() - ringFinger.tipPosition().getY() >=40 && indexFinger.tipPosition().getY() - pinkyFinger.tipPosition().getY() >=40)  )
			{
				System.out.println("L|L|L|L|L|L|L|L|L|L|L|L|L|L|L|L|L|L|L|L|L|L|L");
			}
			
			
			if( (thumbFinger.tipPosition().getX() >= (middleFinger.tipPosition().getX()-middleFinger.width() ) &&  thumbFinger.tipPosition().getX() <= indexFinger.tipPosition().getX()  )  &&
					(pinkyFinger.tipPosition().getY() - ringFinger.tipPosition().getY() >= 40 && pinkyFinger.tipPosition().getY() - middleFinger.tipPosition().getY() >= 40 && pinkyFinger.tipPosition().getY() - indexFinger.tipPosition().getY() >= 35 )   )
			{
				System.out.println("I|I|I|I|I|I|I|I|I|I|I|I|I|I|I|I|I|I|I|I|I|I|I");
			}
			
			if(  ( Math.abs(pinkyFingerDistalBone.center().getY() - firstHand.palmPosition().getY() ) <=15 &&  Math.abs(ringFingerDistalBone.center().getY() - firstHand.palmPosition().getY() ) <=25   )  &&  thumbFinger.tipPosition().getY() - firstHand.palmPosition().getY() >=20 &&
					(middleFinger.tipPosition().getY() - firstHand.palmPosition().getY() >=40 && indexFinger.tipPosition().getY() - firstHand.palmPosition().getY() >= 40) && (thumbFinger.tipPosition().getX()>middleFinger.tipPosition().getX() && thumbFinger.tipPosition().getX()<indexFinger.tipPosition().getX() ) )
			{
				System.out.println("K|K|K|K|K|K|K|K|K|K|K|K|K|K|K|K|K|K|K|K|K|K|K");
			}
			
			int value=40; // da half length of metacapals but use plam position butter than metacapals position for each type finger!!
			if((2*firstHand.sphereRadius()<=180) && (2*firstHand.sphereRadius()>=100) && ( indexFingerDistalBone.center().getY() <=  indexFinger.length() + firstHand.palmPosition().getY()+value ) && ( middleFingerDistalBone.center().getY() <=  middleFinger.length() + firstHand.palmPosition().getY()+value ) && ( ringFingerDistalBone.center().getY() <=  ringFinger.length() + firstHand.palmPosition().getY()+value ) && ( pinkyFingerDistalBone.center().getY() <=  pinkyFinger.length() + firstHand.palmPosition().getY()+value ) &&  ( thumbFingerDistalBone.center().getY() <=firstHand.palmPosition().getY()+value))
			{
				System.out.println("C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|C|");	
			}
			
			if(  (  thumbFinger.tipPosition().getX()>pinkyFingerProximalBone.center().getX() &&  thumbFinger.tipPosition().getX()<ringFingerProximalBone.center().getX()   )
					&& ( Math.abs( indexFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15  && Math.abs( middleFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15  && Math.abs( ringFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15  && Math.abs( pinkyFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15 ) )
			{
				System.out.println("M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M|M");
			}
			if(  (  thumbFinger.tipPosition().getX()>ringFingerIntermediateBone.center().getX() &&  thumbFinger.tipPosition().getX()<middleFingerIntermediateBone.center().getX()   )
					&& ( Math.abs( indexFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15  && Math.abs( middleFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15  && Math.abs( ringFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15  && Math.abs( pinkyFinger.tipPosition().getY()-firstHand.palmPosition().getY())<=15 ) )
			{
				System.out.println("N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N");
			}
			
			else if( (2*firstHand.sphereRadius()<=80) && (2*firstHand.sphereRadius()>=60) && ( firstHand.palmPosition().getY()-40 <= indexFingerDistalBone.center().getY())  && ( firstHand.palmPosition().getY()-40 <= middleFingerDistalBone.center().getY()) && ( firstHand.palmPosition().getY()-40 <= ringFingerDistalBone.center().getY()) && ( firstHand.palmPosition().getY()-40 <= pinkyFingerDistalBone.center().getY()) && ( firstHand.palmPosition().getY()-40 <= thumbFingerDistalBone.center().getY())  &&  (firstHand.direction().getY()>=0) ){
				System.out.println("O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O|O");
				
			}
			
			if((indexFinger.direction().roll() < 0 && indexFinger.direction().roll() > (-1.0*(22.0*7.0))) &&
					middleFinger.direction().pitch() < 0 && middleFinger.direction().pitch() > (-1.0*(22.0*7.0)) &&
					Math.abs(thumbFinger.tipPosition().getY() - middleFinger.tipPosition().getY())< 3 )
			{
				System.out.println("P");
			}
					
			if(indexFinger.direction().pitch() < 0 && indexFinger.direction().pitch() > (-1.0*(22.0*7.0)) &&
					thumbFinger.direction().pitch() < 0 && thumbFinger.direction().pitch() > (-1.0*(22.0*7.0)) )
			{
				System.out.println("Q");
			}
			
			if(Math.abs(middleFinger.tipPosition().getX()-indexFinger.tipPosition().getX())< 3 &&
					Math.abs(thumbFinger.tipPosition().getX()-ringFingerIntermediateBone.center().getX()) <3 )
			{
				System.out.println("R");
			}
			
			if(Math.abs(middleFingerIntermediateBone.center().getX()-thumbFinger.tipPosition().getX()) < 3 &&
					thumbFinger.tipPosition().getZ()>middleFinger.tipPosition().getZ())
			{
				System.out.println("S");
			}
			
			if( thumbFinger.tipPosition().getX()>middleFinger.tipPosition().getX() &&
					thumbFinger.tipPosition().getX()< indexFinger.tipPosition().getX() &&
					indexFinger.tipPosition().getZ()>thumbFinger.tipPosition().getZ())
			{
				System.out.println("T");
			}
				
			if( Math.abs(thumbFinger.tipPosition().getX()-ringFinger.tipPosition().getX()) <3 &&
					angleBetweeIndexAndMiddle < 2)
			{
				System.out.println("U");
			}
			if( Math.abs(thumbFinger.tipPosition().getX()-ringFinger.tipPosition().getX()) <3 &&
					angleBetweeIndexAndMiddle > 5)
			{
				System.out.println("V");
			}	
			if(thumbFinger.tipPosition().getX()<pinkyFinger.tipPosition().getX() &&
					ringFinger.tipPosition().getY()>thumbFinger.tipPosition().getY() && 
					middleFinger.tipPosition().getY()>thumbFinger.tipPosition().getY() && 
					indexFinger.tipPosition().getY()>thumbFinger.tipPosition().getY()  )
			{
				System.out.println("W");
			}
			
			if( ( indexFingerDistalBone.center().getY() >=  firstHand.palmPosition().getY()+40) && ( indexFingerDistalBone.center().getY() <= indexFinger.length() + firstHand.palmPosition().getY()+40) && ( middleFingerDistalBone.center().getY() <= firstHand.palmPosition().getY()+40 && middleFingerDistalBone.center().getY()>= firstHand.palmPosition().getY()-40) && ringFingerDistalBone.center().getY()<=firstHand.palmPosition().getY()+40 && ringFingerDistalBone.center().getY()>=firstHand.palmPosition().getY()-40 && pinkyFingerDistalBone.center().getY() <= firstHand.palmPosition().getY()+40 && pinkyFingerDistalBone.center().getY() >= firstHand.palmPosition().getY()-40 && thumbFingerDistalBone.center().getY() <= firstHand.palmPosition().getY()+40 && thumbFingerDistalBone.center().getY() >= firstHand.palmPosition().getY()-40 ){
				System.out.println("X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|X|");
			}
			if(ringFinger.tipPosition().getX() -pinkyFinger.tipPosition().getX() > 20 && 
					( thumbFinger.tipPosition().getX()) - indexFinger.tipPosition().getX() > 20 )
			{
				System.out.println("Y");
			}
		}
	}
}
