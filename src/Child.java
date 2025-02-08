public class Child extends Parent{
    Child(int data) {
        super(data);
    }

    @Override
    public void fun1() {
//        super.fun1();
        System.out.println("This is from Child class");
    }
    @Override
    public String toString() {
        return "toString Fun overridden";
    }

}
