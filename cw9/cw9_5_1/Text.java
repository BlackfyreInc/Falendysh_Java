package cw9_5_1;
public class Text {
    private Sentence[] text;
    private Sentence header;

    Text(String str){
        String[] str_arr = str.split("[ ]+");
        text = new Sentence[str_arr.length];
        for (int i=0;i<str_arr.length;i++){
            text[i] = new Sentence(str_arr[i]);
        }
    }

    Text(String[] str){
        text = new Sentence[str.length];
        for (int i=0;i<str.length;i++){
            text[i] = new Sentence(str[i]);
        }
    }

    public void set_header(Sentence s){
        header = s;
    }

    public void print_header(){
        System.out.println(header);
    }

    public boolean equals(Text ob) {
        if (this.text.length != ob.text.length)
            return false;
        for (int i=0;i<this.text.length;i++){
            if (!this.text[i].equals(ob.text[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int p = 31;
        int m = 1000000009;
        int hash = 0;
        long p_pow = 1;
        for (Sentence sentence : this.text) {
            hash = (int) (hash + sentence.hashCode() * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(header.toString());
        for (Sentence sentence : this.text)
            str.append(sentence.toString()).append(' ');
        return str.toString();
    }
}
