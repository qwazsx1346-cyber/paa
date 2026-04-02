package com.green.paa.application.aparttrade.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data //종합 선물세트
@JsonIgnoreProperties(ignoreUnknown = true) // 정의되지 않은 태그가 있어도 오류 방지
public class AptItem {
    // 기본 정보
    private String aptNm;      // 단지명 [cite: 29, 45]
    private String aptDong;    // 아파트 동명 [cite: 29, 44]
    private String sggCd;      // 지역코드 [cite: 29, 61]
    private String umdNm;      // 법정동 [cite: 29, 63]
    private String jibun;      // 지번 [cite: 29, 58]
    private String buildYear;  // 건축년도 [cite: 29, 46]

    // 거래 정보
    private String dealAmount; // 거래금액(만원) [cite: 29, 50]
    private String dealYear;   // 계약년도 [cite: 29, 53]
    private String dealMonth;  // 계약월 [cite: 29, 52]
    private String dealDay;    // 계약일 [cite: 29, 51]
    private String excluUseAr; // 전용면적 [cite: 29, 56]
    private String floor;      // 층 [cite: 29, 57]

    // 해제 및 거래 유형
    private String cdealType;  // 해제여부 [cite: 29, 49]
    private String cdealDay;   // 해제사유발생일 [cite: 29, 48]
    private String dealingGbn; // 거래유형 [cite: 29, 54]

    // 추가 정보 (실제 응답 기준)
    private String rgstDate;   // 등기일자 [cite: 29, 60]
    private String roadNm;     // 도로명
    private String estateAgentSggNm; // 중개사소재지 [cite: 29, 55]
    private String buyerGbn;   // 매수자 [cite: 29, 47]
    private String slerGbn;    // 매도자 [cite: 29, 62]
    private String landLeaseholdGbn; // 토지임대부 아파트 여부 [cite: 29, 59]
}
