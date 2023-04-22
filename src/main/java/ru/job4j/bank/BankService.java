package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public boolean deleteUser(String passport) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
           if (passport.equals(entry.getKey().getPassport())) {
               return users.remove(entry.getKey(), entry.getValue());
           }
        }
        return false;
    }

    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if (user != null) {
            for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
                if (user.equals(entry.getKey())) {
                    List<Account> accounts = entry.getValue();
                    if (!accounts.contains(account)) {
                        accounts.add(account);
                        entry.setValue(accounts);
                    }
                }
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = this.findByPassport(passport);
        if (user != null) {
            for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
                if (user.equals(entry.getKey())) {
                    for (Account account : entry.getValue()) {
                        if (requisite.equals(account.getRequisite())) {
                            return account;
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountSrc = this.findByRequisite(srcPassport, srcRequisite);
        Account accountDest = this.findByRequisite(destPassport, destRequisite);
        if (accountSrc == null || accountDest == null
                || accountSrc.getBalance() < amount) {
           return false;
        }
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            for (Account account : entry.getValue()) {
                if (accountSrc.equals(account)) {
                    account.setBalance(accountSrc.getBalance() - amount);
                } else if (accountDest.equals(account)) {
                    account.setBalance(accountDest.getBalance() + amount);
                }
            }
        }
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}