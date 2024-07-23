package concerttickets;

public class TicketStore {
    private Ticket[] tickets = new Ticket[10];

    public void addTicket(Ticket ticket) {
        for (int i = 0; i < 10; i++){
            if (tickets[i] == null){
                tickets[i] = ticket;
                return;
            }
        }
        System.out.println("The tickets store is full");
    }

}
