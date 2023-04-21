package components.IDreader;

public class BarcodeReader extends IDReader
{
    public String getID() {
        return super.getID("Barcode");
    }
}
