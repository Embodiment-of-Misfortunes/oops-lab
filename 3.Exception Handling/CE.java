import java.util.Scanner;
import java.io.*;
import java.sql.*;

public class CE {
public static void main(String[] args) {
  Scanner scan= new Scanner(System.in);
  System.out.println("1.ClassNotFound\n2.Interrupted\n3.IOException\n4.InstatiationException\n5.SQLException\n6.FileNotFound\n7.Exit");
  int ch=0;
  do{
    System.out.println("Enter your choice:");
    ch=scan.nextInt();
    switch(ch){
      case 1:try{
                 Class.forName("ClassNotFound Exception");
                }
              catch (ClassNotFoundException e) {
                 e.printStackTrace();
              }
              finally{
                    System.out.println("ClassNotFound Exception Executed");
              }
              break;
    case 2:try {
      for (int i = 0; i < 5; i++) {
          System.out.println(Thread.currentThread().getName());
          Thread.sleep(500);
          Thread.currentThread().interrupt();
      }
      } 
      catch (InterruptedException a) {
      a.printStackTrace();
      }
      finally{
        System.out.println("interrupt Exception Executed");
        } break;
    case 3:try {
      FileReader fileReader = new FileReader("Test.txt");
        System.out.println(fileReader.read());
        fileReader.close();
        }
        catch (IOException b) {
           b.printStackTrace();
          }
        finally{
            System.out.println("IO Exception Executed");
            } break;
    case 4:try {
          Class<Boolean> clazz = boolean.class; 
          clazz.newInstance();
          } 
          catch (InstantiationException c) {
            c.printStackTrace();
          } catch (IllegalAccessException iae) {
            iae.printStackTrace();
              }
              finally{
                System.out.println("InstantiationException Executed");
                } break;
    case 5:
    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/","guest","guest123");
    CallableStatement stmt = conn.prepareCall("{call getEmpName (?, ?)}");
 ) {
    System.out.println("try to eExecuting SQL exception..." );
   
 } catch (SQLException e) {
    e.printStackTrace();
 } 
 finally{
  System.out.println("SQL Exception Executed");
  }break;
    case 6:try { 
            FileReader fileReader = new FileReader("Test.txt");  
            }
            catch (FileNotFoundException d) {
              d.printStackTrace();
            }  
            finally{
              System.out.println("FileNotFoundException Executed");
              }  break;
              
    }
  }while(ch!=7);
  System.out.println("Thank You...");
}
}