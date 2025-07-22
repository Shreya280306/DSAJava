public class SLL_Node{
    int data;
    SLL_Node next;
    SLL_Node random;

    SLL_Node(){
        this.data = 0;
        this.next = null;
        this.random = null;
    }

    SLL_Node(int dataGiven){
        this.data = dataGiven;
        this.next = null;
        this.random = null;
    }

    void printNode(){
        System.out.println(this.data);
    }
}