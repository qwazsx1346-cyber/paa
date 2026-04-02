package com.green.paa.application.model;

import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import java.util.List;


@Data
public class AptBody {
    @JacksonXmlElementWrapper(localName = "items") // <items> 태그로 감싸져 있음 [cite: 42]
    @JacksonXmlProperty(localName = "item")        // 개별 요소는 <item> [cite: 43]
    private List<AptItem> items;

    private int numOfRows;  // 한 페이지 결과 수 [cite: 30, 66]
    private int pageNo;     // 페이지 번호 [cite: 30, 67]
    private int totalCount; // 전체 결과 수 [cite: 30, 68]
}