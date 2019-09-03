package space.nyuki.lncommon.exception;

public class TemplateNotFoundException extends RuntimeException {
    public TemplateNotFoundException(String message) {
        super(message);
    }

    public TemplateNotFoundException() {
        super();
    }
}
