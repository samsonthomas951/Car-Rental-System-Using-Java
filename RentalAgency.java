import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;
    private List<RentalTransaction> transactions;

    public RentalAgency() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Customer customer, Car car) {
        if (car.isAvailable()) {
            car.setAvailability(false);
            RentalTransaction transaction = new RentalTransaction(customer, car);
            transactions.add(transaction);
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar(Car car) {
        car.setAvailability(true);
        System.out.println("Car returned successfully!");
    }

    public void displayAvailableCars() {
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car.getnumberPlate() + " - " + car.getMake() + " " + car.getBrand() + " (" + car.getYear() + ")");
            }
        }
    }

    public void displayCustomerRentalHistory(Customer customer) {
        for (RentalTransaction transaction : transactions) {
            if (transaction.getCustomer().equals(customer)) {
                System.out.println("Rented " + transaction.getCar().getnumberPlate() + " on " + transaction.getRentalDate());
            }
        }
    }

    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("Welcome to Car Rental Agency!");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. Display Available Cars");
            System.out.println("6. Display Customer Rental History");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline
    
            switch (option) {
                case 1:
                    System.out.print("Enter license plate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Car car = new Car(licensePlate, make, model, year, true);
                    agency.addCar(car);
                    System.out.println("Car added successfully!");
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    Customer customer = new Customer(name);
                    agency.addCustomer(customer);
                    System.out.println("Customer added successfully!");
                    break;
                case 3:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Customer rentingCustomer = null;
                    for (Customer c : agency.customers) {
                        if (c.getName().equals(customerName)) {
                            rentingCustomer = c;
                            break;
                        }
                    }
                    if (rentingCustomer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    agency.displayAvailableCars();
                    System.out.print("Enter car license plate: ");
                    String rentLicensePlate = scanner.nextLine();
                    Car rentingCar = null;
                    for (Car c : agency.cars) {
                        if (c.getnumberPlate().equals(rentLicensePlate)) {
                            rentingCar = c;
                            break;
                        }
                    }
                    if (rentingCar == null) {
                        System.out.println("Car not found.");
                        break;
                    }
                    agency.rentCar(rentingCustomer, rentingCar);
                    break;
                case 4:
                    System.out.print("Enter car license plate: ");
                    String returnLicensePlate = scanner.nextLine();
                    Car returningCar = null;
                    for (Car c : agency.cars) {
                        if (c.getnumberPlate().equals(returnLicensePlate)) {
                            returningCar = c;
                            break;
                        }
                    }
                    if (returningCar == null) {
                        System.out.println("Car not found.");
                        break;
                    }
                    agency.returnCar(returningCar);
                    break;
                case 5:
                    agency.displayAvailableCars();
                    break;
                case 6:
                    System.out.print("Enter customer name: ");
                    String historyCustomerName = scanner.nextLine();
                    Customer historyCustomer = null;
                    for (Customer c : agency.customers) {
                        if (c.getName().equals(historyCustomerName)) {
                            historyCustomer = c;
                            break;
                        }
                    }
                    if (historyCustomer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    agency.displayCustomerRentalHistory(historyCustomer);
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
}
