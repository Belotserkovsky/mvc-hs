package by.academy.it.belotserkovsky.pojos.constants;

/**
 * Created by K.Belotserkovsky
 */
public enum Role {
    USER("USER"),
    ADMIN("ADMIN"),
    ANONYMOUS("ANONYMOUS");

    private final String type;

    Role(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
