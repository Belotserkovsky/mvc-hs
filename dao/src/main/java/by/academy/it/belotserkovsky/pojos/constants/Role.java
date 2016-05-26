package by.academy.it.belotserkovsky.pojos.constants;

/**
 * Created by K.Belotserkovsky
 */
public enum Role {
    USER("пользователь"),
    ADMIN("администратор"),
    ANONYMOUS("аноним");

    private final String type;

    Role(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
