package collection;

/**
 * Created by vladix on 4/18/17.
 */
public interface EmergencyRegister<T> {

    int size();

    void enqueueEmergency(T emergency);

    T dequeueEmergency();

    T peekEmergency();

    Boolean isEmpty();
}
