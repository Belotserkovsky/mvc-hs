package by.academy.it.belotserkovsky.pojos.constants;

/**
 * Created by K.Belotserkovsky
 */
public enum DesiredRuntime {
    TODAY("сегодня"),
    TOMORROW_AFTER_LUNCH("завтра, первая половина дня"),
    TOMORROW_BEFORE_LUNCH("завтра, вторая половина дня");

    private final String type;

    DesiredRuntime(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
