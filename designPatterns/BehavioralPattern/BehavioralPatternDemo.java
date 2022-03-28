package designPatterns.BehavioralPattern;

class MyNumber{
    private String value;

    public MyNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyNumber [value=" + value + "]";
    }
    
}


abstract class MyparseInt
{
    private MyparseInt nextHandler;
 
    MyparseInt(MyparseInt nextHandler){
        this.nextHandler = nextHandler;
    }
     
    public void handle(MyNumber request){
        if(nextHandler != null)
            nextHandler.handle(request);
    }
}

class NegativeNumberHandler extends MyparseInt{

    private boolean isNeagtive(String input){
        return input.matches("-[1-9][0-9]*");
    }
    NegativeNumberHandler(MyparseInt nextHandler) {
        super(nextHandler);
    }
     @Override
    public void handle(MyNumber request) {
        if(isNeagtive(request.getValue()))
            System.out.println(request.getValue() + " is Negative.");
        else
            super.handle(request);
    }

}

class ZeroNumberHandler extends MyparseInt{
    private boolean isZero(String input) {
        return input.equals("0");
    }
    ZeroNumberHandler(MyparseInt nextHandler) {
        super(nextHandler);
    }
     @Override
    public void handle(MyNumber request) {
        if(isZero(request.getValue()))
            System.out.println(request.getValue()+ " is Zero.");
        else
            super.handle(request);
    }
}
class PositiveNumberHandler extends MyparseInt{
    private boolean isPositive(String input){
        return input.matches("\\d+");
    }
    PositiveNumberHandler(MyparseInt nextHandler) {
        super(nextHandler);
    }
     @Override
    public void handle(MyNumber request) {
        if(isPositive(request.getValue()))
            System.out.println(request.getValue()+ " is Positive");
    }
}
class NotAnIntegerHandler extends MyparseInt{
    NotAnIntegerHandler(MyparseInt nextHandler) {
        super(nextHandler);
    }
    @Override
    public void handle(MyNumber request) {
        if(!request.getValue().matches("\\d+"))
            System.out.println(request.getValue()+ " is not a integer");
        else
            super.handle(request);
    }
}

class Chain{
    MyparseInt fristHandler;
 
    public Chain(){
        buildChain();
    }
 
    private void buildChain(){
            this.fristHandler = new NotAnIntegerHandler(
                                    new NegativeNumberHandler(
                                        new ZeroNumberHandler(
                                            new PositiveNumberHandler(null))));
    }
    public void verify(MyNumber request) {
        fristHandler.handle(request);
    }
}

public class BehavioralPatternDemo {
    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.verify(new MyNumber("1"));
        chain.verify(new MyNumber("-1"));
        chain.verify(new MyNumber("0"));
        chain.verify(new MyNumber("abc"));
    }
}
