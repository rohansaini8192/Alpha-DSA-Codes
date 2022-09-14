public class CopyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Rohan";
        s1.roll = 137;
        s1.password = "roh@n";
        Student s2 = new Student(s1);
        System.out.println(s2.name);
        System.out.println(s2.roll);
        System.out.println(s2.password);   // prints the copied password
        s2.password = "rohan8192";
        System.out.println(s2.password);   // prints new password
    }
}
class Student {
    String name;
    int roll;
    String password;
    Student(Student s1){
        this.name = s1.name;
        this.roll = s1.roll;
        this.password = s1.password;
    }
    Student(){}
}
