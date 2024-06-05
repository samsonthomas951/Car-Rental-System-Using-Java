//This is the car class 

public class Car {
    private String numberPlate;
    private String make;
    private String brand;
    private int year;
    private boolean available;
    /* Constructor*/
    public Car(String numberPlate, String make, String brand, int year, boolean available) {
        this.numberPlate = numberPlate;
        this.make = make;
        this.brand = brand;
        this.year = year;
        this.available = available;
    }

    //getters
    public String getnumberPlate() {
        return numberPlate;

    }

    public String getMake() {
        return make;
     }

    public String getBrand() {
         return brand;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
    return available;
    }

    public void setAvailability(boolean available) {
        this.available  = available;

    }
}
