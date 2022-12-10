package vehicle;
public class Truck extends Vehicle {

    double accel;
    String icon = "T";
    private boolean isDiesel;

    public Truck(String model, String colour, boolean isDiesel){
        super(model, colour);
        this.isDiesel = isDiesel;
    }

    @Override
    public void accelerate() {
        if(isDiesel){
            accel = 0.4;
        }else{
            accel = 0.5;
        }
        super.setSpeed(super.getSpeed() + accel);
        
    }

    @Override
    public String getIcon() {
        return icon;
    }
}
