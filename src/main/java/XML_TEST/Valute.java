package XML_TEST;

public class Valute {

    private String valCode;

    private String valName;

    private double valValue;

    public Valute() {
    }

    public Valute(String valCode, String valName, double valValue) {
        this.valCode = valCode;
        this.valName = valName;
        this.valValue = valValue;
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    public String getValName() {
        return valName;
    }

    public void setValName(String valName) {
        this.valName = valName;
    }

    public double getValValue() {
        return valValue;
    }

    public void setValValue(double valValue) {
        this.valValue = valValue;
    }
}
