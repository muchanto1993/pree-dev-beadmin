package com.pree.format.mail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.pree.format.BodyFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(value = Include.NON_NULL)
@JsonPropertyOrder({ "data", "logtime", "errorcode", "errordescription", "issuccess", "apikey", "messageguid" })
public class MailBodyFormat extends BodyFormat {

    private DataMailFormat data;

}
