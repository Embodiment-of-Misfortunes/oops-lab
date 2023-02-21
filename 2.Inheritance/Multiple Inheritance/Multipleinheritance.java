interface A2Interface {
    int attr1 = 1;
    int attr2 = 2;
    int attr3 = 3;
    
    void method1();
    void method2();
    void method3();
}

interface B2Interface {
    int attr4 = 4;
    int attr5 = 5;
    int attr6 = 6;
    
    void method4();
    void method5();
    void method6();
}

class C2 implements A2Interface, B2Interface {
    public int attr7 = 7;
    protected int attr8 = 8;
    private int attr9 = 9;
    
    public void method7() {
        System.out.println("This is method7 of Class C and" + attr7);
    }
    protected void method8() {
        System.out.println("This is method8 of Class C and" + attr8);
    }
    void method9() {
        System.out.println("This is method9 of Class C and" + attr9);
    }
    
    public void method1() {
        System.out.println("This is method1 of Class A and" + attr1);
    }
    public void method2() {
        System.out.println("This is method2 of Class A and" + attr2);
    }
    public void method3() {
        System.out.println("This is method3 of Class A and" + attr3);
    }
    public void method4() {
        System.out.println("This is method4 of Class B and" + attr4);
    }
    public void method5() {
        System.out.println("This is method5 of Class B and" + attr5);
    }
    public void method6() {
        System.out.println("This is method6 of Class B and" + attr6);
    }
}

public class MultipleInheritance {
    public static void main(String []args){
        C2 obj1 = new C2();
        obj1.method1();
        obj1.method2();
        obj1.method3();
        obj1.method4();
        obj1.method5();
        obj1.method6();
        obj1.method7();
        obj1.method8();
        obj1.method9();
    }
}
