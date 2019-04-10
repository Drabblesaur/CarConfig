package adapter;

public interface UpdateAuto {
    public void updateOptionSetName(String Modelname, String OptionSetName, String newName);
    public void updateOptionPrice(String Modelname, String OptionSetName, String oldOption, String newOption, float newprice);
}
