package extend_;

public class Test {
    public static void main(String[] args) {
        Pc pc = new Pc();
        Notepad notepad = new Notepad();

        pc.brand = "联想";
        pc.cpu = "i5";
        pc.hard_drive = "512g";
        pc.memory = "16g";

        notepad.color = "黄色";
        notepad.cpu = "i7";
        notepad.hard_drive = "1t";
        notepad.memory = "32g";

        pc.getDetail();
        System.out.println("------------");
        notepad.getDetail();
    }
}
