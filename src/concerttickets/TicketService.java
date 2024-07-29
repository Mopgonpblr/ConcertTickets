package concerttickets;

import concerttickets.models.contactservices.Email;
import concerttickets.models.contactservices.Phone;
import concerttickets.models.tickets.Sector;
import concerttickets.models.tickets.Ticket;
import concerttickets.models.users.Admin;
import concerttickets.models.users.Client;

import java.time.LocalDateTime;

public class TicketService {
    public static void main(String[] args) {
        Admin admin = new Admin();

        Phone phone1 = new Phone();
        phone1.setCountryCode(375);
        phone1.setAreaCode(25);
        phone1.setNumber(2839595);

        Phone phone2 = new Phone();
        phone2.setCountryCode(375);
        phone2.setAreaCode(29);
        phone2.setNumber(1152398);

        Email email = new Email("javadeveloper", "gmail.com");

        Ticket emptyTicket = new Ticket();
        System.out.println(emptyTicket);

        try {
            Ticket fullTicket = new Ticket(
                    "Main Hall",
                    323,
                    LocalDateTime.of(2024, 7, 23, 16, 0, 0),
                    true,
                    Sector.B,
                    13.456789,
                    9.99);
            System.out.println(fullTicket);

            fullTicket.share(phone1);

            Client client = new Client(fullTicket);

            System.out.println("\nThe client's ticket:\n\n" + client.getTicket());

            System.out.println("The ticket is valid:" + admin.checkTicket(client.getTicket()));
        } catch (IllegalArgumentException e) {
            System.out.println("Can't create the ticket: " + e.getMessage());
        }

        System.out.println();

        try {
            Ticket limitedTicket = new Ticket("Back Hall",
                    289,
                    LocalDateTime.of(2024, 7, 23, 16, 0, 0));
            System.out.println(limitedTicket);

            limitedTicket.share(phone2, email);
        } catch (IllegalArgumentException e) {
            System.out.println("Can't create the ticket:" + e.getMessage());
        }
    }
}