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
         System.out.println(">>>> �ִ�!");
         if(file.isDirectory()) {
            String[] fileList = file.list();
            for(String fileName : fileList) {
               System.out.println(fileName);
            }
         } else {
            if(file.delete()) {
               System.out.println(">>>> ������ ���� ��!");
            }
         }
      } else {
         System.out.println(">>>> ����!");
         if(file.createNewFile()) {
            System.out.println("������ ���� �Ǿ����ϴ�.");
         }
      }
   }
   
   public static void test03(String[] args) throws IOException {
      // ���Ͽ��� ������ �о����
      // InputStream is = System.in;
      File file = new File("C:\\Users\\Administrator\\data.txt");
      FileInputStream is = new FileInputStream(file);
      int data = 0;
      while((data = is.read()) != -1) {
         System.out.write(data);
      }
      is.close();
      System.out.println("���� �б� �Ϸ�!");
   }
   
   public static void test02(String[] args) throws IOException {
      //OutputStream os = System.out;
      FileOutputStream os = new FileOutputStream("C:\\Users\\Administrator\\data.txt");
      InputStream is = System.in;
      
      //int data = is.read();  // �ƽ�Ű�ڵ� a(97), A(65), 0(48), \n(13)
      //System.out.println(data);
      System.out.println("�����͸� �Է� �� ������. (�������� Ctrl+z) :");
      int data = 0;
      while((data=is.read()) != -1) {  // EOF�϶����� (Ctrl + z)
         os.write(data);
      }
      os.close();
      System.out.println("�Է� ����!");
   }

   public static void test01(String[] args) throws IOException {
      OutputStream os = System.out; // ��ĳ����
      byte[] by = new byte[255];
      
      System.out.print("���� �Է� << ");
      System.in.read(by);
      
      String s = new String(by).trim();
      
      os.write(s.getBytes());
   }

}