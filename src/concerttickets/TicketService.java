package concerttickets;

import java.time.LocalDateTime;

public class TicketService {
    public static void main(String[] args) {
        Ticket emptyTicket = new Ticket();
        System.out.println(emptyTicket);

        try {
            Ticket fullTicket = new Ticket(
                    "Main Hall",
                    323,
                    LocalDateTime.of(2024, 7, 23, 16, 0, 0),
                    true,
                    'B',
                    13.456789,
                    9.99);
            System.out.println(fullTicket);
        } catch (IllegalArgumentException e) {
            System.out.println("Can't create the ticket: " + e.getMessage());
        }

        try {
            Ticket limitedTicket = new Ticket("Back Hall",
                    289,
                    LocalDateTime.of(2024, 7, 23, 16, 0, 0));
            System.out.println(limitedTicket);
        } catch (IllegalArgumentException e) {
            System.out.println("Can't create the ticket:" + e.getMessage());
        }
    }
}