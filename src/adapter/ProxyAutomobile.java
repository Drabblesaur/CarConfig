package adapter;

import exception.AutoException;
import model.Automobile;
import scale.EditHelper;
import util.FileIO;
import scale.EditOptions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import client.*;

import client.CarModelOptionsIO;

public abstract class ProxyAutomobile {
    private static Automobile a1 = new Automobile();
    private static LinkedHashMap <String,Automobile> autoMap = new LinkedHashMap<>();

    public void buildAuto(Object obj) {
        Automobile a3 = new Automobile();
        FileIO a2 = new FileIO();
        a3 = a2.buildAutoObjectProp(a3,obj);
        autoMap.put(a3.getAutoKey(),a3);
    }
    public void printAuto(String modelkey) {
        autoMap.get(modelkey).print();
    }
    public Automobile sendAuto(Object obj){
        String modelname = (String) obj;
        return autoMap.get(modelname);
    }
    public void loadAuto (String fname) {
    	CarModelOptionsIO caropt = new CarModelOptionsIO();
    	  buildAuto(caropt.loadPropsFile(fname));
    }
    public void updateOptionSetName(String modelkey, String OptionSetName, String newName) {
        autoMap.get(modelkey).updateOpset(OptionSetName,newName);
    }
    public void updateOptionPrice(String modelkey, String OptionSetName, String oldOption, String newOption, float newprice) {
        autoMap.get(modelkey).updateOption(OptionSetName, oldOption, newOption, newprice);
    }
    public boolean checkKey(String Id){
        boolean exist;
        if(autoMap.containsKey(Id)) {
            exist = true;
        } else {
            exist = false;
        }
    return exist;
    }
    public Automobile getAuto(String modelkey) {
    	return autoMap.get(modelkey);
    }
    public List getAllModels(){
        List<String> keyname = new ArrayList<>(autoMap.keySet());
        List<String> modelname = new ArrayList<>();;
        for(int i = 0; i<keyname.size();i++){
            modelname.add(autoMap.get(keyname.get(i)).getName());
        }
        return modelname;
    }
    public List getAllKeys() {
    	 List<String> keyname = new ArrayList<>(autoMap.keySet());
    	 return keyname;
    }
    public void pickOptionChoice(String modelkey, String opsetname, String optionname ){
        autoMap.get(modelkey).setOptionChoice(opsetname,optionname);
    }
    public void getTotalPrice(String modelkey){
        float total = autoMap.get(modelkey).getTotalPrice();
        System.out.println("TOTAL:" + total);
    }
    public void fix(int errNumber) {
        AutoException e = new AutoException();
        e.fix(a1, errNumber);
    }
    public void editopt(String modelkey){
        EditOptions c1 = new EditOptions(autoMap.get(modelkey));
        EditHelper t1 = new EditHelper(0, c1);
        EditHelper t2 = new EditHelper(1, c1);
        t1.start();
        t2.start();
    }
    public boolean isProperty(Object obj) {
        boolean isProperty = false;

        try {
            Properties a1 = (Properties) obj;
            isProperty = true;
        }
        catch (ClassCastException e) {
            isProperty = false;
        }

        return isProperty;
    }
    public boolean isStringBuffer(Object obj){
        boolean isStringBuffer = false;

        try {
            StringBuffer a1 = (StringBuffer) obj;
            isStringBuffer = true;
        }
        catch (ClassCastException e) {
            isStringBuffer = false;
        }

        return isStringBuffer;
    }

}