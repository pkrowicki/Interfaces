import java.util.ArrayList;

/**
 * Created by Pawel Krowicki on 29.03.2017.
 */
public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears){
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0,0.0);
        this.gears.add(neutral);
        for(int i=0;i<maxGears;i++){
            addGear(i,i*1.3);
        }
    }

    public void operateClutch(boolean in){
        this.clutchIsIn = in;
    }

    public void addGear(int number, double ratio){
        if((number > this.maxGears) && (number < 0)){
            System.out.println("Maximum amount of gears already added!");
        } else {
            this.gears.add(new Gear(number,ratio));
        }
    }

    public void changeGear(int newGear){
        if((newGear>=0)&&(newGear<this.gears.size()) && clutchIsIn){
            this.currentGear = newGear;
            System.out.println("Gear changed to " + this.currentGear);
        } else {
            this.currentGear=0;
            System.out.println("Cannot change gear.");
            if(newGear<0){
                System.out.println("Gear cannot be negative!");
            }
            if(newGear>this.gears.size()){
                System.out.println("Gear number too high! Max is " + maxGears);
            }
            if(!clutchIsIn){
                System.out.println("Ouch. Gear is not in... :(");
            }
        }
    }

    public double wheelSpeed(int revs){
        if(clutchIsIn){
            System.out.println("Do not scream and leave that clutch alone!");
            return 0.0;
        }
        return revs*gears.get(currentGear).getRatio();
    }

    private class Gear {
        private int gearNmbr;
        private double ratio;

        public Gear(int gearNmbr, double ratio) {
            this.gearNmbr = gearNmbr;
            this.ratio = ratio;
        }

        public int getGearNmbr() {
            return gearNmbr;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs){
            return revs*(this.ratio);
        }

    }

}
