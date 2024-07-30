package concerttickets.models.contactservices;

import concerttickets.models.Template;


public class Email extends Template {
    static int lastId = 0;
    private final String login;
    private final String service;

    public Email(String login, String service) {
        this.setId(++Email.lastId);
        this.login = login;
        this.service = service;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    public void printDefault() {
        super.print();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (this.hashCode() != object.hashCode()) {
            return false;
        }

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Email email = (Email) object;
        if (this.getId() != email.getId()) {
            return false;
        }
        if (!this.login.equals(email.login)) {
            return false;
        }
        if (!this.service.equals(email.service)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = this.getId();
        result = 31 * result + this.login.hashCode();
        result = 31 * result + this.service.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return login + "@" + service;
    }
}
