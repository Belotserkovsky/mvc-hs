package by.academy.it.belotserkovsky.pojos.constants;

/**
 * Created by K.Belotserkovsky
 */
public enum DesiredRuntime {
    TODAY("сегодня"),
    TOMOROW_AFTER_LUNCH("завтра, первая половина дня"),
    TOMOROW_BEFORE_LUNCH("завтра, вторая половина дня");

    private final String type;

    DesiredRuntime(String type){
        this.type = type;
    }
}
