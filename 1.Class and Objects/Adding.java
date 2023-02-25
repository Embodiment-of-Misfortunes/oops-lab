import java.util.*;
class Add{ 
Add(){
    System.out.println("Addition"); 
}
public float Addition(float a,float b){
    return(a+b);
}
}
public class Adding{
    public static void main(String[]args){
        Add x=new Add();
        Scanner scan=new Scanner (System.in);
        System.out.println("Enter the numbers:");
        float a=scan.nextFloat();
        float b=scan.nextFloat();
        System.out.println(x.Addition(a,b));
        scan.close();
    }
}
