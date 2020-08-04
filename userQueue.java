public class userQueue {

    int qSize;
    rank[] user;

    public userQueue() {
        qSize = 0;
        user = new rank[1];
    }

    public boolean isEmpty() {
        return qSize == 0;
    }

    public void increaseSize() {
        int newSize = qSize + 1;
        rank[] newUser = new rank[newSize];
        for (int i = 0; i < qSize; i++) {
            newUser[i] = user[i];
            System.out.println(user[i]);
        }
        user = newUser;
    }

    public void decreaseSize() {
        if (qSize == 1) {
            user = new rank[1];
            return;
        }
        int dSize = qSize - 1;
        rank[] dUser = new rank[dSize];
        for (int i = 0; i < dSize; i++) {
            dUser[i] = user[i];
        }
        user = dUser;
    }

    public void enqueue(rank newUser) {
        user[qSize] = newUser;
        qSize++;
        increaseSize();

    }

    public void deque() {
        decreaseSize();
        qSize--;
    }

    public rank searchUser(String username, String password) {
        if (qSize == 0) {
            return null;
        }
        rank found = null;
        for (int i = 0; i < qSize; i++) {
            if (user[i].getUsername().equals(username)) {
                if (user[i].getPassword().equals(password)) {
                    found = user[i];
                    break;
                } else {
                    System.out.println("\nIncorrect Password\n");
                    return null;
                }
            }
        }
        return found;
    }

    public void viewAll() {
        for (int i = 0; i < user.length - 1; i++) {
            System.out.println(user[i]);
        }
    }
}