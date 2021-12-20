package ModelComponents;

public class Row {
    ComplexNumber[] rowValues;

    public Row(ComplexNumber[] values) {
        rowValues = values;
    }

    public String getElement(int indx) {
        if (indx == 0 || indx == 2 || indx == 4) {
            return rowValues[indx/2].getRealComponent() + "";

        } else {
            return rowValues[indx/2].getImagComponent() + "";
        }
    }
}
