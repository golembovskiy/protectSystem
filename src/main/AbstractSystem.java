package main;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractSystem {
	
	protected String roomName;
	
	protected PropertyChangeSupport listenerSupport;
	
	protected AbstractSystem(String roomName) {
		this.roomName = roomName;
		listenerSupport = new PropertyChangeSupport(this);
	}
	
	public abstract void addListener(PropertyChangeListener listener);

}
