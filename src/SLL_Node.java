public class SLL_Node{
    int data;
    SLL_Node next;
    SLL_Node random;
    int start;
    int end;
    BtNode bstnode;
    int min;
    int max;

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

    SLL_Node(BtNode bstnode){
        this.bstnode = bstnode;
        this.next = null;
    }

    SLL_Node(BtNode bstnode, int min, int max){
        this.bstnode = bstnode;
        this.next = null;
        this.min = min;
        this.max = max;
    }

    void printNode(){
        System.out.println(this.data);
    }
}