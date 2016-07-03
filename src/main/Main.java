package main;

import java.util.Random;

public class Main {
	
	private static int probability1 = 5/*%*/; //probability of fire
	private static int probability2 = 5/*%*/; //probability of penetration
	private static int probability3 = 5/*%*/; //probability of flood
	
	private static Random random = new Random();
	
	private static int roomCount;
	private static volatile int cnt;
	
	public static void main(String[] args) {
		roomCount = new Home().getRoomCount();
	}
	
	public static synchronized void test(Room room) throws InterruptedException {
		if (Integer.parseInt(room.getName()) == cnt + 1) {
			
			boolean event1 = (random.nextInt(100) < probability1 ? true : false);
			boolean event2 = (random.nextInt(100) < probability2 ? true : false);
			boolean event3 = (random.nextInt(100) < probability3 ? true : false);
			
			if (event1) {
				room.setTemperature(50);
			}
			
			room.setMovingObjectState(event2);
			
			room.setLeakage(event3);
			
			if (!event1 && !event2 && !event3) {
				System.out.println("In room " + room.getName() + " are no events happening");
			}
			
			if (cnt == roomCount - 1) {
				cnt = 0;
			} else {
				cnt++;
			}
			
			Thread.sleep(1000);
		} else {
			Thread.yield();
		}
	}

}
