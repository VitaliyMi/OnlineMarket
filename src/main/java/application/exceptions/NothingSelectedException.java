package application.exceptions;

/**
 * Created by MSI on 08.09.2016.
 */
public class NothingSelectedException extends RuntimeException   {

    @Override
    public String getMessage() {
        return "At least 1 item must be selected";
    }
}
