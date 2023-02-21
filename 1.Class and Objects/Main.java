class A{
    public int attr1;
    private int attr2;
    protected int attr3;
    public void method1(){
      System.out.println("method1:" + attr1);
    }
    private void method2(){
    System.out.println("method2:" + attr2);
    }
    public void setAttr2(int a){
      attr2=a;
    }
    public int getAttr2(){
      return attr2;
    }
    protected void method3(){
    System.out.println("method3:" + attr3);
    }
  }
  public class Main{
    public static void main(String[] args){
      A a = new A();
      A b = new A();
      A c = new A();
    a.attr1 = 10;
    a.method1();
    b.setAttr2(20);
    int attr2=b.getAttr2();
    System.out.println("method2:" + attr2);
    c.attr3 = 30;
    c.method3();
  
    }
  
  }