package util;

import exception.AutoException;
import model.Automobile;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class FileIO implements Serializable {

    public FileIO(){}
    public Automobile buildAutoObjectProp(Automobile a1,Object propFile){
        Properties autoprop = (Properties) propFile;
            try{
                String makename = autoprop.getProperty("makename");
                if(makename.isEmpty()) {
                    throw new AutoException(101, "Make Not Found");
                }else{a1.setMake(makename);}
            }catch(AutoException e){e.fix(a1,101);}
        try{
            String modelname = autoprop.getProperty("modelname");
            if(modelname.isEmpty()) {
                throw new AutoException(102, "Model Not Found");
            }else{a1.setModel(modelname);}
        }catch(AutoException e){e.fix(a1,102);}
            try{
                String Syear =autoprop.getProperty("Syear");
                if (Syear.isEmpty()){
                    throw new AutoException(103,"Year Not Found");
                }else{
                    a1.setYear(Integer.parseInt(Syear));
                }
            }catch (AutoException e){e.fix(a1,103);}
        try{
            String Sbaseprice =autoprop.getProperty("Sbaseprice");
            if (Sbaseprice.isEmpty()){
                throw new AutoException(104,"Base Price Not Found");
            }else{
                a1.setBasePrice(Integer.parseInt(Sbaseprice));
            }
        }catch (AutoException e){e.fix(a1,104);}
            int opsetanmmnt = Integer.parseInt(autoprop.getProperty("opsetanmmnt"));
            for(int i=0; i<opsetanmmnt; i++) {
                try{
                String OPSETn = autoprop.getProperty(i+"OPSETn");
                String Sopsetsize = autoprop.getProperty(i+"Sopsetsize");
                    if(OPSETn.isEmpty() || Sopsetsize.isEmpty()){
                        throw new AutoException(105,"OPSET Missing");
                    }else{a1.setOpset(OPSETn,Integer.parseInt(Sopsetsize));
                    try{
                        for (int j = 0; j < Integer.parseInt(Sopsetsize); j++) {
                            String OPTIONn = autoprop.getProperty(i+"OPTIONn"+j);
                            String Sprice = autoprop.getProperty(i+"Sprice"+j);
                            if (OPSETn.isEmpty() || Sprice.isEmpty()){
                                throw new AutoException(106,"Option Missing");
                            }else{
                                a1.setOption(OPSETn,OPTIONn,Float.parseFloat(Sprice));
                            }
                        }
                    }catch(AutoException e){
                        e.fix(a1,106);
                    }
                    }
                }catch (AutoException e){e.fix(a1,105);}
            }
        return a1;
    }
    /*
    public Automobile buildAutoObjectSB(Automobile a1, Object stringBuff){
        StringBuffer autoString = (StringBuffer) stringBuff;
        String[] lines = autoString.toString().split("\\n");
        try{
            try{
                String makename = lines[0];
                if(makename.isEmpty()) {
                    throw new AutoException(101, "Make Not Found");
                }else{a1.setMake(makename);}
            }catch(AutoException e){e.fix(a1,101);}
            try{
                String modelname = lines[1];
                if(modelname.isEmpty()) {
                    throw new AutoException(102, "Model Not Found");
                }else{a1.setModel(modelname);}
            }catch(AutoException e){e.fix(a1,102);}
            try{
                String Syear = lines[2];
                if (Syear.isEmpty()){
                    throw new AutoException(103,"Year Not Found");
                }else{
                    a1.setYear(Integer.parseInt(Syear));
                }
            }catch (AutoException e){e.fix(a1,103);}
            try{
                String Sbaseprice = lines[3];
                if (Sbaseprice.isEmpty()){
                    throw new AutoException(104,"Base Price Not Found");
                }else{
                    a1.setBasePrice(Integer.parseInt(Sbaseprice));
                }
            }catch (AutoException e){e.fix(a1,104);}
            int opsetanmmnt = Integer.parseInt(lines[4]);
            for(int i=0; i<opsetanmmnt; i++) {
                try{
                    String OPSETn = buff.readLine();
                    String Sopsetsize = buff.readLine();
                    if(OPSETn.isEmpty() || Sopsetsize.isEmpty()){
                        throw new AutoException(105,"OPSET Missing");
                    }else{a1.setOpset(OPSETn,Integer.parseInt(Sopsetsize));
                        try{
                            for (int j = 0; j < Integer.parseInt(Sopsetsize); j++) {
                                String OPTIONn = buff.readLine();
                                String  Sprice = buff.readLine();
                                if (OPSETn.isEmpty() || Sprice.isEmpty()){
                                    throw new AutoException(106,"Option Missing");
                                }else{
                                    a1.setOption(OPSETn,OPTIONn,Float.parseFloat(Sprice));
                                }
                            }
                        }catch(AutoException e){
                            e.fix(a1,106);
                        }
                    }
                }catch (AutoException e){e.fix(a2,105);}
            }
        }catch(FileNotFoundException e){
            try{
                throw new AutoException(107,"File Not Found");
            }catch(AutoException w){
                w.fix(a2,107);
            }
        }
        catch (IOException e){}
        return a2;
    }
    */
    public void logException(int errNumber, String errName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Exception.txt"));
            writer.append(String.format("[%s] Code %d: %s", dateFormat.format(date), errNumber, errName));
            writer.newLine();
            writer.close();
        } catch (IOException e) {

        }
    }

}