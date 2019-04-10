package scale;

import model.Automobile;

public class EditOptions{
    private Automobile automobile;
    private boolean changed = false;

    public EditOptions(Automobile Auto){
        this.automobile = Auto;
    }

    private synchronized void editOptionName(String OPSETname, String oldname, String newname, float price ) {
        automobile.updateOption(OPSETname, oldname, newname, price);
    }

    public synchronized void blu() {
        try {
           while (!changed) {
                System.out.println("Starting blu()");
                Thread.currentThread().sleep(5000);
                editOptionName("Color", "Blue", "blu", 0);
                changed = true;
           }

        } catch (InterruptedException e) {
        }
    }

    public synchronized void bluish(){
        while (!changed) {
            System.out.println("Starting bluish()");
            editOptionName("Color", "Blue", "bluish", 0);
            changed = true;
        }
        }

    }

