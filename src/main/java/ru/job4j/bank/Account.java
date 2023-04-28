package ru.job4j.bank;

import java.util.Objects;

/**
 *Класс описывает счет клиента в банке
 * @author wild8ear
 * @version 1.0
 */
public class Account {
    /**
     *Поле хранит номер счета
     */
    private String requisite;
    /**
     *Поле хранит баланс счета
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить номер счета
     * @return номер счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет установить номер счета
     * @param requisite номер счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс
     * @return баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает баланс
     * @param balance сумма баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределен метод equals
     * сравнение происходит по номеру счета
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     *Переопределен метод hashcode
     * @return возвращет хэш счета полученный по его номеру
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}