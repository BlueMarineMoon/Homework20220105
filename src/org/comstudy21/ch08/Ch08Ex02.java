package org.comstudy21.ch08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ch08Ex02 {
   
   public static void main(String[] args) throws IOException {
      // File
      File file = new File("C:\\Users\\Administrator\\test_myfile.txt");
      if(file.exists()) {
         System.out.println(">>>> 있다!");
         if(file.isDirectory()) {
            String[] fileList = file.list();
            for(String fileName : fileList) {
               System.out.println(fileName);
            }
         } else {
            if(file.delete()) {
               System.out.println(">>>> 파일이 삭제 됨!");
            }
         }
      } else {
         System.out.println(">>>> 없다!");
         if(file.createNewFile()) {
            System.out.println("파일이 생성 되었습니다.");
         }
      }
   }
   
   public static void test03(String[] args) throws IOException {
      // 파일에서 데이터 읽어오기
      // InputStream is = System.in;
      File file = new File("C:\\Users\\Administrator\\data.txt");
      FileInputStream is = new FileInputStream(file);
      int data = 0;
      while((data = is.read()) != -1) {
         System.out.write(data);
      }
      is.close();
      System.out.println("파일 읽기 완료!");
   }
   
   public static void test02(String[] args) throws IOException {
      //OutputStream os = System.out;
      FileOutputStream os = new FileOutputStream("C:\\Users\\Administrator\\data.txt");
      InputStream is = System.in;
      
      //int data = is.read();  // 아스키코드 a(97), A(65), 0(48), \n(13)
      //System.out.println(data);
      System.out.println("데이터를 입력 해 보세요. (끝내려면 Ctrl+z) :");
      int data = 0;
      while((data=is.read()) != -1) {  // EOF일때까지 (Ctrl + z)
         os.write(data);
      }
      os.close();
      System.out.println("입력 종료!");
   }

   public static void test01(String[] args) throws IOException {
      OutputStream os = System.out; // 업캐스팅
      byte[] by = new byte[255];
      
      System.out.print("문자 입력 << ");
      System.in.read(by);
      
      String s = new String(by).trim();
      
      os.write(s.getBytes());
   }

}