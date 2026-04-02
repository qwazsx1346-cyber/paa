package com.green.paa.application.aparttrade;

import com.green.paa.application.aparttrade.model.AptTradeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "apt-trade-api", url = "${constants.open-feign.apt-trade.url}")
public interface AptTradeClient {

    @GetMapping(value = "/getRTMSDataSvcAptTradeDev", produces = "application/xml")
    AptTradeResponse getAptTrade(@RequestParam("serviceKey") String serviceKey
                                ,@RequestParam("LAWD_CD") String lawdCd
                                ,@RequestParam("DEAL_YMD") String dealYmd
                                ,@RequestParam(value = "pageNo", required = false) Integer pageNo
                                ,@RequestParam(value = "numOfRows", required = false) Integer numOfRows
      );
      //value로 지정해주면 값을 보내면 null뜨고, 안보내면 default값이 보내짐
}
