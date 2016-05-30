package by.academy.it.belotserkovsky.pojos.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
public enum KindOfWork {
    ELECTRICIAN("электротехнические"),
    PLUMBER("сантехнические"),
    WELDING("сварочные"),
    DECORATION("отделочные");

    private final String type;

    KindOfWork(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
