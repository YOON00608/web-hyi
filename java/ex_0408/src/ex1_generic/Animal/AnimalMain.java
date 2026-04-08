package ex1_generic.Animal;

public class AnimalMain {
	public static void main(String[] args) {
		
		AnimalHospital<Dog> dogHospital = new AnimalHospital<>(new Dog());
		AnimalHospital<Cat> CatHospital = new AnimalHospital<>(new Cat());
		
		// 동물병원은 동물만 다루는 곳인데
		// 문자열이나 숫자 등등 다른 객체가 들어오면 이상해진다.
		dogHospital.treat();
		CatHospital.treat();
	}
}
