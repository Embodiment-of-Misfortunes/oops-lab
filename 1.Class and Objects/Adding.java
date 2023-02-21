import java.util.*;
class Add{ 
Add(){
    System.out.println("Addition"); 
}
public float Addition(int a,int b){
    return(a+b);
}
}
public class Adding{
    public static void main(String[]args){
        Add x=new Add();
        Scanner scan=new Scanner (System.in);
        System.out.println("Enter the numbers:");
        int a=scan.nextInt();
        int b=scan.nextInt();
        System.out.println(x.Addition(a,b));
        scan.close();
    }
}
