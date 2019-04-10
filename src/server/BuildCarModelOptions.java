

package server;

import adapter.*;

public class BuildCarModelOptions extends ProxyAutomobile {

	////////// PROPERTIES //////////
    private BuildAuto a4 = new BuildAuto();
	private static final int WAITING = 0;
	private static final int REQUEST_BUILD_AUTO = 1;
	private static final int REQUEST_CONFIGURE_AUTO = 2;
	private int state = WAITING;

	////////// CONSTRUCTORS //////////

	public BuildCarModelOptions() {
	}

	////////// INSTANCE METHODS //////////

	public Object processRequest(Object obj){
		Object toClient = null;
		if (state == REQUEST_BUILD_AUTO) {
			if(isProperty(obj)){
				a4.buildAuto(obj);
			}else if(isStringBuffer(obj)){

			}
			toClient = "Automobile object successfully added to database\n"
					+ "Press any key to return to main menu";
		}
		else if (state == REQUEST_CONFIGURE_AUTO) {
			toClient = a4.sendAuto(obj);
		}
		else {
		}
		this.state = WAITING;
		return toClient;
	}

	public String setRequest(int i) {
		String output = null;

		if (i == 1) {
			this.state = REQUEST_BUILD_AUTO;
			output = "Upload a file to create an Automobile";
		}
		else if (i == 2) {
			this.state = REQUEST_CONFIGURE_AUTO;
			output = "Select an Automobile from the following list to configure: \n"+
					super.getAllKeys();

		}
		else {
			output = "Invalid request";
		}

		return output;
	}


}
