package ex1_generic.remoteControlExample;

public class Tv implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("Tv 전원 켜기");
	}
}
