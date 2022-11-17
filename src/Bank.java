import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Bank {


    // the identifying data will be stored in an Account.
    // when the account is made, in order to be accessible, it has to be added to a register.
    // at this point, it will be assigned an ID.
    //

    private HashMap<Integer, Account> Ledger;

    int AddAccount(Account account, String Password) {
        Set<Integer> keys = Ledger.keySet();
        int MaxAccountNo = Collections.max(keys);
        account.setPassword(Password);
        Ledger.put(MaxAccountNo + 1,account);
        Ledger.get(MaxAccountNo + 1);
        return(MaxAccountNo+1);
    }

    Float enquiry(Integer AccountNo, String password, Integer ID) {
        synchronized (Ledger.get(AccountNo)) {
            return Ledger.get(AccountNo).enquire(password);
            }
        }

    String info(Integer AccountNo, String password, Integer ID) {
        synchronized (Ledger.get(AccountNo)) {
            return Ledger.get(AccountNo).info(password);
        }
    }

    Boolean enquiry(Integer AccountNo, String password, Float change, Integer ID) {
        synchronized (Ledger.get(AccountNo)) {
            return Ledger.get(AccountNo).deposit(password, change, ID);
        }
    }


    }
