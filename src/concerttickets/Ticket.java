package concerttickets;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

public class Ticket {
    private String id;
    private String hall;
    private int code;
    private long time;
    private boolean isPromo;
    private char sector;
    private String maxWeight;
    private String price;
    private final LocalDateTime CREATION_TIME;

    public Ticket(String hall, int code, LocalDateTime time, boolean isPromo, char sector,
                  double maxWeight, double price) {
        this(hall, code, time);

        this.isPromo = isPromo;

        if ((sector >= 'A') && (sector <= 'C')) {
            this.sector = sector;
        } else {
            throw new IllegalArgumentException("The sector name can only have values from 'A' to 'C'");
        }

        if (maxWeight >= 0) {
            this.maxWeight = String.format("%.3f", maxWeight);
        } else {
            throw new IllegalArgumentException("The max weight variable can't have negative value");
        }

        if (price >= 0) {
            this.price = String.format("%.2f", price);
        } else {
            throw new IllegalArgumentException("The price variable can't have negative value");
        }

    }

    public Ticket(String hall, int code, LocalDateTime time) {
        this();
        this.id = generateId();
        if (hall.length() <= 10) {
            this.hall = hall;
        } else {
            throw new IllegalArgumentException("The hall name should be 10 chars max");
        }

        if ((code >= 100) && (code <= 999)) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("The code should be a 3 digit number");
        }
        /*
        The new Date Time API from Java 8 provides the LocalDate and Instant classes to manipulate date and time.
        We can get the current Unix time by invoking getEpochSecond() on the Instant object:
         */
        Instant instant = time.atZone(ZoneId.of("GMT")).toInstant();
        this.time = instant.getEpochSecond();
    }

    public Ticket() {
        this.CREATION_TIME = LocalDateTime.now();
    }

    private String generateId() {
        StringBuilder newId = new StringBuilder();
        Random random = new Random();
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 4; i++) {
            newId.append(characters.charAt(random.nextInt(characters.length())));
        }
        return newId.toString();
    }
    public String getId(){
        return this.id;
    }

    public char getSector(){
        return this.sector;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID:").append(this.id).
                append("\nConcert Hall: ").append(this.hall).
                append("\nEvent Code: ").append(this.code).
                append("\nTime: ").append(this.time).
                append("\nIt is promo: ").append(this.isPromo).
                append("\nStadium Sector: ").append(this.sector).
                append("\nMax allowed backpack weight (kg): ").append(this.maxWeight).
                append("\nPrice: ").append(this.price).
                append("\nTicket Creation Time: ").append(this.CREATION_TIME).append("\n");
        return sb.toString();
    }
}
