package com.pree.format;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BodyFormat {

    private String logtime;
    private String errorcode;
    private String errordescription;
    private Boolean issuccess;
    private String apikey;
    private String messageguid;

}
