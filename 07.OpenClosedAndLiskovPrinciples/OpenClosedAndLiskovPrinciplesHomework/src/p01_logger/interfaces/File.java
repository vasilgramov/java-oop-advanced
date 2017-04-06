package p01_logger.interfaces;

public interface File {
    void write(String message);

    StringBuilder getMessages();

    int getSize();
}
