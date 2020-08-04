public class FavoriteAnime {

    private String animeTitle;
    private String animeGenre;

    public FavoriteAnime(String aTitle, String aGenre) {
        this.animeTitle = aTitle;
        this.animeGenre = aGenre;
    }

    public void setAnimeTitle(String title) {
        this.animeTitle = title;
    }

    public String getAnimeTitle() {
        return animeTitle;
    }

    public void setAnimeGenre(String genre) {
        this.animeGenre = genre;
    }

    public String getAnimeGenre() {
        return animeGenre;
    }

    public String toString() {
        return "Title: " + animeTitle + "\n" + "Genre: " + animeGenre + "\n";
    }

}