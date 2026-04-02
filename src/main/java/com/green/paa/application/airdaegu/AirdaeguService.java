package com.green.paa.application.airdaegu;

import com.green.paa.application.airdaegu.model.AirdaeguItem;
import com.green.paa.application.airdaegu.model.AirdaeguResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirdaeguService {
    private final AirdaeguClient airdaeguClient;

    public List<AirdaeguItem> getAirdaeguList(String dataDt) {
        AirdaeguResponse response = airdaeguClient.getAirdaegu(dataDt);
        return response.getRows();
    }
}
