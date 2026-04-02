package com.green.paa.application.airdaegu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "result")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirdaeguResponse {

    @JacksonXmlElementWrapper(useWrapping = false) // <row> 태그들이 별도 감싸는 태그 없이 나열됨
    @JacksonXmlProperty(localName = "row")
    private List<AirdaeguItem> rows;
}
