//Multiple inheritance example
interface Animal6
{
    String name="Rai";
    int age=3;
  
    void getAge();
    void getName();
}
interface Dog6{
String breed="Bulldog";

void getBreed();
}

class Pup implements Animal6,Dog6{
    private String favoriteToy="Ball";
 
    public void getAge()
    {
         //this.age=3;
         System.out.println(age);
    }
    public void getName()
    {
        //this.name="Rai";
        System.out.println(name);
    }
    public void getBreed()
    {
        //this.breed="Bulldog";
        System.out.println(breed);
    }
    public void getFavoriteToy(){
        //this.favoriteToy="Ball";
        System.out.println(favoriteToy);
      }

    
}

public class Dog7{
public static void main(String []args)
{
    Pup d=new Pup();
    d.getName();
    d.getAge();
    d.getBreed();
    d.getFavoriteToy();
}
}