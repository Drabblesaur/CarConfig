package scale;

public class EditHelper extends Thread {
	int x;
	EditOptions x1;
	int threadno;

	public EditHelper(int x, EditOptions x1) {
		this.x = x;
		threadno = x;
		this.x1 = x1;
	}

	public void run() {
		switch (x) {
		case 0:
			System.out.println("Start thread " + threadno + " blu()");
			break;
		case 1:
			System.out.println("Start thread " + threadno + " bluish()");
			break;
		}
		ops();
		System.out.println("Stopping thread " + threadno);

	}

	public void ops() {
		switch (x) {
			case 0:
				x1.blu();
				break;
			case 1:
				x1.bluish();
				break;
		}
	}
}
