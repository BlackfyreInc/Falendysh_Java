package hw;

public class hw {
    public static void main(String[] args) {
        Music[] comps = {new Genres.Rock(2,"a","b"), new Genres.Pop(3,"s","q"), new Genres.Rock(4,"w","p")};
        Playlist playlist = new Playlist(comps);
        playlist.sort();
        System.out.println(playlist);
        System.out.println();
        System.out.println(playlist.getbylen(3,5));
    }
}
