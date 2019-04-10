package adapter;

import model.Automobile;

public interface CreateAuto {
    public void buildAuto (Object obj);
    public void printAuto (String modelname);
    public Automobile sendAuto (Object obj);
    public void loadAuto(String fname);
}
