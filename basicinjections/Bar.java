package basicinjections;

public class Bar {
    private String name;
    private int age;
    private Foo foo;
    public Bar() {
    }
    public void setFoo(Foo foo) {
        this.foo = foo;
    }
    public void processFooName(){
        System.out.println("Name in injection Foo is : " + foo.getName());
    }
    @Override
    public String toString() {
        return "Bar has name = " + name + " and age = " + age;
    }
    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.setFoo(new Foo("Foo Foo"));
        bar.processFooName();
        System.out.println(bar);
    }
}
