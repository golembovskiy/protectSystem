package main;

import java.beans.PropertyChangeEvent;

public class TemperatureDetector extends Detector {
	
	private final int MAX_TEMPERATURE = 50;
	
	public TemperatureDetector(ControlBoard controlBoard) {
		super(controlBoard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void signal() {
		// TODO Auto-generated method stub
		System.out.println("The temperature sensor sends a signal to the control panel");
		AlarmMsg msg = new AlarmMsg("The inclusion of fire protection system", DetectorType.TEMPERATURE_DETECTOR);
		controlBoard.doSomething(msg);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		int newValue = 0;
		try {
			newValue = (Integer) event.getNewValue();
		} catch(ClassCastException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("Temperature: " + newValue);
		
		if (newValue >= MAX_TEMPERATURE) {
			System.out.println("Triggered the temperature sensor in the room " + event.getPropertyName());
			signal();
		}
	}

	@Override
	public DetectorType getType() {
		// TODO Auto-generated method stub
		return DetectorType.TEMPERATURE_DETECTOR;
	}

}
