package by.academy.it.belotserkovsky.pojos.constants;

/**
 * Created by K.Belotserkovsky
 */
public enum Status {
    OPEN("открыта"),
    CLOSE("закрыта"),
    PENDING("в ожидании");

    private final String type;

    Status(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
