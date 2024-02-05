/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume firstResume = new Resume();
        firstResume.setUUID("uuid1");
        Resume secondResume = new Resume();
        secondResume.setUUID("uuid2");
        Resume thirdResume = new Resume();
        thirdResume.setUUID("uuid3");

        ARRAY_STORAGE.save(firstResume);
        ARRAY_STORAGE.save(secondResume);
        ARRAY_STORAGE.save(thirdResume);

        System.out.println("Get first resume: " + ARRAY_STORAGE.get(firstResume.getUUID()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(firstResume.getUUID());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAll()) {
            System.out.println(resume);
        }
    }
}
