package ex1_reflection.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Car {
	
	private String model;
	private String owner;
	
	public Car(String model) {
		this.model = model;
	}
}
