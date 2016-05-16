package by.academy.it.belotserkovsky.exceptions;

/**
 * Exception by Dao
 * Created by Kostya on 22.04.2016.
 */

public class ExceptionDao extends Exception{

    private Exception exception;

    public ExceptionDao(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
