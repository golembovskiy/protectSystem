package main;

import java.beans.PropertyChangeEvent;

public class WaterDetector extends Detector {

	public WaterDetector(ControlBoard controlBoard) {
		super(controlBoard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void signal() {
		// TODO Auto-generated method stub
		System.out.println("The water level sensor sends a signal to the control panel");
		AlarmMsg msg = new AlarmMsg("Off the water supply", DetectorType.WATER_DETECTOR);
		controlBoard.doSomething(msg);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Triggered the water level sensor in the room " + event.getPropertyName());
		signal();
	}

	@Override
	public DetectorType getType() {
		// TODO Auto-generated method stub
		return DetectorType.WATER_DETECTOR;
	}

}
