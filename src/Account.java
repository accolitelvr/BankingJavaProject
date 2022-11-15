import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

final class Account{

    ArrayList<String> name;
    String Surname;
    ArrayList<String> Address;
    float Overdraft;
    float Balance;
    HashMap<Integer, Statement> StatementLog;
    private String Password;
    private boolean Locked;
    Integer Security;

    Account(ArrayList<String> name, String Surname, ArrayList<String> Address, float Overdraft)
    {
        this.name = name;
        this.Surname = Surname;
        this.Address = Address;
        this.Overdraft = Overdraft;
    }


    void setPassword(String password) {
        if (password != null) {
            this.Password = password;
        }
    }

    private void SecurityCheck() {
        if (this.Security > 2) {
            this.Locked = true;
        }
    }

    public boolean deposit(String password, float money, int ID) {
        if ((PasswordCheck(password) == true) && (this.Overdraft < this.Balance + money)) {
            Statement statement = new Statement(ID, this.Balance, money, this.Balance + money);
            statement.setTime();
            this.Balance += money;
            Set<Integer> keys = StatementLog.keySet();
            int StatementNextID = Collections.max(keys);

            StatementLog.put(StatementNextID, statement);
        }
        return false;
    }
    public float enquire(String password) {
        if (PasswordCheck(password) == true) {
            return this.Balance;
        }
        return 0;
    }



    boolean PasswordCheck(String password) {
            if ((this.Locked == false) && (password == this.Password)) {
                return true;
            } else {
                this.Security += 1;
                this.SecurityCheck();
                return false;
            }
    }
}