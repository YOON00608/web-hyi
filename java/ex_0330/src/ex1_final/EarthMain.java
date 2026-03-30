package ex1_final;

public class EarthMain {
	public static void main(String[] args) {
		
		// 상수 읽기
		// static이 명시 되어 있어서 객체를 정의할 필요가 없다.
		
		System.out.println("지구의 반지름 : " + Earth.EARTH_RADIUS + "km");
		System.out.println("지구의 표면적 : " + Earth.EARTH_SURFACE_AREA + "km^2");
		// 지구의 반지름 : 6400.0km
		// 지구의 표면적 : 5.147185403641517E8km^2
		
		
	}
}
