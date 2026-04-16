package ex2_charstream.exam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class FileConverter {

    public void copy(String source, String target) {
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target);
             FileWriter fw = new FileWriter("log.txt", true)) {

            byte[] buffer = new byte[1024]; 
            int length;
            long totalBytes = 0;

           
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
                totalBytes += length; 
            }

            System.out.println("이미지 복사 완료: " + target);

            
            fw.write("복사된 파일: " + target + " / 크기: " + totalBytes + " bytes\n");
            System.out.println("로그 기록 완료 (log.txt)");

        } catch (Exception e) {
            System.err.println("오류 발생: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FileConverter converter = new FileConverter();
        converter.copy("wall.jpg", "wall_copy.jpg");
    	
    	
    }
}
