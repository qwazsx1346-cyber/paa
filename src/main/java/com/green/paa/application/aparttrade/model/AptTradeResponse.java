package com.green.paa.application.aparttrade.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AptTradeResponse {

  @JacksonXmlProperty(localName = "header")
  private AptHeader header;

  @JacksonXmlProperty(localName = "body")
  private AptBody body;
}