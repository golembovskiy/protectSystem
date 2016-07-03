package main;

import java.beans.PropertyChangeListener;

public class WaterSystem extends AbstractSystem {
	
	private boolean leakage;

	protected WaterSystem(String roomName) {
		super(roomName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		if (!listenerSupport.hasListeners(roomName)) {
			listenerSupport.addPropertyChangeListener(roomName, listener);
		} else {
			System.out.println("The water level sensor has already been installed");
		}
	}
	
	public boolean getLeakage() {
		return leakage;
	}
	
	public void setLeakage(boolean newState) {
		if (listenerSupport.hasListeners(roomName)) {
			boolean oldState = leakage;
			leakage = newState;
			listenerSupport.fireIndexedPropertyChange(
				roomName,
				0,
				oldState,
				newState
			);
		} else {
			//Sensor is not installed
			leakage = newState;
		}
	}

}
