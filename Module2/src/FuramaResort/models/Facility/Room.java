package FuramaResort.models.Facility;

public class Room extends Facility{
    private String freeServiceIncluded;

    public Room(String serviceName, int usableArea, int rentalCosts,
                int maximumQuantity, String rentalType, String freeServiceIncluded) {
        super(serviceName, usableArea, rentalCosts, maximumQuantity, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }


    public Room(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public  Room(){

    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }
}
