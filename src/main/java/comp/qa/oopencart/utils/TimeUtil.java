package comp.qa.oopencart.utils;

public class TimeUtil {
	
	private static final int VERY_SHORT_WAIT=1000;
	private static final int SHORT_WAIT=5000;
	private static final int MEDIUM_WAIT=10000;
	private static final int LONG_WAIT=15000;
	private static final int LONGER_WAIT=20000;
	
	public static void veryShortWait()
	{
		try {
			Thread.sleep(VERY_SHORT_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void shortWait()
	{
		try {
			Thread.sleep(SHORT_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void mediumWait()
	{
		try {
			Thread.sleep(MEDIUM_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void longWait()
	{
		try {
			Thread.sleep(LONG_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void longerWait()
	{
		try {
			Thread.sleep(LONGER_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
