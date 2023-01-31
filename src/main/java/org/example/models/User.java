package org.example.models;

import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import java.util.stream.Stream;

public class User {
    private String login;
    private String mail;

    public User(String login, String mail) {
        setLogin(login);
        setMail(mail);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.isBlank()) {
//            throw new IllegalArgumentException("Login is empty!");
        }
        if (!StringUtils.isAlphanumeric(login)) {
//                throw new IllegalArgumentException("Login contains invalid chars: " + login);
        }
        this.login = login;

        }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if (mail == null || mail.isBlank()) {
//            throw new IllegalArgumentException("Mail is empty!");
        }
        Stream.of(mail)
                .filter(m-> m.contains("@"))
                .filter(m->m.contains("."));
        this.mail = mail;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) && mail.equals(user.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getMail());
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
