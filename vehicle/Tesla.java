package vehicle;
public class Tesla extends Vehicle {

    double accel;
    String icon = "E";
    private boolean isTwoMotor;

    public Tesla(String model, String colour, boolean isTwoMotor){
        super(model, colour);
        this.isTwoMotor = isTwoMotor;
    }

    @Override
    public void accelerate() {
        if(this.isTwoMotor){
            accel = 0.8;
        }else{
            accel = 0.6;
        }
        super.setSpeed(super.getSpeed() + accel);
        
    }

    @Override
    public String getIcon() {
        return icon;
    }
}
