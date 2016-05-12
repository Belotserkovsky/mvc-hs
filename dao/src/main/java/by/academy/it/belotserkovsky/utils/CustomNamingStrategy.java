package by.academy.it.belotserkovsky.utils;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * Naming of tables and columns in the database strategy
 * Created by K.Belotserkovsky
 */
public class CustomNamingStrategy extends DefaultNamingStrategy {

    /**
     * @param className
     * @return String table name
     */
    public String classToTableName(String className) {

        return "T_" + super.classToTableName(className).toUpperCase();
    }

    /**
     * @param propName
     * @return String column name
     */
    public String propertyToColumnName(String propName) {
        return "F_" + super.propertyToColumnName(propName).toUpperCase();
    }

    /**
     * @param columnName
     * @return columnName
     */
    public String columnName(String columnName) {
        return columnName;
    }

    /**
     * @param tableName
     * @return tableName
     */
    public String tableName(String tableName) {
        return tableName;
    }
}
