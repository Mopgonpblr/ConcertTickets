package concerttickets.models.users;


import concerttickets.models.Template;
import concerttickets.models.tickets.Ticket;

public class Client extends Template implements User {
    static int lastId = 0;

    private final String ROLE = "Client";

    private final Ticket ticket;

    public Client(Ticket ticket) {
        this.ticket = ticket;
        this.setId(++Client.lastId);
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    public void printRole() {
        System.out.println("The role is: Client");
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
        Client client = (Client) object;
        if (this.getId() != client.getId()) {
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
