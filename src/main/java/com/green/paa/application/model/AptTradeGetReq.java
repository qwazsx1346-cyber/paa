package com.green.paa.application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AptTradeGetReq {
    private String lawdCd;
    private String dealYearMon;
    private Integer pageNo;
    private Integer numOfRows;
}
