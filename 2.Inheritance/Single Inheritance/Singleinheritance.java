
class A2{
    public int attr1=1;
    protected int attr2=2;
    private int attr3=3;
   
    public void method1()
    {
        System.out.println("This is method1 of Class A and"+attr1);
    }
    protected void method2()
    {
        System.out.println("This is method2 of Class A and"+attr2);
    }
    void method3()
    {      
        System.out.println("This is method3 of Class A and"+attr3);
    }
    
    
}
class B2 extends A2{
    public int attr4=4;
    protected int attr5=5;
    private int attr6=6;
    
    public void method4()
    {
        System.out.println("This is method4 of Class B and"+attr4);
    }
    protected void method5()
    {
        System.out.println("This is method5 of Class B and"+attr5);
    }
     void method6()
    {
        System.out.println("This is method6 of Class B and"+attr6);
    }
   
}

public class Singleinheritance{
    public static void main(String []args){
        B2 obj1=new B2();
        obj1.method1();
        obj1.method2();
       
        obj1.method3();
       
        obj1.method4();
        obj1.method5();
        
        obj1.method6();
    }
}
