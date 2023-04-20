package components.patterns;

public interface IDReaderObserver extends Observer
{
    void readerUpdated(String readerType, String id);
}
