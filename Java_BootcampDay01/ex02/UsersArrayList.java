public class UsersArrayList implements UsersList {

    private final int defaultSize = 10;
    private User[] users = new User[defaultSize];
    private int size = 0;
    @Override
    public void addUser(User newUser){
        if (size == users.length){
            User[] newUsers = new User[(int)(users.length * 1.5)];
            System.arraycopy(users, 0, newUsers, 0, users.length);
            this.users = newUsers;
            this.users[size++] = newUser;
        }else {
            this.users[size++] = newUser;
        }
    }
    @Override
    public User getUserById(int id) throws UserNotFoundException {
        for (int i = 0; i < this.size; i++) {
            if (users[i].getUserId() == id) {
                return users[i];
            }
        }
        throw new UserNotFoundException("UserNotFoundException");
    }
    @Override
    public User getUserByIndex(int index) throws UserNotFoundException {
        if (index >= 0 && index < this.size) {
            return users[index];
        }
        throw new UserNotFoundException("UserNotFoundException");
    }
    @Override
    public int getCountOfUsers(){
        return this.size;
    }

}
