import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Ticket {
    private String id;
    private String hall;
    private int code;
    private long time;
    private boolean isPromo;
    private char sector;
    private double maxWeight;
    private String price;
    private final LocalDateTime creationTime;

    public Ticket(String id, String hall, int code, LocalDateTime time, boolean isPromo, char sector,
                  double maxWeight, double price) {
        this();
        this.setId(id);
        this.setHall(hall);
        this.setCode(code);
        this.setTime(time);
        this.setPromo(isPromo);
        this.setSector(sector);
        this.setMaxWeight(maxWeight);
        this.setPrice(price);
    }

    public Ticket(String hall, int code, LocalDateTime time) {
        this();
        this.setHall(hall);
        this.setCode(code);
        this.setTime(time);
    }

    public Ticket() {
        this.creationTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() <= 4) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("The ID should be 4 digits and/or chars max");
        }
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        if (hall.length() <= 10) {
            this.hall = hall;
        } else {
            throw new IllegalArgumentException("The hall name should be 10 chars max");
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        if (code >= 100 && code <= 999) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("The code should be a 3 digit number");
        }
    }

    public long getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        /*
        The new Date Time API from Java 8 provides the LocalDate and Instant classes to manipulate date and time.
        We can get the current Unix time by invoking getEpochSecond() on the Instant object:
         */
        Instant instant = time.atZone(ZoneId.of("GMT")).toInstant();
        this.time = instant.getEpochSecond();
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public char getSector() {
        return sector;
    }

    public void setSector(char sector) {
        switch (sector) {
            case 'A':
            case 'B':
            case 'C':
                this.sector = sector;
                break;
            default:
                throw new IllegalArgumentException("The sector name can only have 'A','B' and 'C' values");
        }
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        int temp = (int) (maxWeight * 1000); //limits the value to kilograms and grams
        this.maxWeight = (double) temp / 1000;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(double price) {
        int temp = (int) (price * 100); //limits the value to dollars and cents
        this.price = "$" + (double) temp / 100;
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
                append("\nTicket Creation Time: ").append(this.creationTime).append("\n");
        return sb.toString();
    }
}
