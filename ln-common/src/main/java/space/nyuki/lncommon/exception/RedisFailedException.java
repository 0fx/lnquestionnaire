package space.nyuki.lncommon.exception;

/**
 * @author ning
 * @createTime 2019/9/4 下午1:20
 * @description
 */
public class RedisFailedException extends RuntimeException {
    public RedisFailedException() {
    }

    public RedisFailedException(String message) {
        super(message);
    }
}