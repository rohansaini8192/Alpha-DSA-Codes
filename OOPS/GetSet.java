public class GetSet {
    public static void main(String[] args) {
        BankAccount myBank = new BankAccount();
        myBank.username = "rohansaini";
        System.out.println(myBank.username);
        // myBank.password() = "roh@n123";        // Error
        myBank.setPassword("roh@n123");
        System.out.println(myBank.getPassword());
    }
}
class BankAccount {
    public String username;
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
