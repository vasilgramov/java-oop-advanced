package p02_streamProgressInfo.models;

public class File extends BaseStream{

    private String name;

    public File(String name, int length, int byteSent) {
        super(length, byteSent);
        this.name = name;
    }
}
