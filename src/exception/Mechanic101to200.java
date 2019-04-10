package exception;

import model.Automobile;

import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Mechanic101to200 {
    Scanner input = new Scanner(System.in);
    // Fixes Error Codes 101-200 (File IO Exceptions)
    public void fix101(Automobile a){
        System.out.println("Make Name?");
        String line = input.nextLine();
        a.setMake(line);
    }
    public void fix102(Automobile a) {
        //missing model name
        input.useDelimiter("\\n");
        System.out.println("Model Name?");
        String line1 = input.next();
        a.setModel(line1);
    }
    public void fix103(Automobile a) {
        System.out.println(" Year made?");
        int year = input.nextInt();
        a.setYear(year);
    }
    public void fix104(Automobile a) {
        //missing price
        System.out.println("Base Price?");
        int baseprice = input.nextInt();
        a.setBasePrice(baseprice);
    }
    public void fix105(Automobile a) {
        //missing OPSET
        input.useDelimiter("\\n");
        System.out.println("OpSet Name?");
        String name = input.next();
        System.out.println("How Many Options?");
        int size = input.nextInt();
        a.setOpset(name,size);
    }
    public void fix106(Automobile a) {
        //missing option
        input.useDelimiter("\\n");
        System.out.println("OpSet Name?");
        String opname = input.next();
        System.out.println("Option Name?");
        String oname = input.next();
        System.out.println("Option Price?");
        Float price = input.nextFloat();
    }
    public void fix107(Automobile a) {
        //can't find file
        input.useDelimiter("\\n");
        System.out.println("File Not Found");
        System.out.println("Switching to User Input");
        System.out.println("Make Name?");
        String line = input.next();
        a.setMake(line);
        System.out.println("Model Name?");
        String line1 = input.next();
        a.setModel(line1);
        System.out.println("Year made?");
        int year = input.nextInt();
        a.setYear(year);
        System.out.println("Base Price?");
        int baseprice = input.nextInt();
        a.setBasePrice(baseprice);
        System.out.println("How Many Option Set?");
        int opsize = input.nextInt();
        for(int b =0; b<opsize; b++) {
            System.out.println("OpSet Name?");
            String opname = input.next();
            System.out.println("How Many Options?");
            int size = input.nextInt();
            a.setOpset(opname, size);
            for (int i = 0; i < size; i++) {
                System.out.println("Option Name?");
                String oname = input.next();
                System.out.println("Option Price?");
                Float price = input.nextFloat();
                a.setOption(opname,oname,price);
            }
        }

    }
}
