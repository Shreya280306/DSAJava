public class SLL_Node {
        int data;
        SLL_Node next;
        SLL_Node previous;

        SLL_Node(){
            this.data = 0;
            this.next = null;
        }

        SLL_Node(int dataGiven){
            this.data = dataGiven;
            this.next = null;
        }

        void printNode(){
            System.out.println(this.data);
        }
    }




