package main;

import java.beans.PropertyChangeListener;

import main.Detector.DetectorType;

public class Home {
	private ControlBoard controlBoard;
	private Room[] rooms;
	
	public Home() {
		controlBoard = new ControlBoard();
		
		rooms = new Room[] {new Room("1", controlBoard, 20), new Room("2", controlBoard, 20), new Room("3", controlBoard, 20)};
		for (Room room : rooms) {
			room.addListener(Detector.detectorFactory(DetectorType.MOTION_DETECTOR, controlBoard));
			
		}
	}
	
	public int getRoomCount() {
		return rooms.length;
	}
}

class Room extends AbstractSystem implements Runnable {
	
	private Thread thread;
	
	private String roomName;
	
	private WaterSystem waterSystem;
	private TemperatureSystem temperatureSystem;
	
	private boolean movingObjectState;
	
	public Room(String roomName, ControlBoard controlBoard, int temperature) {
		super(roomName);
		
		this.roomName = roomName;
		
		waterSystem = new WaterSystem(roomName);
		waterSystem.addListener(Detector.detectorFactory(DetectorType.WATER_DETECTOR, controlBoard));
		
		temperatureSystem = new TemperatureSystem(roomName);
		temperatureSystem.setTemperature(temperature);
		temperatureSystem.addListener(Detector.detectorFactory(DetectorType.TEMPERATURE_DETECTOR, controlBoard));
		
		thread = new Thread(this, "");
		thread.start();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		if (!listenerSupport.hasListeners(roomName)) {
			listenerSupport.addPropertyChangeListener(roomName, listener);
		} else {
			System.out.println("The motion sensor has already been installed");
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			try {
				Main.test(this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public String getName() {
		return roomName;
	}
	
	public int getTemperature() {
		return temperatureSystem.getTemperature();
	}
	
	public void setTemperature(int temperature) {
		temperatureSystem.setTemperature(temperature);
	}
	
	public boolean getLeakage() {
		return waterSystem.getLeakage();
	}
	
	public void setLeakage(boolean state) {
		waterSystem.setLeakage(state);
	}
	
	public boolean getMovingObjectState() {
		return movingObjectState;
	}
	
	public void setMovingObjectState(boolean newState) {
		if (listenerSupport.hasListeners(roomName)) {
			boolean oldState = movingObjectState;
			movingObjectState = newState;
			listenerSupport.fireIndexedPropertyChange(
				roomName,
				0,
				oldState,
				newState
			);
		} else {
			//Sensor is not installed
			movingObjectState = newState;
		}
	}
	
}
