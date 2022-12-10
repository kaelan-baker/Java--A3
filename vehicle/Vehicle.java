package vehicle;

public abstract class Vehicle {
    
    private String model;
    private String colour;
    private double speed;
    private double position;
    
    Vehicle(String modelIn, String colourIn){
        model = modelIn;
        colour = colourIn;
        speed = 0;
        position = 0;
    }
    public String getModel() {
        return model;
    }
    public String getColour() {
        return colour;
    }
    public double getSpeed() {
        return speed;
    }
    public double getPosition() {
        return position;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setPosition(double position) {
        this.position = position;
    }

    public void move(){
        position += speed;
    }

    public abstract void accelerate();
    public abstract String getIcon();
    public int getPositionInt(){
        int posInt = (int) Math.round(position);
        return posInt;
    }

    @Override
    public String toString() {
        String retString = "Model: " + model + ", Colour: " + colour + ", Speed: " + speed + ", Position: " + position;
        return retString;
    }
}
