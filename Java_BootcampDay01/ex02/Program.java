public class Program {

    public static void main(String[] args) throws UserNotFoundException {
        UsersArrayList UsersList = new UsersArrayList();
        User user1 = new User("Anton", 1000);
        User user2 = new User("Roman", 200);

        UsersList.addUser(user1);
        UsersList.addUser(user2);
        System.out.println("after adding...");

        System.out.println("CountOfUsers = " + UsersList.getCountOfUsers());

        System.out.println("id 2 name = " + UsersList.getUserById(2).getUserName());

        System.out.println("check Exception...");

        System.out.println("id 2 name = " + UsersList.getUserById(4).getUserName());





    }

}
