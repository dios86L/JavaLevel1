package Package01.Package02;

import java.io.*;


public class Lesson6 {
   private static FileOutputStream fos;
    private static FileInputStream fis;

   private static void mergeFile (String file1, String file2, String result) {
       try {
           fos = new FileOutputStream(result);
           int ch;
           fis = new FileInputStream(file1);
           while ((ch=fis.read()) != -1)
               fos.write(ch);
               fis.close();

           fis = new FileInputStream(file2);
           while ((ch=fis.read()) != -1){
               fos.write(ch);
           }
               fis.close();

           fos.flush();
           fos.close();

       }catch (IOException e) {
           System.err.println("Что-то пошло не так. Причина " + e.getCause());
       }

   }

    public static void main(String[] args) {
           mergeFile("FileOne.txt", "FileTwo.txt", "Result.txt" );
           System.out.println("Смотри Result.txt");
    }
}
