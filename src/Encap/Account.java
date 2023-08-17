package Encap;

public class Account {
    private String name;
    private int balance;
    private int password;

    public Account() {
    }

    public Account(String name, int balance, int password) {
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 3)
            this.name = name;
        else
            System.out.println("名称长度违规！");
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance > 20)
            this.balance = balance;
        else {
            System.out.println("余额太少了，设为默认值20");
            this.balance = 20;
        }
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        if (password >= 100000 && password <= 999999)
            this.password = password;
        else {
            System.out.println("密码格式错误！已赋初值：666666");
            this.password = 666666;
        }
    }

    public void info() {
        System.out.println("姓名：" + this.name + " 账户余额：" + this.balance + " 密码：" + this.password);
    }
}
