package com.pree.format.mail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(value = Include.NON_EMPTY)
public class DataMailFormat {

    private String to;
    private String subject;
    private String text;

}
