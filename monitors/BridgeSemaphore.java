package monitors;

public class BridgeSemaphore {
	private static boolean bridgeFlag = true; // true - podniesiony, falsa - opuszczony
	
	
	public synchronized static boolean waitBridge(){
		if(bridgeFlag == true){
			bridgeFlag = false;
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized static void signalBridge(){
		bridgeFlag = true;
	}
}
