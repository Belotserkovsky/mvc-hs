package by.academy.it.belotserkovsky.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by K.Belotserkovsky
 */
public class CustomNamingStrategyTest {
    CustomNamingStrategy cns = new CustomNamingStrategy();

    @Test
    public void classToTableName() throws Exception {
        String result = cns.classToTableName("table");
        assertNotNull(result);
    }

    @Test
    public void propertyToColumnName() throws Exception {
       String result = cns.propertyToColumnName("column");
        assertNotNull(result);
        assertEquals("F_COLUMN", result);

    }

    @Test
    public void columnName() throws Exception {
        String result = cns.columnName("columnName");
        assertNotNull(result);
    }

    @Test
    public void tableName() throws Exception {
        String result = cns.tableName("tableName");
        assertNotNull(result);

    }

}