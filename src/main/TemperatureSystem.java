package main;

import java.beans.PropertyChangeListener;

public class TemperatureSystem extends AbstractSystem {
	
	private int temperature;

	protected TemperatureSystem(String roomName) {
		super(roomName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		if (!listenerSupport.hasListeners(roomName)) {
			listenerSupport.addPropertyChangeListener(roomName, listener);
		} else {
			System.out.println("The temperature sensor has already been installed");
		}
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public void setTemperature(int temperatureNewValue) {
		if (listenerSupport.hasListeners(roomName)) {
			int temperatureOldValue = temperature;
			temperature = temperatureNewValue;
			listenerSupport.fireIndexedPropertyChange(
				roomName,
				0,
				temperatureOldValue,
				temperatureNewValue
			);
		} else {
			//Sensor is not installed
			temperature = temperatureNewValue;
		}
	}

}
