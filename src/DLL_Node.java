public class DLL_Node {
    int data;
    DLL_Node next;
    DLL_Node previous;

    DLL_Node(){
        this.data = 0;
        this.next = null;
        this.previous = null;
    }

    DLL_Node(int dataGiven){
        this.data = dataGiven;
        this.next = null;
        this.previous = null;
    }

    void printNode(){
        System.out.println(this.data);
    }
}
