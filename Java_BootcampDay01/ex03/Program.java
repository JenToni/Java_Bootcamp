import java.util.UUID;

public class Program {
    public static void main(String[] args) throws TransactionNotFoundException {
        User user1 = new User("Anton", 10000);
        User user2 = new User("Roman", 8000);
        TransactionsLinkedList transactions = user1.getTransactionsList();

        Transaction trans = new Transaction(user1, user2,  Transaction.Category.DEBIT,5000);
        transactions.addTransaction(trans);
        Transaction trans1 = new Transaction(user1, user2,  Transaction.Category.DEBIT,2000);
        transactions.addTransaction(trans1);
        Transaction trans2 = new Transaction(user1, user2,  Transaction.Category.DEBIT,500);
        transactions.addTransaction(trans2);
        for(Transaction i : transactions.toArray()) {
            System.out.println(i);
        }

        System.out.println(user1 + " have " + transactions.getSize() + " transactions");
        transactions.removeTransactionById(trans1.getTransactionID());
        System.out.println(user1 + " have " + transactions.getSize() + " transactions");
        transactions.removeTransactionById(trans2.getTransactionID());
        System.out.println(user1 + " have " + transactions.getSize() + " transactions");
        transactions.removeTransactionById(trans.getTransactionID());
        System.out.println(user1 + " have " + transactions.getSize() + " transactions");

        System.out.println("and Exception...");
        transactions.removeTransactionById(trans.getTransactionID());


    }
}