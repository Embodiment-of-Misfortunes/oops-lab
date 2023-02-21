//simple inheritance example
class Animal2{
    private String name;
    private int age;
    protected Animal2(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void climb()
    {
        System.out.println("Cat is climbing");
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
     //   return Character.getNumericValue(this.age);
    return this.age;
    }
}
class Cat3 extends Animal2{
    private String breed;
    public Cat3(String name,int age,String breed)
    {
        super(name,age);
        
        this.breed=breed;
    }
    public String getBreed(){
        return this.breed;
    } 
    public void makeNoise(){
        System.out.println("Cat Meows!");
    }
}
class TestInheritance{
    public static void main(String []args)
    {
        Cat3 cat3=new Cat3("Rai",3,"Tiger");
        System.out.println(cat3.getName());
        System.out.println(cat3.getAge());
        System.out.println(cat3.getBreed());
        cat3.climb();
        cat3.makeNoise();
    }
}