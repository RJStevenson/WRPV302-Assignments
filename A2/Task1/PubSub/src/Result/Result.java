package Result;

import javax.imageio.plugins.tiff.ExifInteroperabilityTagSet;

public class Result<T> {
    public boolean Successful;
    public String ErrorMessage;
    public T Data;

    public Result(T data)
    {
        Successful= true;
        ErrorMessage="";
        Data = data;
    }

    public Result(boolean successful, String errorMessage)
    {
        Successful = false;
        ErrorMessage = errorMessage;
    }

}
