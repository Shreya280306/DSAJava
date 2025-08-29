class QueueForLevelOrderBSTNode {
    BtNode btnode;
    int min;
    int max;
    QueueForLevelOrderBSTNode next;

    public QueueForLevelOrderBSTNode(BtNode btnode, int min, int max) {
        this.btnode = btnode;
        this.min = min;
        this.max = max;
        this.next = next;
    }
}

public class QueueForLevelOrderBST {

    QueueForLevelOrderBSTNode head, tail = null;
    QueueForLevelOrderBSTNode node = null;
    QueueForLevelOrderBSTNode next = null;

    public QueueForLevelOrderBST(){
        this.head = null;
        this.tail = null;
        this.next = null;
    }
    public QueueForLevelOrderBST(QueueForLevelOrderBSTNode node){
        this.node = node;
        this.head = node;
        this.tail = node;
        this.next = null;
    }

    public void enqueue(QueueForLevelOrderBSTNode node){
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }
        else{
            tail.next = node;
            this.tail = node;
        }
    }

    public QueueForLevelOrderBSTNode dequeue(){
        if(this.head == null){
            return null;
        }
        QueueForLevelOrderBSTNode temp = head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        temp.next = null;
        return temp;
    }

    public boolean isEmptyQueue(){
        if(this.head == null && this.tail == null){
            return true;
        }
        else{
            return false;
        }
    }

}

