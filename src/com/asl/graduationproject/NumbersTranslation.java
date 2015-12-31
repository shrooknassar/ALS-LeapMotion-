
import java.io.IOException;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Finger.Type;
import com.leapmotion.leap.Gesture.State;



class LeapListener extends Listener{
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
			
			for (Hand hand : frame.hands()){
			
			
			for(Finger finger_index : frame.fingers().fingerType(Type.TYPE_INDEX) ){
				float length_index=finger_index.length();
		
				for(Finger finger__middle : frame.fingers().fingerType(Type.TYPE_MIDDLE) ){
					float length_middle=finger__middle.length();
				
					for(Finger finger_pinky : frame.fingers().fingerType(Type.TYPE_PINKY) ){
							float length_pinky=finger_pinky.length();
					
							for(Finger finger_ring : frame.fingers().fingerType(Type.TYPE_RING) ){
									float length_ring=finger_ring.length();
		
									for(Finger finger_thumb : frame.fingers().fingerType(Type.TYPE_THUMB) ){
										float length_thumb=finger_thumb.length();
										
										for(Bone.Type  boneType : Bone.Type.values())
										{
											//all type Bone of index
											Bone bone_distal_for_index=finger_index.bone(com.leapmotion.leap.Bone.Type.TYPE_DISTAL);
											Bone bone_intermediate_for_index=finger_index.bone(com.leapmotion.leap.Bone.Type.TYPE_INTERMEDIATE);
											Bone bone_procimal_for_index=finger_index.bone(com.leapmotion.leap.Bone.Type.TYPE_PROXIMAL);
											Bone bone_metacarpal_for_index=finger_index.bone(com.leapmotion.leap.Bone.Type.TYPE_METACARPAL);
											//all type Bone of middle
											Bone bone_distal_for_middle=finger__middle.bone(com.leapmotion.leap.Bone.Type.TYPE_DISTAL);
											Bone bone_intermediate_for_middle=finger__middle.bone(com.leapmotion.leap.Bone.Type.TYPE_INTERMEDIATE);
											Bone bone_procimal_for_midlle=finger__middle.bone(com.leapmotion.leap.Bone.Type.TYPE_PROXIMAL);
											Bone bone_metacarpal_for_middle=finger__middle.bone(com.leapmotion.leap.Bone.Type.TYPE_METACARPAL);
											//all type Bone of ring
											Bone bone_distal_for_ring=finger_ring.bone(com.leapmotion.leap.Bone.Type.TYPE_DISTAL);
											Bone bone_intermediate_for_ring=finger_ring.bone(com.leapmotion.leap.Bone.Type.TYPE_INTERMEDIATE);
											Bone bone_procimal_for_ring=finger_ring.bone(com.leapmotion.leap.Bone.Type.TYPE_PROXIMAL);
											Bone bone_metacarpal_for_ring=finger_ring.bone(com.leapmotion.leap.Bone.Type.TYPE_METACARPAL);
											//all type Bone of pinky
											Bone bone_distal_for_pinky=finger_pinky.bone(com.leapmotion.leap.Bone.Type.TYPE_DISTAL);
											Bone bone_intermediate_for_pinky=finger_pinky.bone(com.leapmotion.leap.Bone.Type.TYPE_INTERMEDIATE);
											Bone bone_procimal_for_pinky=finger_pinky.bone(com.leapmotion.leap.Bone.Type.TYPE_PROXIMAL);
											Bone bone_metacarpal_for_pinky=finger_pinky.bone(com.leapmotion.leap.Bone.Type.TYPE_METACARPAL);
											//all type Bone of thumb
											Bone bone_distal_for_thumb=finger_thumb.bone(com.leapmotion.leap.Bone.Type.TYPE_DISTAL);
											Bone bone_intermediate_for_thumb=finger_thumb.bone(com.leapmotion.leap.Bone.Type.TYPE_INTERMEDIATE);
											Bone bone_procimal_for_thumb=finger_thumb.bone(com.leapmotion.leap.Bone.Type.TYPE_PROXIMAL);
											Bone bone_metacarpal_for_thumb=finger_thumb.bone(com.leapmotion.leap.Bone.Type.TYPE_METACARPAL);
										
										
											
											
											
											
											/*System.out.println( "palmPosition Hand:" +hand.palmPosition().getY()
															+"  ,bone distal fo index: "+ bone_distal_for_index.center().getY()			
															+"  ,bone distal for middle: " + bone_distal_for_middle.center().getY() 
															+"  ,bone distal for ring: " + bone_distal_for_ring.center().getY()  
															+"  ,bone distal for pinky: " + bone_distal_for_pinky.center().getY()
															+"  ,bone distal for thumb: "+bone_distal_for_thumb.center().getY());
											//System.out.println(" ,length_index + hand.palmPosition().getY(): " +  ( length_index + hand.palmPosition().getY())  );*/
											//System.out.println("---->Thumb lehgth: "+ length_thumb);
											/*System.out.println("Sphere: "+ 2*hand.sphereRadius()
																+ "  ,direction hand x: " +hand.direction().getX()
																+ "  ,direction hand y: " +hand.direction().getY()
																+ "  ,direction hand z: " +hand.direction().getZ());*/
											//five
											if( ( bone_distal_for_index.center().getY()+40 >=  length_index + hand.palmPosition().getY() ) && ( bone_distal_for_middle.center().getY()+40 >=  length_middle + hand.palmPosition().getY() ) && ( bone_distal_for_ring.center().getY()+40 >=  length_ring + hand.palmPosition().getY() ) && ( bone_distal_for_pinky.center().getY()+40 >=  length_pinky + hand.palmPosition().getY() ) && ( bone_distal_for_thumb.center().getY()+40 <=  length_thumb + hand.palmPosition().getY() ) ){
												System.out.println("Five|Five|Five|Five|Five|Five|Five|Five|Five|Five|Five|Five");
											}
											//zero
											else if( (2*hand.sphereRadius()<=80) && (2*hand.sphereRadius()>=60) && ( hand.palmPosition().getY()-40 <= bone_distal_for_index.center().getY())  && ( hand.palmPosition().getY()-40 <= bone_distal_for_middle.center().getY()) && ( hand.palmPosition().getY()-40 <= bone_distal_for_ring.center().getY()) && ( hand.palmPosition().getY()-40 <= bone_distal_for_pinky.center().getY()) && ( hand.palmPosition().getY()-40 <= bone_distal_for_thumb.center().getY())  &&  (hand.direction().getY()>=0) ){
												System.out.println("zero|zero|zero|zero|zero|zero|zero|zero|zero|zero|zero|zero|");
												
											}
											//One
											else if( ( bone_distal_for_index.center().getY()+40 >=  length_index + hand.palmPosition().getY() ) && ( bone_distal_for_middle.center().getY() <= hand.palmPosition().getY()+40 && bone_distal_for_middle.center().getY()>= hand.palmPosition().getY()-40) && bone_distal_for_ring.center().getY()<=hand.palmPosition().getY()+40 && bone_distal_for_ring.center().getY()>=hand.palmPosition().getY()-40 && bone_distal_for_pinky.center().getY() <= hand.palmPosition().getY()+40 && bone_distal_for_pinky.center().getY() >= hand.palmPosition().getY()-40 && bone_distal_for_thumb.center().getY() <= hand.palmPosition().getY()+40  &&  bone_distal_for_thumb.center().getY() >= hand.palmPosition().getY()-40 ){
												System.out.println("One|One|One|One|One|One|One|One|One|One|One|One|One");
											}
											//Two
											else if( ( bone_distal_for_index.center().getY()+40 >=  length_index + hand.palmPosition().getY() ) &&  ( bone_distal_for_middle.center().getY()+40 >=  length_middle + hand.palmPosition().getY() ) && bone_distal_for_ring.center().getY()<=hand.palmPosition().getY()+40 && bone_distal_for_ring.center().getY()>=hand.palmPosition().getY()-40 && bone_distal_for_pinky.center().getY() <= hand.palmPosition().getY()+40 && bone_distal_for_pinky.center().getY() >= hand.palmPosition().getY()-40 && bone_distal_for_thumb.center().getY() <= hand.palmPosition().getY()+40  &&  bone_distal_for_thumb.center().getY() >= hand.palmPosition().getY()-40 ){
												System.out.println("Two|Two|Two|Two|Two|Two|Two|Two|Two|Two|Two|Two|Two|Two");
											}
											//Three
											else if( ( bone_distal_for_index.center().getY()+40 >=  length_index + hand.palmPosition().getY() ) &&  ( bone_distal_for_middle.center().getY()+30 >=  length_middle + hand.palmPosition().getY() ) && bone_distal_for_ring.center().getY()<=hand.palmPosition().getY()+40 && bone_distal_for_ring.center().getY()>=hand.palmPosition().getY()-40 && bone_distal_for_pinky.center().getY() <= hand.palmPosition().getY()+40 && bone_distal_for_pinky.center().getY() >= hand.palmPosition().getY()-40 &&  ( bone_distal_for_thumb.center().getY()+40 >=  length_thumb + hand.palmPosition().getY() )){
												System.out.println("Three|Three|Three|Three|Three|Three|Three|Three|Three|Three|Three|Three|Three");
											}
											//Four
											else if( ( bone_distal_for_index.center().getY()+40 >=  length_index + hand.palmPosition().getY() ) && ( bone_distal_for_middle.center().getY()+40 >=  length_middle + hand.palmPosition().getY() ) && ( bone_distal_for_ring.center().getY()+40 >=  length_ring + hand.palmPosition().getY() ) && ( bone_distal_for_pinky.center().getY()+40 >=  length_pinky + hand.palmPosition().getY() ) && bone_distal_for_thumb.center().getY() <= hand.palmPosition().getY()+40  &&  bone_distal_for_thumb.center().getY() >= hand.palmPosition().getY()-40   ){
												System.out.println("Four|Four|Four|Four|Four|Four|Four|Four|Four|Four|Four|Four|Four|Four|Four|Four|");
											}
											//Six
											else if( ( bone_distal_for_index.center().getY()+40 >=  length_index + hand.palmPosition().getY() ) && ( bone_distal_for_middle.center().getY()+40 >=  length_middle + hand.palmPosition().getY() ) && ( bone_distal_for_ring.center().getY()+40 >=  length_ring + hand.palmPosition().getY() ) &&  bone_distal_for_pinky.center().getY() <= hand.palmPosition().getY()+40 && bone_distal_for_pinky.center().getY() >= hand.palmPosition().getY()-40 && bone_distal_for_thumb.center().getY() <= hand.palmPosition().getY()+40  &&  bone_distal_for_thumb.center().getY() >= hand.palmPosition().getY()-40 ){
												System.out.println("Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|Six|");
											}
											//Seven
											else if( ( bone_distal_for_index.center().getY()+40 >=  length_index + hand.palmPosition().getY() ) && ( bone_distal_for_middle.center().getY()+40 >=  length_middle + hand.palmPosition().getY() ) && bone_distal_for_ring.center().getY()<=hand.palmPosition().getY()+40 && bone_distal_for_ring.center().getY()>=hand.palmPosition().getY()-40  && ( bone_distal_for_pinky.center().getY()+40 >=  length_pinky + hand.palmPosition().getY() ) && bone_distal_for_thumb.center().getY() <= hand.palmPosition().getY()+40  &&  bone_distal_for_thumb.center().getY() >= hand.palmPosition().getY()-40 ){
												System.out.println("Seven|Seven|Seven|Seven|Seven|Seven|Seven|Seven|Seven|Seven|Seven|Seven|Seven|Seven");
											}
											//eight
											else if( ( bone_distal_for_index.center().getY()+40 >=   + hand.palmPosition().getY() ) && ( bone_distal_for_middle.center().getY() <= hand.palmPosition().getY()+40 && bone_distal_for_middle.center().getY()>= hand.palmPosition().getY()-40) && bone_distal_for_ring.center().getY()<=hand.palmPosition().getY()+40 && bone_distal_for_ring.center().getY()>=hand.palmPosition().getY()-40  && ( bone_distal_for_pinky.center().getY()+40 >=  length_pinky + hand.palmPosition().getY() ) && bone_distal_for_thumb.center().getY() <= hand.palmPosition().getY()+40  &&  bone_distal_for_thumb.center().getY() >= hand.palmPosition().getY()-40 ){
												System.out.println("Eight|Eight|Eight|Eight|Eight|Eight|Eight|Eight|Eight|Eight|Eight|Eight|Eight|Eight|");
											}
											//nine
											else if( ( bone_distal_for_index.center().getY() <= hand.palmPosition().getY()+40 && bone_distal_for_index.center().getY()>= hand.palmPosition().getY()-40) && ( bone_distal_for_middle.center().getY()+40 >=  length_middle + hand.palmPosition().getY() ) && ( bone_distal_for_ring.center().getY()+40 >=  length_ring + hand.palmPosition().getY() ) && ( bone_distal_for_pinky.center().getY()+40 >=  length_pinky + hand.palmPosition().getY() ) && bone_distal_for_thumb.center().getY() <= hand.palmPosition().getY()+40  &&  bone_distal_for_thumb.center().getY() >= hand.palmPosition().getY()-40   ){
												System.out.println("Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|Nine|");
											}
											//ten
											else if( bone_distal_for_thumb.center().getY() >= length_thumb +hand.palmPosition().getY() &&  bone_distal_for_index.center().getY()<= hand.palmPosition().getY() && bone_distal_for_middle.center().getY()>= hand.palmPosition().getY() &&  bone_distal_for_ring.center().getY() <= hand.palmPosition().getY() &&  bone_distal_for_pinky.center().getY() <= hand.palmPosition().getY() ){
												
												GestureList gestures = frame.gestures();
												for(int i=0;i<gestures.count();i++){
													Gesture gesture=gestures.get(i);
													switch(gesture.type()){
														case TYPE_SWIPE:
															SwipeGesture swipe =new SwipeGesture(gesture);
															System.out.println("Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|Ten|");

														break;
													default:
														break;
													}
												}
											}
											
											
											
										
									}
							}
					}
				}
			}
		}
	}
				
				
	}
}
