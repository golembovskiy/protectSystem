package main;

import main.Detector.DetectorType;

public class ControlBoard implements ReactionIF, ProtectSystem {

	@Override
	public void doSomething(AlarmMsg msg) {
		// TODO Auto-generated method stub
		System.out.println("The control unit has received the alarm signal from ");
		switch((DetectorType) msg.getParameters()) {
			case TEMPERATURE_DETECTOR:
			{
				System.out.println("the temperature sensor");
				fightFire();
				break;
			}
			case MOTION_DETECTOR:
			{
				System.out.println("the motion sensor");
				activateAlarm();
				break;
			}
			case WATER_DETECTOR:
			{
				System.out.println("the water level sensor");
				blockWaterSupply();
				break;
			}
			default:
				break;
		}
	}

	/*
	 * Если возникает какое либо событие - вызываем System.exit(0);
	 */
	
	@Override
	public void fightFire() {
		// TODO Auto-generated method stub
		System.out.println("Running the fair protection system");
		System.exit(0);
	}

	@Override
	public void activateAlarm() {
		// TODO Auto-generated method stub
		System.out.println("Enabled the alarm system");
		System.exit(0);
	}

	@Override
	public void blockWaterSupply() {
		// TODO Auto-generated method stub
		System.out.println("Off the water supply");
		System.exit(0);
	}

}
