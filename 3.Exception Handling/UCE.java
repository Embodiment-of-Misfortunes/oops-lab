public class UCE{
    public static void main(String[]args)
    {
        scanner scan=new scanner(System.in);
        System.out.println("1.Arithmetic\n2.Class cast\n3.Null point\n4.Array IndexoutBounds\n5.ArrayStore\n6.Illegal ThreadState\n7.Exit");
    int ch=0;
    do{
       System.out.println("Enter your choice");
       ch=scan.nextInt();
       switch(ch){
        case 1:int a=0,b=10,c=0;
        try{
            c=b/a;
        }
        catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("Arithmetic Exception is executed");
        }break;
        case 2:try{
            parent P=new print();
            child  S=(child)P;
            P=S;
        }
            catch(ClassCastException e){
                e.printStackTrace();
                System.out.println("Class Cast Exception");
                }break;
case 3:String ptr=new;
       try{
        if(ptr.equals("abc")){
            System.out.println("Same");
        }
        catch(NullpointerException e)
        {
            e.printStackTrace();
            System.out.println("Null pointer exception");
        }break;
case 4:int ar[]={1,2,3,4,5};
try{
    for(int i=0;i<=ar.length;i++)
    System.out.print(ar[i]+"");
}
catch(IndexoutBoundsException e){
    e.printStackTrace();
    System.out.println("ArrayIndexOut od Bound Exception");
}break;
case 5:try{
    Number[]array=newDouble[2];
    array[0]=4;
}
catch(ArrayStoreException e){
    e.printStackTrace();
}
finally{
    System.out.println("Array Store Exception");
}
break;
case 6:
ArrayList<String>list=new ArrayList<String>();
list.add("a");
list.add("b");
list.add("c");
try{
    Iterator<String>it=listiterator();
    it.remove();
}
catch(IllegalStateException e){
    e.printStackTrace();
    System.out.println("Illegal State Exception");
}break;
       }
        }while(ch!=7);
        System.out.println("Thank you...");
    }}}
class parent{}
class child extends parent{}