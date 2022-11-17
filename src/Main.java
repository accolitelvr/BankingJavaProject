import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank Santander = new Bank();
        Client BobReal = new Client(1,"MyFriendKevin");
        Client BobFake = new Client(2,"MyFriendJames");
        Account Bob = new Account(new String[] {"Bob"},"Hunter", new String[]{"2 Hunter way", "Edinburgh"},50);
        Santander.AddAccount(Bob,"MyFriendKevin");
        
    }
}
