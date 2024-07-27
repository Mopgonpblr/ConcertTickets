package concerttickets.models.users;


import concerttickets.models.Template;
import concerttickets.models.tickets.Ticket;

public class Client extends Template implements User {
    static int lastId = 0;

    private final Ticket ticket;

    public Client(Ticket ticket){
        this.ticket = ticket;
        this.setId(Client.lastId++);
    }

    public Ticket getTicket(){
        return this.ticket;
    }

    public void printRole(){
        System.out.println("Client");
    }


}
