public class User {
    private int userID;
    private String name;
    private double balance;

    private TransactionsLinkedList transactions;
    public User( String name, double balance) {
        this.userID = UserIdsGenerator.getInstance().generateId();
        this.balance = balance < 0 ? 0 : balance;
        this.name = name;
        transactions = new TransactionsLinkedList();
    }
    public TransactionsLinkedList getTransactionsList(){
        return transactions;
    }
    public int getUserId () {
        return userID;
    }

    public String getUserName (){
        return name;
    }

    public double getBalance (){
        return balance;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setBalance (double balance ){
        this.balance = balance;
    }


}

