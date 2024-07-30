package concerttickets.models.users;

import concerttickets.models.Template;
import concerttickets.models.contactservices.Email;
import concerttickets.models.tickets.Ticket;

public class Admin extends Template implements User {

    static int lastId = 0;
    private final String ROLE = "Admin";

    public Admin() {
        this.setId(++Admin.lastId);
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
        System.out.println("The role is: Admin");
    }
    @Override
    public void print() {
        System.out.println(this);
    }
    public void printDefault(){
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
        Admin admin = (Admin) object;
        if (this.getId() != admin.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = this.getId();
        result = 31 * result + this.ROLE.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ID: "+ this.getId() + "\nRole: " + this.ROLE;
    }
}