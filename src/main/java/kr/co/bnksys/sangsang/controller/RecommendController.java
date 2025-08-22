package kr.co.bnksys.sangsang.controller;

import kr.co.bnksys.sangsang.model.RecommendRequest;
import kr.co.bnksys.sangsang.model.RecommendResponse;
import kr.co.bnksys.sangsang.service.RecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RecommendController {
    private static final Logger log = LoggerFactory.getLogger(RecommendController.class);
    @Autowired
    private RecommendService recommendService;

    @PostMapping("/recommend")
    public ResponseEntity<?> fn_Recommand(@RequestBody RecommendRequest request) {

        log.info("recommend 호출 ! fn_Recommand : {}" ,request.toString());

        List<RecommendResponse> results = recommendService.getRecommendations(request);

        if (results.isEmpty()) {
            return ResponseEntity.status(500).body(Map.of("error", "추천 결과가 없습니다."));
        }

        return ResponseEntity.ok(results);
    }
}
