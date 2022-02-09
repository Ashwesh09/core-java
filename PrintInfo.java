public class PrintInfo {
    void PrintInfo(String Name, String City, String Hobby){
        System.out.println("Name:"+Name+"\nCity:"+City+"\nHobby:"+Hobby);
    }
    public static void main(String[] args) {
        PrintInfo info = new PrintInfo();
        String name = "Ashwesh";
        String city = "Nagpur";
        String hobby = "Guitar";
        info.PrintInfo(name, city, hobby);
    }
}
