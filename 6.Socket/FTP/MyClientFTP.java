import java.net.*;  
import java.io.*;
import java.util.*;  
class MyClientFTP{  
public static void main(String args[])throws Exception{  
  Scanner scan = new Scanner(System.in);
Socket s=new Socket("localhost",3333);  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
String str="",recFile="";  
while(!str.equals("bye")){ 
  System.out.println("Enter your choice: \n1.send\n2.recive");
  int ch =scan.nextInt();
  switch (ch){
    case 1: System.out.print("Enter the file name: ");
                String filePath =scan.next();
                dout.writeUTF(filePath);
                File file = new File(filePath);
                DataInputStream reader = new DataInputStream(new FileInputStream(file));
                 int in = 0;  
                 while(in!=-1)
                  {  in=reader.read();
                  dout.writeInt(in);                  
                 }
   
       
                dout.flush(); 
                break;
    case 2: recFile=din.readUTF();  
            //Content=din.readUTF(); 
            DataOutputStream writer = new DataOutputStream(new FileOutputStream(recFile));
            while(true)
                { 
                 int c=din.readInt();
                 if(c==-1){
                   break;
                  }  
                 writer.write(c);
                }
             writer.close();
            break;
    case 3:str="bye";
            break;
    default :System.out.println("invalid option"); 
            break;
  }


  
}  
scan.close(); 
dout.close();  
s.close();  
}}  
