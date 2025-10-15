package co.edu.uniquindio.poo.model;

public class Car {
    private String id;
    private String model;
    private String color;
    private int year;
    private boolean available;
    private double basePricePerDay;



    public Car(String id,String model, String color, int year,boolean available, double basePricePerDay) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.year = year;
        this.available = available;
        this.basePricePerDay = basePricePerDay;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }
    public boolean getAvailable(){
        return available;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "id= "+ id + "\t"+
                "model= " + model + "\t" +
                "color= " + color + "\t" +
                "year= " + year + "\t" +
                "Available= " + available + "\t" +
                "basePricePerDay= " + basePricePerDay;
    }

}
