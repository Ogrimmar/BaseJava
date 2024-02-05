import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static final int SIZE = 10_000;
    Resume[] storage = new Resume[SIZE];
    private int currentSize;

    void clear() {
        for (int index = 0; index < currentSize; index++) {
            storage[index] = null;
        }
    }

    void save(Resume newResume) {
        if (newResume != null) {
            storage[currentSize++] = newResume;
        } else {
            throw new NullPointerException();
        }
    }

    Resume get(String uuid) {
        if (uuid == null) {
            return null;
        }

        for (int index = 0; index < currentSize; index++) {
            Resume tempResume = storage[index];
            if (tempResume.getUUID().equals(uuid)) {
                return tempResume;
            }
        }

        return null;
    }

    void delete(String uuid) {
        if (uuid == null) {
            return;
        }

        int deleteIndex = SIZE;
        for (int index = 0; index < currentSize; index++) {
            if (storage[index].getUUID().equals(uuid)) {
                deleteIndex = index;
            }
            if (index > deleteIndex) {
                storage[index - 1] = storage[index];
            }
        }

        currentSize--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, currentSize);
    }

    int size() {
        return currentSize;
    }
}
