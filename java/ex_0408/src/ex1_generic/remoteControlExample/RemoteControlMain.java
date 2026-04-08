package ex1_generic.remoteControlExample;

public class RemoteControlMain {
	public static void main(String[] args) {
		
		DeviceManager<Tv> tvManager = new DeviceManager<>(new Tv());
		DeviceManager<Audio> audioManager = new DeviceManager<>(new Audio());
		
		tvManager.powerOn();
		audioManager.powerOn();
	}
}
