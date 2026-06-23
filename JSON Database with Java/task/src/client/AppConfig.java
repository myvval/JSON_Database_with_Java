package client;

import com.beust.jcommander.Parameter;

public class AppConfig {
    @Parameter(names = "-t", description = "Type of the request",required = true)
    private String type;

    @Parameter(names = "-i", description = "The index of the cell",required = false)
    private Integer index;

    @Parameter(names = "-m", description = "message to save in the database",required = false) // only for set req.
    private String message;


    public String getType() {return this.type;}
    public Integer getIndex() {return this.index;}
    public String getMessage() {return this.message != null ? message : "default";}

}
