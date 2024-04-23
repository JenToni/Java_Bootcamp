public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private static Integer userIds = 0;

    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        if(instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        return ++userIds;
    }

}