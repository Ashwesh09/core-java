package designPatterns;

interface MyWrapper{
    void printType();
}
class MyInteger implements MyWrapper{
    
    public MyInteger() {
    }

    @Override
    public void printType(){
        System.out.println("Integer");
    }
}

class MyDouble implements MyWrapper{
    @Override
    public void printType(){
        System.out.println("Double");
    }
}
class MyCharacter implements MyWrapper{
    @Override
    public void printType(){
        System.out.println("Character");
    }
}
class MyBoolean implements MyWrapper{
    @Override
    public void printType(){
        System.out.println("Boolean");
    }
}

class MyWrapperFactory{
    MyWrapper createMyWrapper(String input){
        if(input == null || input.isEmpty())
            return null;
        else if(input.matches("\\d+"))
            return new MyInteger();
        else if(input.matches("([0-9]*)\\.([0-9]*)"))
            return new MyDouble();
        else if(input.length() == 1)
            return new MyCharacter();
        else if(input.equals("true") || input.equals("false"))
            return new MyBoolean();
        else
            throw new IllegalArgumentException("Invalid input : " + input);
        }
    }


    
public class FactoryMethodsDemo {
    public static void main(String[] args) {
        MyWrapperFactory myWrapperFactory = new MyWrapperFactory();
        MyWrapper myWrapper = myWrapperFactory.createMyWrapper("9.6");
        myWrapper.printType();
    }
}
