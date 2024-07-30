package concerttickets.models.tickets;

import concerttickets.models.contactservices.Email;
import concerttickets.models.contactservices.Phone;
import concerttickets.models.Template;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Ticket extends Template {
    private String hall;
    private int code;
    private long time;
    private boolean isPromo;
    private Sector sector;
    private BigDecimal maxWeight;
    private BigDecimal price;

    private LocalDateTime creationDate;
    static int lastId = 0;


    public Ticket(String hall, int code, LocalDateTime time, boolean isPromo, Sector sector,
                  double maxWeight, double price) {
        this.createFullTicket(hall, code, time, isPromo, sector, maxWeight, price);

    }

    public Ticket(String hall, int code, LocalDateTime time) {
        this.createLimitedTicket(hall, code, time);
    }

    public Ticket() {

    }


    private void createLimitedTicket(String hall, int code, LocalDateTime time) {
        this.setId(++Ticket.lastId);

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

        this.setTime(time);
        this.creationDate = LocalDateTime.now();
    }

    private void createFullTicket(String hall, int code, LocalDateTime time, boolean isPromo, Sector sector,
                                  double maxWeight, double price) {
        this.createLimitedTicket(hall, code, time);

        this.isPromo = isPromo;
        this.sector = sector;


        if (maxWeight >= 0) {
            this.maxWeight = new BigDecimal(maxWeight).setScale(3, RoundingMode.HALF_EVEN);
        } else {
            throw new IllegalArgumentException("The max weight variable can't have negative value");
        }

        if (price >= 0) {
            this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_EVEN);
        } else {
            throw new IllegalArgumentException("The price variable can't have negative value");
        }

    }

    @Override
    public void print() {
        System.out.println(this);
    }

    public void printDefault(){
        super.print();
    }

    public void share(Phone phone) {
        System.out.println("The ticket sent to the next phone number:" + phone);
    }

    public void share(Phone phone, Email email) {
        System.out.println("The ticket sent to the next phone number:" + phone);
        System.out.println("The ticket sent to the next email:" + email);
    }

    public String getHall() {
        return this.hall;
    }

    public int getCode() {
        return this.code;
    }

    public void setTime(LocalDateTime time) {
        /*
        The new Date Time API from Java 8 provides the LocalDate and Instant classes to manipulate date and time.
        We can get the current Unix time by invoking getEpochSecond() on the Instant object:
         */
        Instant instant = time.atZone(ZoneId.of("GMT")).toInstant();
        this.time = instant.getEpochSecond();
    }

    public long getTime() {
        return this.time;
    }

    public boolean isPromo() {
        return this.isPromo;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Sector getSector() {
        return this.sector;
    }

    public BigDecimal getMaxWeight() {
        return this.maxWeight;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
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
        Ticket ticket = (Ticket) object;
        if (!this.hall.equals(ticket.hall)) {
            return false;
        }
        if (this.code != ticket.code) {
            return false;
        }
        if (this.time != ticket.time) {
            return false;
        }
        if (this.isPromo != ticket.isPromo) {
            return false;
        }
        if (this.sector != ticket.sector) {
            return false;
        }
        if (!this.maxWeight.equals(ticket.maxWeight)) {
            return false;
        }
        if (!this.price.equals(ticket.price)) {
            return false;
        }
        if (this.creationDate != ticket.creationDate) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = this.hall == null ? 0 : this.hall.hashCode();
        result = 31 * result + code;
        result = 31 * result + Long.hashCode(time);
        result = 31 * result + Boolean.hashCode(isPromo);
        result = 31 * result + sector.hashCode();
        result = 31 * result + (this.maxWeight == null ? 0 : this.maxWeight.hashCode());
        result = 31 * result + (this.price == null ? 0 : this.price.hashCode());
        result = 31 * result + (this.creationDate == null ? 0 : this.creationDate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID:").append(this.getId()).
                append("\nConcert Hall: ").append(this.hall).
                append("\nEvent Code: ").append(this.code).
                append("\nTime: ").append(this.time).
                append("\nIt is promo: ").append(this.isPromo).
                append("\nStadium Sector: ").append(this.sector).
                append("\nMax allowed backpack weight (kg): ").append(this.maxWeight).
                append("\nPrice: ").append(this.price).
                append("\nTicket Creation Time: ").append(this.creationDate).append("\n");
        return sb.toString();
    }
}
