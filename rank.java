public class rank {

    private String name;
    private String username;
    private String password;
    private int age;
    private FavoriteAnime anime[];

    public rank(String name, String username, String password, int age, FavoriteAnime anime[]) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.anime = anime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAnimeList(FavoriteAnime[] faveList) {
        this.anime = faveList;
    }

    public FavoriteAnime[] getAnimeList() {
        return anime;
    }

    public String toString() {
        return "\n" + "Name: " + name + "\n" + "Age: " + age + "\n\n";
    }

    public void viewAnimeList() {
        if (anime.length < 1) {
            System.out.println("Anime List Currently Empty");
            return;
        }
        System.out.println("*** Favorite Anime ***");
        for (int i = 0; i < anime.length; i++) {
            System.out.println(anime[i]);
        }
    }

    public void displayFullInfo() {
        System.out.println(toString());
        viewAnimeList();
    }

}