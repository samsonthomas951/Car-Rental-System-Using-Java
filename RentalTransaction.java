import java.util.Date; //for setting the day to rent the car

public class RentalTransaction {
    private Customer customer;
    private Car car;
    private Date rentalDate;

    public RentalTransaction(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
        this.rentalDate = new Date(); // Set rental date to current date
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public Date getRentalDate() {
        return rentalDate;
    }
}
