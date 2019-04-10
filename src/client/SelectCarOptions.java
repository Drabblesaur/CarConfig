
package client;

import model.*;
import java.util.*;

public class SelectCarOptions {

	////////// PROPERTIES //////////
	private Scanner in = new Scanner(System.in);

	////////// CONSTRUCTORS //////////

	public SelectCarOptions() {

	}

	////////// INSTANCE METHODS //////////

	public void configureAuto(Object obj) {
	    boolean finished = false;
	    Scanner input = new Scanner(System.in);
	    input.useDelimiter("\\n");
	    Automobile autoobj = (Automobile) obj;
	    autoobj.print();
	    int OPSammnt = autoobj.getOptionSetSize();
	    for(int i= 0; i<OPSammnt; i++){
	        String Opsetname = autoobj.getOptionSetname(i);
	        System.out.println(Opsetname + " Choice?");
	        String Choice = input.next();
	        autoobj.setOptionChoice(Opsetname,Choice);
        }
        autoobj.printChoice();
	}

	public boolean isAutomobile(Object obj) {
		boolean isAutomobile = false;

		try {
			Automobile a1 = (Automobile) obj;
			isAutomobile = true;
		}
		catch (ClassCastException e) {
			isAutomobile = false;
		}

		return isAutomobile;
	}

}
