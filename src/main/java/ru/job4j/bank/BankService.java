package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу с банковскими счета клиентов
 */
public class BankService {
    /**
     * Константа хранит коллекцию из ключей клиент
     * и списка счетов клиента
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет в список клиентов
     * нового клиента с пустым списком счетов
     * @param user  новый клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет клиента из коллекции клиентов
     * @param passport принимает на вход паспорт клиента
     * @return true если удаление прошло успешно
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет клиент счет в его список счетов,
     * если находит клиент по паспорту
     * и у пользователя нет такого счета
     * @param passport паспорт
     * @param account новый счет
     */
    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по серии и номеру паспорта
     * @param passport серия и номер паспорта
     * @return клиент банка, иначе null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод находит счет клиента.
     * Сначала находит клиента по паспорту,
     * затем сам счет у этого клиента по номеру счета.
     * @param passport серия и номер паспорта
     * @param requisite номер счета
     * @return счет, если не найден, то null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = this.findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(u -> requisite.equals(u.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод совершает перевод суммы со счета на счет.
     * Сначала находим счета отправителя
     * и получателя по паспорту и номеру счета.
     * Если счет отправителя или получателя не найден
     * или баланс отправителя меньше суммы трансфера
     * то трансфер не происходит.
     * @param srcPassport серия и номер паспорта отправителя
     * @param srcRequisite номер счета отправителя
     * @param destPassport серия и номер паспорта получателя
     * @param destRequisite номер счета получателя
     * @param amount сумма трансфера
     * @return истина или ложь, взависимости совершен ли трансфер
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountSrc = this.findByRequisite(srcPassport, srcRequisite);
        Account accountDest = this.findByRequisite(destPassport, destRequisite);
        if (accountSrc == null || accountDest == null
                || accountSrc.getBalance() < amount) {
           return false;
        }
        accountSrc.setBalance(accountSrc.getBalance() - amount);
        accountDest.setBalance(accountDest.getBalance() + amount);
        return true;
    }

    /**
     * Метод получает список счетов клиента
     * @param user клиент банка
     * @return список счетов типа List
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}