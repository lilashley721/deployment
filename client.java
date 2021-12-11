import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       try{
           Socket s=new Socket("localhost",8080);
           DataInputStream dis=new DataInputStream(s.getInputStream());
           DataOutputStream dout=new DataOutputStream(s.getOutputStream());

           System.out.print("Hello");
           System.out.print("\n Please enter a Number : ");
           int num = scan.nextInt();
           
           dout.writeInt(num);
           String ans = (String)dis.readUTF();
           System.out.println("\n The Number "+num+
                               " The is a Prime Number: "+ans);
           dout.flush();
           dout.close();
           s.close();
       }
       catch(Exception e){
           System.out.println(e);
       }
       scan.close();
   }
}