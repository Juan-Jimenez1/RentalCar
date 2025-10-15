package co.edu.uniquindio.poo.model;

public class RentalContract {
    private String id;
    private Car car;
    private int days;
    private boolean gps;
    private boolean insurance;
    private double totalPrice;

    public RentalContract(Builder builder) {
        this.id = builder.id;
        this.car = builder.car;
        this.days = builder.days;
        this.gps = builder.gps;
        this.insurance = builder.insurance;
        this.totalPrice = calculateTotalPrice();
    }

    public double calculateTotalPrice(){
       double price= this.car.getBasePricePerDay() * this.days;
       if(gps){ price+=50000 * days;}
       if(insurance){ price+=150000;}
       return price;
    }



    public static class Builder{
        private String id;
        private Car car;
        private int days;
        private boolean gps;
        private boolean insurance;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder car(Car car){
            this.car = car;
            return this;
        }
        public Builder days(int days){
            this.days = days;
            return this;
        }
        public Builder gps(boolean gps){
            this.gps = gps;
            return this;
        }
        public Builder insurance(boolean insurance){
            this.insurance = insurance;
            return this;
        }
        public RentalContract build(){
            return new RentalContract(this);
        }
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getID(){
        return id;
    }
    public void setID(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        String extras="";
        if (gps) extras+= "GPS\t";
        if (insurance) extras+= "Insurance\t";
        return " Rental contract\n" +
                "Contract ID: " + id + "\n" +
                "Car: " + car + "\n" +
                "Days: " + days + "\n" +
                "Extra:" + extras + "\n" +
                "Total: $" + totalPrice;
    }


}
