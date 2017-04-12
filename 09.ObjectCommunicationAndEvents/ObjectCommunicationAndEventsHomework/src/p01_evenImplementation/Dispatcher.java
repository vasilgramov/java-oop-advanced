package p01_evenImplementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladix on 4/12/17.
 */
public class Dispatcher {

    private String name;

    public void changeName(String name) {
        System.out.println(String.format("Dispatcher's name changed to %s.", name));
        this.name = name;
    }
}
