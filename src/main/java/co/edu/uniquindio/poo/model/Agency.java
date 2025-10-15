package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private String name;
    private String nit;
    private static Agency instance;
    private List<Car> cars;
    private List<Car>availableCars;
    private List<RentalContract> rentalContracts;
    private List<RentalContract> activeRentedContracts;


    public Agency() {
        this.name = "AgencyLuxury";
         this.nit = "188399112-1";
         this.cars = new ArrayList<>();
         this.availableCars = new ArrayList<>();
         this.rentalContracts = new ArrayList<>();
         this.activeRentedContracts = new ArrayList<>();
    }

    public static Agency getInstance(){
        if(instance == null){
            instance = new Agency();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }


    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car){
        if(!cars.contains(car)){
            cars.add(car);
            availableCars.add(car);
        }else{
            System.out.println("The car is already created");
        }
    }

    public void removeCar(Car car) {
        if (cars.contains(car)) {
            cars.remove(car);
        } else {
            System.out.println("The car is not created");
        }
    }

    public void showCars(){
        for(Car car: cars){
            System.out.println(car.toString());
        }
    }

    public Car getCarById(String id){
        for(Car car: cars){
            if(car.getId().equalsIgnoreCase(id)){
                return car;
            }
        }
        return null;
    }

    public void createRentalContract(String id,Car car, int days, boolean gps, boolean insurance){
        RentalContract rentalContract= new RentalContract.Builder()
                .id(id)
                .car(car)
                .days(days)
                .gps(gps)
                .insurance(insurance)
                .build();

        rentalContracts.add(rentalContract);
        activeRentedContracts.add(rentalContract);
        System.out.println("The rental contract has been created");
        System.out.println("The final price is: $"+rentalContract.getTotalPrice());
    }

    public void rentCar(String id,Car car, int days, boolean gps, boolean insurance){
        if(car.getAvailable()){
            createRentalContract(id,car, days, gps, insurance);
            availableCars.remove(car);
        }else{
            System.out.println("The car is not available to rent");
        }
    }


    public void returnCar(Car car, RentalContract rentalContract){
            availableCars.add(car);
            activeRentedContracts.remove(rentalContract);
            System.out.println("The car has been returned");
    }

    public void showRentalContracts(){
        for(RentalContract contract: rentalContracts){
            System.out.println("-----------------------------");
            System.out.println(contract.toString());
            System.out.println("-----------------------------");
        }
    }

    public void showAvailableCars(){
        for(Car car: availableCars){
            System.out.println(car.toString());

        }
    }

    public boolean isCarAvailable(Car car){
        return car.getAvailable();
    }

    public RentalContract getRentalContractById(String id){
        for (RentalContract contract : activeRentedContracts) {
            if(contract.getID().equalsIgnoreCase(id)){
                return contract;
            }
        }
        return null;
    }

    public void showActiveRentedContracts(){
        for(RentalContract contract: activeRentedContracts){
            System.out.println("-----------------------------");
            System.out.println(contract.toString());
            System.out.println("-----------------------------");
        }
    }
}
