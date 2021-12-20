package ModelComponents;

public class ComplexNumber {
    private int realComponent;
    private int imagComponent;

    public ComplexNumber(int rc, int cc) {
        realComponent = rc;
        imagComponent = cc;
    }

    /** Getters */
    public int getRealComponent() {
        return realComponent;
    }

    public int getImagComponent() {
        return imagComponent;
    }

    /** Setters */
    public void setRealComponent(int r) {
        realComponent = r;
    }

    public void setImagComponent(int c) {
        imagComponent = c;
    }
}
