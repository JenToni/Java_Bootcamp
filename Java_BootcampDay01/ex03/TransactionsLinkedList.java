import java.util.UUID;
public class TransactionsLinkedList implements TransactionsList{

    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private Transaction transaction;
        private Node next;
        private Node prev;


        public Node (Transaction transaction){
            this.transaction = transaction;
            this.next = null;
            this.prev = null;
        }
    }
    public TransactionsLinkedList() {}
    @Override
    public void addTransaction(Transaction transaction){
        Node add = new Node(transaction);
        if (tail == null){
            tail = add;
        }
        else{
            head.next = add;
        }
            add.prev = head;
        head = add;
        size++;
    }
    @Override
    public void removeTransactionById(UUID id) throws TransactionNotFoundException {
        boolean isFound = false;
        for (Node rNode = tail ; rNode != null; rNode = rNode.next){
            if (rNode.transaction.getTransactionID() == id){
                isFound = true;
                if (rNode.next == null){
                    head = rNode.prev;
                    rNode.next = null;
                }else if (rNode.prev == null){
                    tail = rNode.next;
                    rNode.prev = null;
                }
                else {
                    rNode.next.prev = rNode.prev;
                    rNode.prev.next = rNode.next;
                }
               size--;
            }
        }
        if (!isFound){
            throw new TransactionNotFoundException("Transaction with UUID " + id + " not found");
        }
    }
    @Override
    public Transaction[] toArray(){
        if (size > 0) {
        Transaction[] transactions = new Transaction[size];
        Node current = tail;
        int i = 0;
        while (current != null) {
            transactions[i] = current.transaction;
            current = current.next;
            i++;
        }
        return transactions;
    }
        else {
        return null;
        }
    }
    public int getSize(){
        return size;
    }

}
