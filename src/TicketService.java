import java.time.LocalDateTime;

public class TicketService {
    public static void main(String[] args) {
        Ticket emptyTicket = new Ticket();
        Ticket fullTicket = new Ticket("123A",
                "Main Hall",
                323,
                LocalDateTime.of(2024, 7, 23, 16, 0, 0),
                true,
                'B',
                13.456789,
                9.999999);
        Ticket limitedTicket = new Ticket("Back Hall",
                289,
                LocalDateTime.of(2024, 7, 23, 16, 0, 0));

        System.out.println(emptyTicket);
        System.out.println(fullTicket);
        System.out.println(limitedTicket);
    }
}