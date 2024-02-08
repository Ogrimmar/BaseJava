import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static final int SIZE = 10_000;
    Resume[] storage = new Resume[SIZE];
    private int currentSize;

    void clear() {
        for (int i = 0; i < currentSize; i++) {
            storage[i] = null;
        }
        currentSize = 0;
    }

    void save(Resume newResume) {
        if (newResume != null) {
            storage[currentSize++] = newResume;
        }
    }

    Resume get(String uuid) {
        if (uuid == null) {
            return null;
        }

        for (int i = 0; i < currentSize; i++) {
            if (storage[i].getUUID().equals(uuid)) {
                return storage[i];
            }
        }

        return null;
    }

    void delete(String uuid) {
        if (uuid == null) {
            return;
        }

        int deleteIndex = SIZE;
        for (int i = 0; i < currentSize - 1; i++) {
            if (storage[i].getUUID().equals(uuid)) {
                storage[i] = null;
            }
            if (storage[i] == null) {
                storage[i] = storage[i + 1];
                storage[i + 1] = null;
            }
        }
        storage[--currentSize] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, currentSize);
    }

    int size() {
        return currentSize;
    }
}
