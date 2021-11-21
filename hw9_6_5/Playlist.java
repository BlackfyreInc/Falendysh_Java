package hw;
import java.util.Arrays;

public class Playlist {
    public Music[] comps;

    Playlist(Music[] comps){
        this.comps=comps;
    }

    Playlist(){}

    void add_comp(Music m){
        int l = this.comps.length;
        Music[] t = Arrays.copyOf(this.comps,l);
        this.comps = new Music[l+1];
        System.arraycopy(t,0,comps,0,l);
        comps[l]=m;
    }

    void sort(){
        Arrays.sort(this.comps);
    }

    int leng(){
        int l=0;
        for (Music m: comps){
            l+=m.len;
        }
        return l;
    }

    Music getbylen(int l1, int l2){
        for (Music m: this.comps){
            if (m.len >= l1 && m.len <= l2) {return m;}
        }
        return new Music();
    }

    @Override
    public String toString(){
        String str = "";
        for (Music m:comps){
            str += m.toString();
        }
        return str;
    }
}
