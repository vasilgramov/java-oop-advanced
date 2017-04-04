package p02_streamProgressInfo;

import p02_streamProgressInfo.models.File;

public class Main {

    public static void main(String[] args) {
        StreamProgressInfo streamProgressInfo = new StreamProgressInfo(new File("peshp", 2048, 512));
        System.out.println(streamProgressInfo.calculateCurrentPercent());
    }
}
