
class LinkListNode{
    int data;
    LinkListNode next;
    LinkListNode previous;

    LinkListNode(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    void printCurrentNodeData() {
        System.out.println("Node data is: " + this.data);
    }

    void printNodeData(LinkListNode node) {
        System.out.println("Given node  data value is: " + node.data);
        System.out.println("This node data value is: " + this.data);
    }

    void isCurrentNodeNull() {
        if (this == null) {
            System.out.println("This node is null");
        }
        else  {
            System.out.println("This node is not null");
        }
    }

    void isGivenNodeNull (LinkListNode node) {
        if (node == null) {
            System.out.println("This node is null");
        }
        else  {
            System.out.println("This node is not null");
        }
    }
}

public  class LinkList{
    LinkListNode head;
    LinkListNode tail;

    LinkList(LinkListNode node){
        this.head = node;
        this.tail = node;
    }

    void printLinkListForward(){
        LinkListNode current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    void printLinkListBackward(){
        LinkListNode current = tail;
        while (current != null){
            System.out.println(current.data);
            current = current.previous;
        }
    }

    void addElementInTheEnd(LinkListNode node){
        this.tail.next = node;
        node.previous = tail;
        node.next = null;
        tail = node;
    }

    void addElementInTheStart(LinkListNode node){
        node.next = this.head;
        node.previous = null;
        head.previous = node;
        this.head = node;
    }

    void removeElementFromTheStart(){
        if(head == null){
            return;
        }
        if (head.next == null){
            head = null;
            tail = null;
            return;
        }
        LinkListNode current = this.head;
        this.head = head.next;
        current.next = null;
        head.previous = null;
    }

    void removeElementFromEnd(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            tail = null;
            return;
        }
        LinkListNode current = tail.previous;
        tail.previous = null;
        current.next = null;

    }
}

