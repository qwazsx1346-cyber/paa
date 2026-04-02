package com.green.paa.application;

import com.green.paa.application.model.AptItem;
import com.green.paa.application.model.AptTradeGetReq;
import com.green.paa.application.model.AptTradeResponse;
import com.green.paa.configuration.constants.ConstAptTrade;
import com.green.paa.entity.AptTrade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApartTradeService {
    private final AptTradeClient aptTradeClient;
    private final ConstAptTrade constAptTrade;
    private final ApartTradeRepository apartTradeRepository;

    public List<AptItem> getAptTradeList(AptTradeGetReq req) {
        AptTradeResponse response = aptTradeClient.getAptTrade(
              constAptTrade.serviceKey //yaml에 있는 key를 사용하고싶어서 이런식으로 씀
            , req.getLawdCd()
            , req.getDealYearMon()
            , req.getPageNo()
            , req.getNumOfRows()
        );

        if(response.getBody().getItems().size() > 0) {
            for (AptItem item : response.getBody().getItems()) {
                //AptItem >> AptTrade로 바뀌어야 한다.
                AptTrade aptTrade = new AptTrade(item);
                try { apartTradeRepository.save(aptTrade); //save, delete등 옆에 ()들어가는건 담당 엔터티가 들어가야함
                } catch (Exception e) {}
            }
        }
        return response.getBody().getItems();
    }
}
