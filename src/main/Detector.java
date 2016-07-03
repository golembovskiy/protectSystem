package main;

import java.beans.PropertyChangeListener;

public abstract class Detector implements AlarmIF, PropertyChangeListener {
	
	public enum DetectorType {
		TEMPERATURE_DETECTOR, MOTION_DETECTOR, WATER_DETECTOR
	}
	
	protected ControlBoard controlBoard;
	
	/*
	 * The ControlBoard class has method doSomething which will be called from this class
	 */
	public Detector(ControlBoard controlBoard) {
		this.controlBoard = controlBoard;
	}
	
	public abstract DetectorType getType();
	
	public static Detector detectorFactory(DetectorType type, ControlBoard controlBoard) {
		switch (type) {
			case TEMPERATURE_DETECTOR:
				return new TemperatureDetector(controlBoard);
			case MOTION_DETECTOR:
				return new MotionDetector(controlBoard);
			case WATER_DETECTOR:
				return new WaterDetector(controlBoard);
			default:
				return null;
		}
	}

}
