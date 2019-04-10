package exception;

import model.Automobile;
import util.FileIO;

public class AutoException extends Exception {
    private int errNumber;
    private String errName;

    public AutoException() {
        super();
        LogException();
    }

    public AutoException(String errName) {
        super();
        this.errName = errName;
        LogException();
    }

    public AutoException(int errNumber) {
        super();
        this.errNumber = errNumber;
        LogException();
    }

    public AutoException(int errNumber, String errName) {
        super();
        this.errNumber = errNumber;
        this.errName = errName;
        LogException();
    }

    public int getErrNumber() {
        return errNumber;
    }

    public void setErrNumber(int errNumber) {
        this.errNumber = errNumber;
    }

    public String getErrName() {
        return errName;
    }

    public void setErrName(String errName) {
        this.errName = errName;
    }

    public void LogException() {
        FileIO f1 = new FileIO();
        f1.logException(errNumber, errName);
    }

    public void fix(Automobile a, int errNumber) {
        Mechanic1to100 m1 = new Mechanic1to100();
        Mechanic101to200 m2 = new Mechanic101to200();
        switch (errNumber) {
            case 1:
                m1.fix1();
                break;
            case 2:
                m1.fix2();
                break;
            case 3:
                m1.fix3();
                break;
            case 4:
                m1.fix4();
                break;
            case 5:
                m1.fix5();
                break;
            case 101:
                m2.fix101(a);
                break;
            case 102:
                m2.fix102(a);
                break;
            case 103:
                m2.fix103(a);
                break;
            case 104:
                m2.fix104(a);
                break;
            case 105:
                m2.fix105(a);
                break;
            case 106:
                m2.fix106(a);
                break;
            case 107:
                m2.fix107(a);
                break;
        }
    }
}
