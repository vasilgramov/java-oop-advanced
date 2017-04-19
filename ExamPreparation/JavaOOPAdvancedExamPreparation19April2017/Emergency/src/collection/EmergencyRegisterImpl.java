package collection;

public class EmergencyRegisterImpl<T> implements EmergencyRegister<T> {

    private static final Integer INITIAL_SIZE = 16;

    private T[] emergencyQueue;

    private Integer currentSize;

    private Integer nextIndex;

    private int size;

    public EmergencyRegisterImpl() {
        this.emergencyQueue = (T[]) new Object[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[2 * this.currentSize];

        for (int i = 0; i < this.currentSize; i++) {
            newArray[i] = this.emergencyQueue[i];
        }

        this.emergencyQueue = newArray;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void enqueueEmergency(T emergency) {
        this.size++;

        this.checkIfResizeNeeded();

        this.emergencyQueue[this.nextIndex] = emergency;
        this.incrementNextIndex();

        this.incrementCurrentSize();
    }

    @Override
    public T dequeueEmergency() {
        this.size--;

        T removedElement = this.emergencyQueue[0];

        for (int i = 0; i < this.currentSize - 1; i++) {
            this.emergencyQueue[i] = this.emergencyQueue[i + 1];
        }

        this.decrementNextIndex();
        this.decrementCurrentSize();

        return removedElement;
    }

    @Override
    public T peekEmergency() {
        T peekedElement = this.emergencyQueue[0];
        return peekedElement;
    }

    @Override
    public Boolean isEmpty() {
        return this.currentSize == 0;
    }

    private void incrementNextIndex() {
        this.nextIndex++;
    }

    private void decrementNextIndex() {
        this.nextIndex--;
    }

    private void incrementCurrentSize() {
        this.currentSize++;
    }

    private void decrementCurrentSize() {
        this.currentSize--;
    }

    private void checkIfResizeNeeded() {
        if(this.currentSize == this.emergencyQueue.length) {
            this.resize();
        }
    }
}
