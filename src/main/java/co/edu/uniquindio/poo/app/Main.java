package co.edu.uniquindio.poo.app;


import co.edu.uniquindio.poo.model.Agency;
import co.edu.uniquindio.poo.model.Car;
import co.edu.uniquindio.poo.model.CarFactory;
import co.edu.uniquindio.poo.model.RentalContract;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car1 = CarFactory.createCar("C01", "Sport", "Audi R8", "black", 2019);

        Car car2 = CarFactory.createCar("C02", "suv", "Mazda CX-5", "white", 2018);

        Car car3 = CarFactory.createCar("C03", "Economic", "Spark GT", "grey", 2016);

        Agency agency = Agency.getInstance();
        agency.addCar(car1);
        agency.addCar(car2);
        agency.addCar(car3);
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("\n ===== CAR RENTAL SYSTEM ===== ");
            System.out.println("1. Show all cars");
            System.out.println("2. Show available cars");
            System.out.println("3. Rent a car");
            System.out.println("4. Return a car");
            System.out.println("5. Show history rental contracts");
            System.out.println("6. Show active rented contracts");
            System.out.println("0. Exit");
            System.out.print(" Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    agency.showCars();
                    break;

                case 2:
                    agency.showAvailableCars();
                    break;

                case 3:
                    agency.showAvailableCars();
                    System.out.print("Enter the car ID to rent: ");
                    String carIdToRent = scanner.next();
                    Car carToRent = agency.getCarById(carIdToRent);

                    if (carToRent != null && agency.isCarAvailable(carToRent)) {
                        System.out.print("Number of days: ");
                        int days = scanner.nextInt();

                        System.out.print("Add insurance? (true/false): ");
                        boolean insurance = scanner.nextBoolean();

                        System.out.print("Add GPS? (true/false): ");
                        boolean gps = scanner.nextBoolean();

                        System.out.println("ID of the rental contract:");
                        String id = scanner.next();

                        agency.rentCar(id,carToRent, days, gps, insurance);
                    } else {
                        System.out.println(" Car not found or not available.");
                    }
                    break;

                case 4:
                    agency.showActiveRentedContracts();
                    System.out.print("Enter the ID of the rental contract: ");
                    String idContract = scanner.next();
                    RentalContract rentalContract = agency.getRentalContractById(idContract);

                    if (rentalContract != null) {
                        agency.returnCar(rentalContract.getCar(),rentalContract );
                    } else {
                        System.out.println(" Contract not found.");
                    }
                    break;

                case 5:
                    agency.showRentalContracts();
                    break;

                case 6:
                    agency.showActiveRentedContracts();
                    break;
                case 0:
                    System.out.println(" Bye! Thanks for using the Car Rental System.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);

        scanner.close();
    }

}

