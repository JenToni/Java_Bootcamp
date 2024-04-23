public class Program {

    public static void main(String[] args){

        User user1 = new User("Anton", 1000);
        User user2 = new User("Roman", 200);
        System.out.println("UserId = " + user1.getUserId() + " Balance = " + user1.getBalance() + "Name = " + user1.getUserName());
        System.out.println("UserId = " + user2.getUserId() + " Balance = " + user2.getBalance() + "Name = " + user2.getUserName());
        Transaction newTransaction = new Transaction(user1,user2, Transaction.Category.DEBIT,500);
        System.out.println("after transaction...");
        System.out.println("UserId = " + user1.getUserId() + " Balance = " + user1.getBalance() + "Name = " + user1.getUserName());
        System.out.println("UserId = " + user2.getUserId() + " Balance = " + user2.getBalance() + "Name = " + user2.getUserName());


    }

}
