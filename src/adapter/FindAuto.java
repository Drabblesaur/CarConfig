package adapter;

import java.util.List;
import model.Automobile;

public interface FindAuto {
    public boolean checkKey(String Id);
    public Automobile getAuto(String modelkey);
    public List getAllModels();
    public List getAllKeys();
}
