import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel Krowicki on 27.03.2017.
 */
public class Moster implements ISave {
    private String name;
    private int hitPts;
    private int strength;

    public Moster(String name, int hitPts, int strength) {
        this.name = name;
        this.hitPts = hitPts;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPts() {
        return hitPts;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Moster{" +
                "name='" + name + '\'' +
                ", hitPts=" + hitPts +
                ", strength=" + strength +
                '}';
    }

    @Override
    public List<String> write() {
        ArrayList<String> values = new ArrayList<String>();
            values.add(0, this.name);
            values.add(1,""+this.hitPts);
            values.add(2,""+this.strength);
            return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues!=null&&savedValues.size()>0){
            this.name=savedValues.get(0);
            this.hitPts=Integer.parseInt(savedValues.get(1));
            this.strength=Integer.parseInt(savedValues.get(2));
        }
    }
}
