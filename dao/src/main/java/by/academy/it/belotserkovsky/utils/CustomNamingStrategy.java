package by.academy.it.belotserkovsky.utils;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * Created by Kostya on 22.04.2016.
 */
public class CustomNamingStrategy extends DefaultNamingStrategy {
    public String classToTableName(String className) {
        return "T_" + super.classToTableName(className).toUpperCase();
    }

    public String propertyToColumnName(String propName) {
        return "F_" + super.propertyToColumnName(propName);
    }

    public String columnName(String columnName) {
        return columnName;
    }

    public String tableName(String tableName) {
        return tableName;
    }
}
