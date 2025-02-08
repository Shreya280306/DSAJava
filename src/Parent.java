public class Parent {
    int data;
    Parent(int data) {
        this.data = data;
    }
    public void fun1 () {
        System.out.println("Fun1 of Parent class");
        System.out.println("Data: "  +  this.data);
    }

    public void fun2 () {
        System.out.println("Fun2 of Parent class");

    }

}
