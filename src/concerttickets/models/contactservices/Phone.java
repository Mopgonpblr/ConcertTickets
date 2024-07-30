package concerttickets.models.contactservices;

import concerttickets.models.Template;

public class Phone extends Template {
    private int countryCode;
    private int areaCode;
    private int number;

    @Override
    public void print(){
        System.out.println(this);
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        if (countryCode > 0 && countryCode <= 999)
            this.countryCode = countryCode;
        else {
            throw new IllegalArgumentException("The country code can be 3 digits max");
        }
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        if (areaCode > 0 && areaCode <= 999)
            this.areaCode = areaCode;
        else {
            throw new IllegalArgumentException("The area code can be 3 digits max");
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number >= 100_00_00 && number <= 9999_9999)
            this.number = number;
        else {
            throw new IllegalArgumentException("The number should consist of 7 or 8 digits");
        }
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
        Phone phone = (Phone) object;
        if (this.getId() != phone.getId()){
            return false;
        }
        if (this.countryCode != phone.countryCode) {
            return false;
        }
        if (this.areaCode != phone.areaCode) {
            return false;
        }
        if (this.number != phone.number) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = this.getId();
        result = 31 * result + this.countryCode;
        result = 31 * result + this.areaCode;
        result = 31 * result + this.number;
        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+").append(countryCode).append("-").append(areaCode).append("-").append(number);
        return sb.toString();
    }
}
