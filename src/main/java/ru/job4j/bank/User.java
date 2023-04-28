package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиента банка
 */
public class User {
    /**
     * Поле хранит серию и номер паспорта
     */
    private String passport;
    /**
     * Поле хранит имя пользователя
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод получает серию и номер паспорта
     * @return серию и номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает клиенту серию и номер паспорта
     * @param passport серия и номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод получает имя клиента
     * @return имя клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод устанавливает имя клиента
     * @param username имя клиента
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}