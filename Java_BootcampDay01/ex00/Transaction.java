import java.util.UUID;

public class Transaction {

    public enum Category{
        DEBIT, CREDIT
    }
    private UUID TransactionID;
    private User Recipient;
    private User Sender;
    private Category category ;
    private double transferAmount;

    public Transaction (User sender,User recipient,Category transferCategory, double Amount) {
        if ((Amount < 0 && transferCategory == Category.DEBIT)) {
            System.err.println("Wrong transaction");
        } else if (sender.getBalance() < transferAmount && transferCategory == Category.DEBIT ||
                    sender.getBalance() < -transferAmount && transferCategory == Category.CREDIT){
            System.err.println("Insufficient funds for user" + sender.getUserName());
        } else {
            TransactionID = UUID.randomUUID();
            Recipient = recipient;
            Sender = sender;
            category = transferCategory;
            transferAmount = Amount;
            sender.setBalance(sender.getBalance() - Amount);
            recipient.setBalance(recipient.getBalance() + Amount);
        }

    }


    public UUID getTransactionID (){
        return TransactionID;
    }
    public User getRecipient (){
        return Recipient;
    }
    public User getSender (){
        return Sender;
    }
    public Category getCategory (){
        return category;
    }
    public double getTransferAmount (){
        return transferAmount;
    }



}

