//Multilevel inheritance example
class Animal {
    private String name;
    private int age;
  
    protected Animal(String name, int age) {
      this.name = name;
      this.age = age;
    }
  
    public void climb() {
      System.out.println("Animal is climbing");
    }
  
    public String getName() {
      return this.name;
    }
  
    public int getAge() {
      return this.age;
    }
  }
  
  class Cat extends Animal {
    private String breed;
  
    public Cat(String name, int age, String breed) {
      super(name, age);
      this.breed = breed;
    }
    protected String getBreed(){
      return this.breed;
    }
  
    public void makeNoise() {
      System.out.println("Cat meows!");
    }
  }
  
  class BabyCat extends Cat {
    private String favoriteToy;
  
    public BabyCat(String name, int age, String breed, String favoriteToy) {
      super(name, age, breed);
      this.favoriteToy = favoriteToy;
    }
    public String getFavoriteToy(){
      return this.favoriteToy;
    }
    public void writhe() {
      System.out.println("Baby cat is writhing");
    }
  }
  
  class TestInher {
    public static void main(String[] args) {
      BabyCat cat = new BabyCat("Fluffy", 1, "Persian", "Ball");
      System.out.println(cat.getName());
      System.out.println(cat.getAge());
      System.out.println(cat.getFavoriteToy());
      System.out.println(cat.getBreed());
      cat.climb();
      cat.makeNoise();
      cat.writhe();
    }
  }
  