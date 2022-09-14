public class MultilpleInheritance {
    public static void main(String[] args) {
        Allrounder hardik = new Allrounder();
        hardik.ball();
    }
}
interface Bowler {
    void ball();
}
interface Batsman {
    void bat();
}
class Allrounder implements Bowler, Batsman {
    public void ball() {
        System.out.println("I can do bowling");
    }
    public void bat() {
        System.out.println("T can do batting");
    }
}