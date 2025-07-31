public class SLL_Node{
    int data;
    SLL_Node next;
    SLL_Node random;
    int start;
    int end;

    SLL_Node(){
        this.data = 0;
        this.next = null;
        this.random = null;
        this.start = 0;
        this.end = 0;
    }

    SLL_Node(int dataGiven){
        this.data = dataGiven;
        this.next = null;
        this.random = null;
        this.start = 0;
        this.end = 0;
    }

    void printNode(){
        System.out.println(this.data);
    }
}