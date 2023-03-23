import java.net.*;
import java.util.Scanner;
import java.io.*;  
class MyServerFTP{  
public static void main(String args[])throws Exception{  
  Scanner scan = new Scanner(System.in);
ServerSocket ss=new ServerSocket(3333);  
Socket s=ss.accept();  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
String str="",recFile="";  
while(!str.equals("bye")){
  System.out.println("Enter your choice: \n1.send\n2.recive");
  int ch =scan.nextInt();
  
  switch (ch){
    case 1:
            System.out.print("Enter the file name: ");
            String filePath =scan.next();
            dout.writeUTF(filePath);
            File file = new File(filePath);
            DataInputStream reader = new DataInputStream(new FileInputStream(file));
            int out = 0;  
            while(out!=-1)
            {  out=reader.read();
              dout.writeInt(out);                  
             }
           
               
            dout.flush(); 
            break;
    case 2: recFile=din.readUTF();  
    DataOutputStream writer = new DataOutputStream(new FileOutputStream(recFile));
    while(true)
        { 
          int in=din.readInt();
         if(in==-1){
           break;
          }  
         writer.write(in);
        }
     writer.close();
    break;
    case 3:str="bye";
            break;
  default :System.out.println("invalid option"); 
            break;
  } 
}  
din.close();
scan.close(); 
s.close();  
ss.close();  
}}  
