package T_0329;

public class St_Array {
	public static void main(String[] args) {
		int kor[] = {84,93,52,42};
		int mat[] = {61,71,79,100};
		int eng[] = {55,80,33,52};
		
		double C = (kor[0]+mat[0]+eng[0]) / 3.0;
		double O = (kor[1]+mat[1]+eng[1]) / 3.0;
		double G = (kor[2]+mat[2]+eng[2]) / 3.0;
		double U = (kor[3]+mat[3]+eng[3]) / 3.0;
		
		System.out.printf("%.1f\n", C);
		System.out.printf("%.1f\n", O);
		System.out.printf("%.1f\n", G);
		System.out.printf("%.1f\n", U);
		
		System.out.println("--------------------");
		
		for (int i = 0; i < kor.length; i++) {
		double avg = (kor[i] + mat[i] + eng[i]) / 3.0;
		System.out.printf("%.1f\n",avg);
		}
	}
}
