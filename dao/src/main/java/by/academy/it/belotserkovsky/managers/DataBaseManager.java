package by.academy.it.belotserkovsky.managers;

import java.util.ResourceBundle;

/**
 *
 * Created by Kostya on 12.04.2016.
 */
public class DataBaseManager {

    private final static ResourceBundle resourceBundle =
            ResourceBundle.getBundle("resources.mysql");

    private DataBaseManager () {}

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
