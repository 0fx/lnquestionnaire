package space.nyuki.lncommon.exception;

/**
 * @author ning
 * @createTime 2019/9/3 下午1:30
 * @description
 */
public class FormatNotCorrectException extends RuntimeException{
    public FormatNotCorrectException() {
        super();
    }

    public FormatNotCorrectException(String message) {
        super(message);
    }
}