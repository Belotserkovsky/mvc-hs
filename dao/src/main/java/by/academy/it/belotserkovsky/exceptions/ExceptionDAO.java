package by.academy.it.belotserkovsky.exceptions;

/**
 * Exception by DAO
 * Created by Kostya on 22.04.2016.
 */

public class ExceptionDAO extends Exception{

    private Exception exception;

    public ExceptionDAO (Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
