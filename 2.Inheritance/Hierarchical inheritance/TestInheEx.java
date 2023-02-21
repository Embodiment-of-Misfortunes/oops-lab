//Hierarchical inheritance example
class Animal3{
    private String name;
    private int age;
    protected Animal3(String name,int age){
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
    public void play(){
        System.out.println("Dog is playing");
    }
    public int getAge(){
     //   return Character.getNumericValue(this.age);
    return this.age;
    }
}
class Cat4 extends Animal3{
    private String breed;
    public Cat4(String name,int age,String breed)
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
class Dog4 extends Animal3{
    private String breed;
    public Dog4(String name,int age,String breed)
    {
        super(name,age);
        
        this.breed=breed;
    }
    public String getBreed(){
        return this.breed;
    }
    public void makeNoise(){
        System.out.println("Dog Barks???");
    }
}

class TestInheEx{
    public static void main(String []args)
    {
        Cat4 cat=new Cat4("Rai",3,"Tiger");
        Dog4 dog=new Dog4("Loki",6,"Bulldog");
        System.out.println(cat.getName());
        System.out.println(cat.getAge());
        System.out.println(cat.getBreed());
        cat.climb();
        cat.makeNoise();
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
        System.out.println(dog.getBreed());
        dog.play();
        dog.makeNoise();
    }
}