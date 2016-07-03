package main;

import java.beans.PropertyChangeEvent;

public class MotionDetector extends Detector {

	public MotionDetector(ControlBoard controlBoard) {
		super(controlBoard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void signal() {
		// TODO Auto-generated method stub
		System.out.println("The motion sensor sends a signal to the control panel");
		AlarmMsg msg = new AlarmMsg("Activate the alarm system", DetectorType.MOTION_DETECTOR);
		controlBoard.doSomething(msg);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Triggered the motion sensor in the room " + event.getPropertyName());
		signal();
	}

	@Override
	public DetectorType getType() {
		// TODO Auto-generated method stub
		return DetectorType.MOTION_DETECTOR;
	}
	
}
