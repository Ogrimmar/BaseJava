/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String uuid) {
        if (uuid != null) {
            this.uuid = uuid;
        }
    }

    @Override
    public String toString() {
        return "Unique User Identifier: " + uuid;
    }
}
