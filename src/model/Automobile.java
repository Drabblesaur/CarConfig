package model;

import java.io.Serializable;
import java.util.ArrayList;
public class Automobile implements Serializable {
    //State
    private String make;
    private String model;
    private int year;
    private int baseprice;
    private ArrayList<OptionSet> opset;
    private ArrayList<OptionSet.Option> cchoice;

    //Constructor
    public Automobile() {
        opset = new ArrayList<>();
        cchoice = new ArrayList<>();
    }
    //Behaviors
    //Getters
    public String getName() {
    	String name;
    	name = year +" "+ make +" "+ model;
    	return name;
    }
    public String getMake(){return make;}
    public String getModel(){
        return model;
    }
    public int getYear(){return year;}
    public int getBasePrice(){
        return baseprice;
    }
    public int getOptionSetSize(){
        return opset.size();
    }
    public String getOptionSetname(int i){
        return opset.get(i).getOptionSetName();
    }
    public int getOptionsize(String n){
        return findOptionSet(n).getOptionSize();
    }
    public String getOptionName(String n, int i) {
    	return findOptionSet(n).getOptionName(i);
    }
    public float getOptionPrice(String n, int i) {
    	return findOptionSet(n).getOptionPrice(i);
    }
    public String getOptionChoice(String Opsetname){
        return findOptionSet(Opsetname).getChoice().getName();
    }
    public float getOptionChoicePrice(String Opsetname ){
        return findOptionSet(Opsetname).getChoice().getPrice();

    }
    public float getTotalPrice(){
        int total = baseprice;
        for (int i=0; i<cchoice.size(); i++){
            total += cchoice.get(i).getPrice();
        }
    return total;
    }
    public String getAutoKey(){
        String year = Integer.toString(getYear());
        String make = getMake();
        String model1;
        if(getModel().contains("")){
             model1 = getModel().replaceAll("\\s+","");
        }else{ model1 = getModel();}
        String autoKey = year+make+model1;
        System.out.println(autoKey);

    return autoKey;
    }
    //Find
    public synchronized OptionSet findOptionSet(String name){
        for (OptionSet anOpset : opset) {
            if (anOpset.getOptionSetName().equals(name)) {
                return anOpset;
            }
        }
        return null;
    }
    public synchronized int findOptionSetindex(String name){
        for (OptionSet anOpset : opset) {
            if (anOpset.getOptionSetName().equals(name)) {
                return opset.indexOf(anOpset);
            }
        }
        return 0;
    }
    public OptionSet.Option findOption(String OPSname, String Oname){
        	return findOptionSet(OPSname).findOption(Oname);
    }
    //Setter
    public void setMake(String make){this.make = make;}
    public void setModel(String model){
        this.model = model;
    }
    public void setYear(int year){this.year = year;}
    public void setBasePrice(int baseprice){
        this.baseprice = baseprice;
    }
    public void setOpset(String n, int size) {
            OptionSet optionset = new OptionSet(n, size);
            opset.add(optionset);
    }
    public void setOption(String OPSETName, String n, float price) {
        opset.get(opset.indexOf(findOptionSet(OPSETName))).setOption(n, price);
    }
    public void setOptionChoice(String opsetName, String optionName){
        findOptionSet(opsetName).setChoice(findOptionSet(opsetName).findOption(optionName));
        cchoice.add(findOptionSet(opsetName).getChoice());

    }
    //Update
    public void updateOpset(String oldname, String newname){
        int index = opset.indexOf(findOptionSet(oldname));
        OptionSet newoptionset = new OptionSet(newname, getOptionsize(oldname));
        newoptionset.setOpt(findOptionSet(oldname).getOpt());
        opset.add(index,newoptionset);
        deleteOpset(index+1);

    }
    public synchronized void updateOption(String OPSETname, String oldname,String newname,float newprice){
        int index = findOptionSetindex(OPSETname);
        opset.get(index).updateOption(oldname,newname,newprice);
    }
    //Delete
    public void deleteOpset(int index){
        opset.remove(index);

    }
    public void deleteOption(int opsetindex,int optindex){
        opset.get(opsetindex).deleteOption(optindex);
    }
    //Print
    public void print(){
        System.out.println("YEAR: "+ getYear());
        System.out.println("MAKE: "+ getMake());
        System.out.println("NAME: "+ getModel());
        System.out.println("BASE PRICE:$"+getBasePrice());
        for (OptionSet anOpset : opset) {
            anOpset.print();
        }

    }
    public void printChoice(){
        System.out.println("===== CHOICE CONFIG INFO =====");
        System.out.println("YEAR: "+ getYear());
        System.out.println("MAKE: "+ getMake());
        System.out.println("NAME: "+ getModel());
        System.out.println("BASE PRICE:$"+getBasePrice());
        for (OptionSet anOpset : opset) {
            System.out.println("-----" + anOpset.getOptionSetName()+"-----");
            System.out.println("CHOICE: " + anOpset.getChoice().getName());
            System.out.println("PRICE: "+ anOpset.getChoice().getPrice());
        }
        System.out.println("TOTAL PRICE:" + getTotalPrice());
    }
}
