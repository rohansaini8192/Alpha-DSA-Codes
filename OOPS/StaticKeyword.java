public class StaticKeyword {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Rohan";
        s1.college = "ITS";
        Student s2 = new Student();
        System.out.println(s2.college);
    }

}
class Student {
    String name;
    int roll;
    static String college;
}