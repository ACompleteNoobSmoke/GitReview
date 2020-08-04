public class animeLinkedList {

    int size;
    animeNode Head;

    public animeLinkedList() {
        size = 0;
        Head = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertHead(FavoriteAnime anime) {
        animeNode newNode = new animeNode(anime, Head);
        Head = newNode;
        size++;
        return;
    }

    public void insertTail(FavoriteAnime anime) {
        if (isEmpty()) {
            insertHead(anime);
            return;
        } else {
            animeNode newNode = new animeNode(anime, null);
            animeNode current = Head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    public FavoriteAnime removeHead() {
        if (isEmpty()) {
            return null;
        }

        FavoriteAnime removedHead;
        removedHead = Head.getAnime();
        Head = Head.next;
        size--;
        return removedHead;
    }

    public FavoriteAnime removeTail() {
        if (isEmpty()) {
            return null;
        }

        FavoriteAnime removedTail = null;
        animeNode current = Head;
        for (int i = 0; i < size - 1; i++) {
            current = current.next;
        }
        removedTail = current.anime;
        current = null;
        size--;
        return removedTail;
    }

    public FavoriteAnime[] listToArray() {
        if (isEmpty()) {
            return null;
        }
        FavoriteAnime[] list = new FavoriteAnime[size];
        animeNode current = Head;
        for (int i = 0; i < size; i++) {
            list[i] = current.getAnime();
            current = current.next;
        }
        return list;
    }

    public void viewAll() {
        if (isEmpty()) {
            System.out.println("\nList Is Empty\n");
            return;
        }

        animeNode current = Head;
        while (current.next != null) {
            System.out.println(current.getAnime());
            current = current.next;
        }
        System.out.println(current.getAnime());
    }

}