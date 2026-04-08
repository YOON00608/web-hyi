package ex1_generic.remoteControlExample;

public class Audio implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("Audio 전원 켜기");
	}
}
