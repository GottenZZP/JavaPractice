package Encap;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("张三", 19, 9999);
        account.setBalance(20000000);
        account.setPassword(888888);
        account.info();
    }
}
