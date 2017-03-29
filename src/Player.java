import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel Krowicki on 27.03.2017.
 */
public class Player implements ISave {
    private String name;
    private int hitPts;
    private int strength;
    private String weapon;

    public Player(String name, int hitPts, int strength) {
        this.name = name;
        this.hitPts = hitPts;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPts() {
        return hitPts;
    }

    public void setHitPts(int hitPts) {
        this.hitPts = hitPts;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPts=" + hitPts +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, ""+this.hitPts);
        values.add(2,""+this.strength);
        values.add(3,this.weapon);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues!=null&&savedValues.size()>0){
            this.name = savedValues.get(0);
            this.hitPts = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }
    }
}
