package hw;

public class Genres {
    static class Rock extends Music{
        public Rock(int l, String n, String a){
            super(l,n,a);
            this.genre = "Rock";
        }

        public Rock() {super();}

        @Override
        public String toString(){
            return this.genre + " music has length: " + super.len + ", name: " + super.name + "and author: " + super.author;
        }
    }

    static class Pop extends Music{
        public Pop(int l, String n, String a){
            super(l,n,a);
            this.genre = "Pop";
        }

        public Pop() {super();}

        @Override
        public String toString(){
            return this.genre + " music has length: " + super.len + ", name: " + super.name + "and author: " + super.author;
        }
    }

    static class Classic extends Music{
        public Classic(int l, String n, String a){
            super(l,n,a);
            this.genre="Classic";
        }

        public Classic() {super();}

        @Override
        public String toString(){
            return this.genre + " music has length: " + super.len + ", name: " + super.name + "and author: " + super.author;
        }
    }
}
