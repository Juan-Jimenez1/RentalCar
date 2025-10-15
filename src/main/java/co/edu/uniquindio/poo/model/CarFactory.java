package co.edu.uniquindio.poo.model;

public class CarFactory {
    public static Car createCar(String id,String type, String model, String color, int year) {
        switch (type.toLowerCase()) {
            case "economic":
                return new EconomicCar(id,model, color, year);
            case "suv":
                return new SUVCar(id,model, color, year);
            case "sport":
                return new SportCar(id,model, color, year);
            default:
                throw new IllegalArgumentException("Type not valid");
        }
    }
}
