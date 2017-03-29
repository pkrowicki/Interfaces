import java.util.List;

/**
 * Created by Pawel Krowicki on 27.03.2017.
 */
public interface ISave {
    List<String> write();
    void read(List<String> savedValues);
}
