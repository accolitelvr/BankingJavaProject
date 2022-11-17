import java.util.*;

final class Account{

    private String[] Name;
    private String Surname;
    private String[] Address;
    private float Overdraft;
    private float Balance;
    private HashMap<Integer, Statement> StatementLog = new HashMap<>();
    private String Password;
    private boolean Locked;
    private Integer Security;

    Account(String[] name, String Surname, String[] Address, float Overdraft)
    {
        this.Name = name;
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
        if ((PasswordCheck(password)) && (this.Overdraft < this.Balance + money)) {
            Statement statement = new Statement(ID, this.Balance, money, this.Balance + money);
            statement.setTime();
            this.Balance += money;
            Set<Integer> keys = StatementLog.keySet();
            int StatementNextID = Collections.max(keys);

            StatementLog.put(StatementNextID, statement);        }
        return false;
    }
    public float enquire(String password) {
        if (PasswordCheck(password)) {
            return this.Balance;
        }
        return 0;
    }

    public String info(String password) {
        if (PasswordCheck(password)) {
            return (this.Name + this.Surname +", " + Address);
        }
        return "";
    }



    boolean PasswordCheck(String password) {
            if ((!this.Locked) && (Objects.equals(password, this.Password))) {
                return true;
            } else {
                this.Security += 1;
                this.SecurityCheck();
                return false;
            }
    }
}