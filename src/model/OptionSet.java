package model;

import java.io.Serializable;
import java.util.ArrayList;

class OptionSet implements Serializable {
    class Option implements Serializable {
        private String name;
        private float price;

        Option() {
            super();
        }
        protected String getName(){
            return name;
        }
        protected float getPrice(){
            return price;
        }
        protected synchronized void setName(String name){
            this.name = name;
        }
        protected synchronized void setPrice(Float price){
            this.price = price;

        }
        protected void print(){
            System.out.println(name+", $"+price);
        }
    }

    //State
    private String name;
    private ArrayList<Option> opt;
    private Option choice = new Option();

    protected Option getChoice() {
        return choice;
    }

    protected void setChoice(Option choice) {
        this.choice = choice;
    }

    OptionSet(String n,int size2){
        name = n;
        opt = new ArrayList<>(size2);
    }
    
    protected String getOptionName(int i) {
    	return opt.get(i).getName();
    }
    protected float getOptionPrice(int i) {
    	return opt.get(i).getPrice();
    }
    protected String getOptionSetName(){
        return name;
    }
    protected int getOptionSize(){
        return opt.size();
    }
    protected ArrayList<Option> getOpt(){
        return opt;
    }
    protected int getOptindex(String name){
        return opt.indexOf(findOption(name));
    }
    protected void setOpt(ArrayList<Option> newopt){
        this.opt=newopt;
    }
    protected void setOption(String n, float price){
        Option option = new Option();
        option.setName(n);
        option.setPrice(price);
        opt.add(option);
    }
    protected Option findOption(String name){
        for (Option anOpt : opt) {
            if (anOpt.name.equals(name)) {
                return anOpt;
            }
        }
        return null;
    }
    protected synchronized void updateOption(String oldname,String newname,float newprice){
        Option noption = new Option();
        noption.setName(newname);
        noption.setPrice(newprice);
        int index = opt.indexOf(findOption(oldname));
        System.out.println("Option index:"+index);
        if(index>=0){
        opt.add(index,noption);
        deleteOption(index+1);
        }
    }
    protected void deleteOption(int index){
        opt.remove(index);
    }
    protected void print(){
        System.out.println("___________");
        System.out.println("OPSET NAME:"+name);
        System.out.println("OPTIONS");
        for (Option anOpt : opt) {
            anOpt.print();
        }

    }
}

