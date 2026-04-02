package com.green.paa.application.aparttrade;

import com.green.paa.application.aparttrade.model.AptItem;
import com.green.paa.application.aparttrade.model.AptTradeGetReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/apart")
@RequiredArgsConstructor
public class ApartTradeController {
    private final ApartTradeService apartTradeService;

    @GetMapping
    public List<AptItem> getAptTradeList(@ModelAttribute AptTradeGetReq req) {
        return apartTradeService.getAptTradeList(req);
    }
}
