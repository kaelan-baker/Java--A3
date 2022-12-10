package vehicle;
public class Motercycle extends Vehicle {
    
    double accel = 0.6;
    String icon = "M";

    public Motercycle(String model, String colour){
        super(model, colour);
    }

    @Override
    public void accelerate() {
        super.setSpeed(super.getSpeed() + accel);
    }

    @Override
    public String getIcon() {
        return icon;
    }
}
