package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;
    private static Long accountNum = 0L;

    public Bank() {
        // complete the function
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
        return accounts.getOrDefault(accountNumber, null);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // complete the function
        accountNum+=1;
        CommercialAccount account = new CommercialAccount(company, accountNum, pin, startingDeposit);
        accounts.put(accountNum, account);
        return accountNum;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // complete the function
        accountNum+=1;
        ConsumerAccount account = new ConsumerAccount(person, accountNum, pin, startingDeposit);
        accounts.put(accountNum, account);
        // account.getBalance()
        return (long) account.getBalance();
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        Account account = accounts.getOrDefault(accountNumber, null);
        return account != null && account.validatePin(pin);
    }

    public double getBalance(Long accountNumber) {
        // complete the function
        Account account = accounts.getOrDefault(accountNumber, null);
        if(account != null) return  account.getBalance();
        return 0.0;
    }

    public void credit(Long accountNumber, double amount) {
        // complete the function
        Account account = accounts.getOrDefault(accountNumber, null);

        if(account != null){
            account.creditAccount(amount);
            accounts.replace(accountNumber, account);
        }
    }

    public boolean debit(Long accountNumber, double amount) {
        // complete the function

        Account account = accounts.getOrDefault(accountNumber, null);

        if(account != null){
            account.debitAccount(amount);
            accounts.replace(accountNumber, account);
            return true;
        }
        return true;
    }
}
