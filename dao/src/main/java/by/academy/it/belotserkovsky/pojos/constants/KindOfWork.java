package by.academy.it.belotserkovsky.pojos.constants;

/**
 * Created by K.Belotserkovsky
 */
public enum KindOfWork {
    ELECTRICIAN("Электротехнические"),
    PLUMBER("Сантехнические"),
    WELDING("Сварочные"),
    DECORATION("Отделоччные");

    private final String type;

    KindOfWork(String type) {
        this.type = type;
    }

}
