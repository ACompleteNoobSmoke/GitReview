public class animeNode {

    animeNode next;
    FavoriteAnime anime;

    public animeNode(FavoriteAnime anime, animeNode nextNode) {
        this.anime = anime;
        this.next = nextNode;
    }

    public void setAnime(FavoriteAnime anime) {
        this.anime = anime;
    }

    public FavoriteAnime getAnime() {
        return anime;
    }

    public void setNext(animeNode next) {
        this.next = next;
    }

    public FavoriteAnime getNext() {
        return anime;
    }
}