package br.com.fiap.challenge03.exception;

public class DataIntegretyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegretyException(String msg) {
        super(msg);
    }

    public DataIntegretyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
