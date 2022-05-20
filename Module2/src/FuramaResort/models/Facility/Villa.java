package FuramaResort.models.Facility;

public class Villa extends Facility{
    private String roomStandard;
    private int swimmingPoolArea;
    private int numberOfFloors;

    public Villa(String serviceName, int usableArea, int rentalCosts, int maximumQuantity,
                 String rentalType, String roomStandard, int swimmingPoolArea, int numberOfFloors) {
        super(serviceName, usableArea, rentalCosts, maximumQuantity, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public  Villa(){

    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(int swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
