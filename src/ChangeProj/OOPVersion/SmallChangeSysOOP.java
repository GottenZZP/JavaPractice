package ChangeProj.OOPVersion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    boolean state = true;
    String choice = "";
    Scanner scanner = new Scanner(System.in);

    String detail = "------------------零钱通明细------------------";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    double money = 0.0;
    double balance = 0.0;

    String note = "";
    String breakChoice = "";

    public void Menu() {
        do {
            System.out.println("\n------------------零钱通菜单------------------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.print("请选择(1-4): ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    this.ShowDetail();
                    break;
                case "2":
                    this.Income();
                    break;
                case "3":
                    this.Pay();
                    break;
                case "4":
                    this.Exit();
                    break;
                default:
                    System.out.println("输入有误！");
            }
        }while(state);
        System.out.println("欢迎下次使用～");
    }

    public void ShowDetail() {
        System.out.println(detail);
    }

    public void Income() {
        System.out.print("请输入本次收益: ");
        money = scanner.nextDouble();
        if (money <= 0) {
            System.out.println("入账金额有误，不得小于等于0元！");
            return;
        }
        balance += money;
        Date date = new Date();
        detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额:" + balance;
    }

    public void Pay() {
        System.out.print("请输入消费金额: ");
        money = scanner.nextDouble();

        if (money <= 0 || money > balance) {
            System.out.println("消费金额有误，只可在0 - " + balance + "之间！");
            return;
        }

        System.out.print("请输入消费内容: ");
        note = scanner.next();
        balance -= money;
        Date date2 = new Date();
        detail += "\n" + note + "\t-" + money + "\t" + sdf.format(date2) + "\t余额:" + balance;
    }

    public void Exit() {
        do {
            System.out.print("确认是否要退出零钱通(y/n): ");
            breakChoice = scanner.next();
        } while (!breakChoice.equals("y") && !breakChoice.equals("n"));

        if (breakChoice.equals("y")) {
            state = false;
        }
    }
}
