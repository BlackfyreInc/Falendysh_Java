package hw;
import java.util.Objects;

public class Music implements Comparable<Music>{
    public int len;
    public String name;
    public String author;
    public String genre;

    public Music(int l, String n, String a){
        this.len=l;
        this.name=n;
        this.author=a;
    }

    public Music(){}

    public boolean equal(Music m){
        return this.len == m.len & Objects.equals(this.name, m.name) & Objects.equals(this.author, m.author);
    }

    @Override
    public int compareTo(Music m){
        return this.genre.compareTo(m.genre);
    }
}
