public class DLL {
        DLL_Node head;
        DLL_Node tail;

        DLL(){
            this.head = null;
            this.tail = null;
        }

        DLL(DLL_Node node){
            this.head = node;
            this.tail = node;
        }

        public void printList(){
            DLL_Node current = head;
            while(current != null){
                System.out.println(current.data);
                current = current.next;
            }
        }

    public void addNodeInStart(DLL_Node node){
        node.next = this.head;
        head.previous = node;
        this.head = node;
    }

    public void addNodeInEnd(DLL_Node node){
            tail.next = node;
            node.previous = tail;
            this.tail = node;
    }

    public void removeNodeFromStart(){
            DLL_Node temp = head;
            head = head.next;
            temp = null;
            head.previous = null;
    }

    public void addNodeInMiddle(DLL_Node node, int num){
            DLL_Node current = head;
            while(current.data != num){
                current = current.next;
            }
            node.next = current.next;
            current.next.previous = node;
            current.next = node;
            node.previous = current;
    }
}
