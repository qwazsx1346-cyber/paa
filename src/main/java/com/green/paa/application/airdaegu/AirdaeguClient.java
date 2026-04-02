package com.green.paa.application.airdaegu;

import com.green.paa.application.airdaegu.model.AirdaeguResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "airdaegu-api", url = "https://air.daegu.go.kr/api/xml/dayavg.do")
public interface AirdaeguClient {
    @GetMapping(produces = "application/xml")
    AirdaeguResponse getAirdaegu(@RequestParam("data_dt") String dataDt);

}
