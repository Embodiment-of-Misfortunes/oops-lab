import java.util.*;

public class UCE {
  public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);
  System.out.println("1.Arithmatic \n2.ClassCast\n3.NullPointer\n4.ArrayIndexOutOfBounds\n5.ArrayStore Exception\n6.IllegalThreadState Exception\n7.Exit");
  int ch=0;
  do{
    System.out.println("Enter your choice:");
    ch=scan.nextInt();
    switch(ch){
      case 1:int a = 0, b = 10 ;
              int c = 0;
              try {
                  c = b/a;
                } 
              catch (ArithmeticException e) {
                 e.printStackTrace();
                 System.out.println("ArithmeticException is executed");
                }
              finally{
                   System.out.println("Value of c :"+a+"/"+b);
                 }
                break; 
      case 2: try{
              parent p= new parent();
              child s =(child)p;
              p=s; }
              catch(ClassCastException e){
                e.printStackTrace();
              } 
              finally{
                System.out.println("ClassCastException is executed...");
              }
             break; 
      case 3:String ptr = null;
            try
           {
         
               if (ptr.equals("gfg"))
               System.out.print("Same");
          
           }
          catch(NullPointerException e)
          {
            e.printStackTrace();
          } 
          finally{
            System.out.println("NullPointer Exception is executed...");
          }
         break; 
     case 4: int ar[] = { 1, 2, 3, 4, 5 };
          try {
               for (int i = 0; i <= ar.length; i++)
                 System.out.print(ar[i]+" ");
               }
          catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            } 
            finally{
              System.out.println("ArrayIndexOutOfBound Exception is executed...");
            }
           break; 
      case 5:
      try{
              Number[] array = new Double[2]; 
              array[0]=4; 
      }
      catch(ArrayStoreException e){
        e.printStackTrace();
      }
     
    finally{
      System.out.println("ArrayStore Exception is executed...");
    }
   break;
      case 6:  ArrayList<String> list = new ArrayList<String>();
      list.add("a");
      list.add("b");
      list.add("c");
      try{
      Iterator<String> it = list.iterator();
      it.remove();
      }
      catch(IllegalStateException e){
        e.printStackTrace();
      }
     
    finally{
      System.out.println("IllegalState Exception is executed...");
    }
   break;            
  }        
    
  }while(ch!=7);
  System.out.println("Thank You...");
  
}
}
class parent{

}
class child extends parent{

}
