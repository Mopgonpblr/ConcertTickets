package concerttickets.models.contactservices;

import concerttickets.models.Template;

public class Email extends Template {
    private final String login;
    private final String service;

    public Email(String login, String service) {
        this.login = login;
        this.service = service;
    }

    @Override
    public void print(){
        System.out.println(this);
    }
    @Override
    public String toString() {
        return login + "@" + service;
    }
}
