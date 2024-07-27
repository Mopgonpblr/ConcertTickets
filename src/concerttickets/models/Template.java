package concerttickets.models;

public abstract class Template {
    private int id;

    public void print(){
        System.out.println("print content in console");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
