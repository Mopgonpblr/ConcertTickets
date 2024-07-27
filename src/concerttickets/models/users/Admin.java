package concerttickets.models.users;

import concerttickets.models.Template;
import concerttickets.models.tickets.Ticket;

public class Admin extends Template implements User {

    static int lastId = 0;

    public Admin() {
        this.setId(Admin.lastId++);
    }

    public boolean checkTicket(Ticket ticket) {
        if (ticket.getCreationDate() == null) {
            return false;
        }
        if (ticket.getId() < 1000 || ticket.getId() > 9999) {
            return false;
        }
        if (ticket.getHall() == null || (ticket.getHall().isEmpty() || ticket.getHall().length() > 10)) {
            return false;
        }
        if (ticket.getCode() < 100 || ticket.getCode() > 999) {
            return false;
        }
        if (ticket.getTime() == 0) {
            return false;
        }

        return true;
    }

    public void printRole() {
        System.out.println("Admin");
    }
}