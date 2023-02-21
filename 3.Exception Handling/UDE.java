class UserDefine extends Exception{
    UserDefine(String msg){
        super(msg);
    }
}
public class UDE{
    public static void main(String args[])
    {
        try{
            throw new UserDefine("I am userdefine Exception");
        }
        catch(UserDefine ex)
        {
            System.out.println("exception");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println("Thank you");
    }
}
