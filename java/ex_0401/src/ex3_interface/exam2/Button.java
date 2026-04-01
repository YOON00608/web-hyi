package ex3_interface.exam2;

public class Button {
	ClickListener listener;
	
	public void setListener(ClickListener listener) {
		this.listener = listener;
	}
	
	public void Click() {
		listener.onClick();
	}
}
