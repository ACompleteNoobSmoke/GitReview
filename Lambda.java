import java.util.InputMismatchException;
import java.util.Scanner;

public class Lambda {

    static Scanner scan;
    static userQueue userDB;
    static animeLinkedList faves;

    public Lambda() {
        scan = new Scanner(System.in);
        userDB = new userQueue();
        faves = new animeLinkedList();
    }

    // Input Methods//

    public String getString() {
        String newString = "";
        newString = scan.nextLine();
        return newString;
    }

    public int getInt() {
        int newInt = 0;
        try {
            newInt = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
        }
        return newInt;
    }

    // End Of Input Methods//

    // Main Menu Options//

    public int mainMenu() {
        int menuChoice = 0;
        while (menuChoice < 1 || menuChoice > 4) {
            System.out.println("*** Main Menu ***");
            System.out.println("1. New User");
            System.out.println("2. Returning User");
            System.out.println("3. View All Users");
            System.out.println("4. Exit");
            System.out.print("\nAction: ");
            menuChoice = getInt();
        }
        return menuChoice;
    }

    public rank getUser() {
        rank user = null;
        int choice = mainMenu();
        if (choice == 1) {
            user = newUser();
            userDB.enqueue(user);
        } else if (choice == 2) {
            user = returnUser();
        } else if (choice == 3) {
            userDB.viewAll();
        } else if (choice == 4) {
            System.out.println("\nClosing Program...");
            scan.close();
            System.exit(0);
        }
        System.out.println("\n");
        return user;
    }

    // New User Registration//
    public rank newUser() {
        String name = "";
        String username = "";
        String password = "";
        int age = 0;
        FavoriteAnime[] animeList = new FavoriteAnime[1];
        System.out.println("*** Profile Information ***");
        while (name.isBlank()) {
            System.out.print("Enter Name: ");
            name = getString();
        }
        while (username.isBlank()) {
            System.out.print("Enter Username: ");
            username = getString();
        }
        while (password.isBlank()) {
            System.out.print("Enter Password: ");
            password = getString();
        }
        while (age == 0) {
            System.out.print("Enter Age: ");
            age = getInt();
        }
        return new rank(name, username, password, age, animeList);
    }

    // Returning User Login
    public rank returnUser() {
        String username = "";
        String password = "";
        rank returningUser = null;
        System.out.println("*** Login ***");
        while (username.isBlank()) {
            System.out.print("Enter Username: ");
            username = getString();
        }
        while (password.isBlank()) {
            System.out.print("Enter Password: ");
            password = getString();
        }

        returningUser = userDB.searchUser(username, password);
        arraytoList(returningUser);
        return returningUser;
    }

    // Convert Array To Linked List
    public void arraytoList(rank user) {
        if (user.getAnimeList().length <= 1) {
            return;
        }

        int length = user.getAnimeList().length;
        FavoriteAnime[] animes = user.getAnimeList();
        for (int i = 0; i < length; i++) {
            faves.insertTail(animes[i]);
        }
    }

    // Convert Linked List To Array
    public void listToArray(rank user) {
        if (faves.size == 0) {
            return;
        }
        FavoriteAnime[] animes = faves.listToArray();
        user.setAnimeList(animes);
    }

    // User Menu Options//
    public int userMenu(rank user) {
        if (user == null) {
            return 0;
        }

        listToArray(user);
        int userPick = 0;
        while (userPick < 1 || userPick > 4) {
            System.out.println("*** User Menu ***");
            System.out.println("Hello " + user.getUsername() + "\n");
            System.out.println("1. Enter Anime");
            System.out.println("2. Delete Options");
            System.out.println("3. View Options");
            System.out.println("4. Log Out");
            System.out.print("\nAction: ");
            userPick = getInt();
        }
        System.out.println("");
        return userPick;
    }

    // User Actions
    public rank userAction(rank user) {
        int choice = userMenu(user);
        switch (choice) {
            case 1:
                enterAnime();
                break;
            case 2:
                deleteActions(user);
                break;
            case 3:
                viewAction(user);
                break;
            case 4:
                faves = new animeLinkedList();
                System.out.println("\nLogging Off...");
                return null;
        }
        return user;
    }

    // Input Anime To Database
    public void enterAnime() {
        function myFunction = (title, genre) -> {
            System.out.println(title + " Has Been Entered!");
            return new FavoriteAnime(title, genre);
        };

        String title = "";
        String genre = "";
        System.out.println("*** New Anime ***");
        while (title.isBlank()) {
            System.out.print("Enter Anime Title: ");
            title = getString();
        }
        while (genre.isBlank()) {
            System.out.print("Enter Anime Genre: ");
            genre = getString();
        }

        FavoriteAnime newAnime = myFunction.animeInfo(title, genre);
        faves.insertTail(newAnime);
    }

    // View Menu Options
    public int viewMenu(rank user) {
        int viewChoice = 0;
        while (viewChoice < 1 || viewChoice > 3) {
            System.out.println("*** View Option ***\n");
            System.out.println("1. View Profile");
            System.out.println("2. View Anime List");
            System.out.println("3. Back");
            System.out.print("\nAction: ");
            viewChoice = getInt();
        }
        return viewChoice;
    }

    // View Actions Depending On User Choice
    public void viewAction(rank user) {
        int viewPick = viewMenu(user);
        if (viewPick == 1) {
            viewProfile(user);
        } else if (viewPick == 2) {
            viewList(user);
        }
    }

    // View Full Profile (Profile & Anime List)
    public void viewProfile(rank user) {
        System.out.println("*** Profile Information ***");
        user.displayFullInfo();
    }

    // View Anime List Only
    public void viewList(rank user) {
        faves.viewAll();
    }

    // Delete menu options
    public int deleteMenu() {
        int deletePick = 0;
        while (deletePick < 1 || deletePick > 3) {
            System.out.println("*** Delete Options ***");
            System.out.println("1. Remove Top Anime");
            System.out.println("2. Remove Recently Added");
            System.out.println("3. Back");
            System.out.print("\nAction: ");
            deletePick = getInt();
        }
        System.out.println("");
        return deletePick;
    }

    public void deleteActions(rank user) {
        int deleteChoice = deleteMenu();
        if (deleteChoice == 3) {
            return;
        }
        FavoriteAnime removed = null;
        if (deleteChoice == 1) {
            removed = removedTop(user);
        } else if (deleteChoice == 2) {
            removed = removedBottom(user);
        }
        if (removed == null) {
            System.out.println("The Delete Action Could Not Be Completed");
            return;
        }

        System.out.println(removed.getAnimeTitle() + " Has Been Removed From The Database");
    }

    public FavoriteAnime removedTop(rank user) {
        FavoriteAnime topRemoved = faves.removeHead();
        if (topRemoved != null) {
            listToArray(user);
            arraytoList(user);
        }
        return topRemoved;
    }

    public FavoriteAnime removedBottom(rank user) {
        FavoriteAnime bottomRemoved = faves.removeTail();
        if (bottomRemoved != null) {
            listToArray(user);
            arraytoList(user);
        }
        return bottomRemoved;
    }

    public static void main(String[] args) {
        Lambda newProgram = new Lambda();
        rank user = null;
        while (true) {
            user = newProgram.getUser();
            while (user != null) {
                user = newProgram.userAction(user);
            }
        }
    }
}