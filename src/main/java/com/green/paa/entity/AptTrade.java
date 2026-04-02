package com.green.paa.entity;

import com.green.paa.application.model.AptItem;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "apt_trade", uniqueConstraints = {
    @UniqueConstraint(
        name = "uq_apt_trade_identity",
        columnNames = {"jibun", "sgg_cd", "deal_amount", "deal_date", "floor", "apt_dong"}
    )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) //현재일시값 insert할 때 사용. PaaApplication에서 애노테이션 활성화
public class AptTrade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "apt_dong", length = 50, nullable = false)
  private String aptDong;

  @Column(name = "apt_nm", length = 100, nullable = false)
  private String aptNm;

  @Column(name = "build_year", length = 4)
  private String buildYear;

  @Column(name = "buyer_gbn", length = 20)
  private String buyerGbn;

  @Column(name = "cdeal_day", length = 20)
  private String cdealDay;

  @Column(name = "cdeal_type", length = 20)
  private String cdealType;

  @Column(name = "deal_amount", nullable = false)
  private Long dealAmount; // 만원 단위 (쉼표 제거 후 저장)

  @Column(name = "deal_date", nullable = false)
  private LocalDate dealDate; // 년, 월, 일을 합친 날짜

  @Column(name = "dealing_gbn", length = 50)
  private String dealingGbn;

  @Column(name = "estate_agent_sgg_nm", length = 255)
  private String estateAgentSggNm;

  @Column(name = "exclu_use_ar", precision = 10, scale = 4, nullable = false)
  private BigDecimal excluUseAr;

  @Column(name = "floor")
  private Integer floor;

  @Column(name = "jibun", length = 20, nullable = false)
  private String jibun;

  @Column(name = "land_leasehold_gbn", length = 1)
  private String landLeaseholdGbn;

  @Column(name = "rgst_date", length = 20)
  private String rgstDate;

  @Column(name = "road_nm", length = 100)
  private String roadNm;

  @Column(name = "sgg_cd", length = 10, nullable = false)
  private String sggCd;

  @Column(name = "sler_gbn", length = 20)
  private String slerGbn;

  @Column(name = "umd_nm", length = 50)
  private String umdNm;

  @CreatedDate
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  public AptTrade(AptItem aptItem) {
    this.aptDong = aptItem.getAptDong();
    this.aptNm = aptItem.getAptNm();
    this.buildYear = aptItem.getBuildYear();
    this.buyerGbn = aptItem.getBuyerGbn();
    this.cdealDay = aptItem.getCdealDay();
    this.cdealType = aptItem.getCdealType();

    // "1,500" → 쉼표 제거 후 Long으로 변환 //dealAmount가 빈 값으로 올 경우를 대비
    this.dealAmount = (aptItem.getDealAmount() != null && !aptItem.getDealAmount().isBlank())
        ? Long.parseLong(aptItem.getDealAmount().replaceAll(",", "").trim())
        : null;

    // 년(dealYear) + 월(dealMonth) + 일(dealDay) → LocalDate
    this.dealDate = LocalDate.of(
        Integer.parseInt(aptItem.getDealYear().trim()),
        Integer.parseInt(aptItem.getDealMonth().trim()),  // ← dealMonth !
        Integer.parseInt(aptItem.getDealDay().trim())
    );

    this.dealingGbn = aptItem.getDealingGbn();
    this.estateAgentSggNm = aptItem.getEstateAgentSggNm();

    // "84.9500" → BigDecimal
    this.excluUseAr = new BigDecimal(aptItem.getExcluUseAr().trim());

    // "3" → Integer (null 체크 포함)
    this.floor = aptItem.getFloor() != null
        ? Integer.parseInt(aptItem.getFloor().trim())
        : null;

    this.jibun = aptItem.getJibun();
    this.landLeaseholdGbn = aptItem.getLandLeaseholdGbn();
    this.rgstDate = aptItem.getRgstDate();
    this.roadNm = aptItem.getRoadNm();
    this.sggCd = aptItem.getSggCd();
    this.slerGbn = aptItem.getSlerGbn();
    this.umdNm = aptItem.getUmdNm();
  }
}
