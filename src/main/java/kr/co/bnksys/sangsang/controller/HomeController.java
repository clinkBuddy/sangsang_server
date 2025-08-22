package kr.co.bnksys.sangsang.controller;


import jakarta.servlet.http.HttpSession;
import kr.co.bnksys.sangsang.mapper.HomeMapper;
import kr.co.bnksys.sangsang.mapper.JobPostingMapper;
import kr.co.bnksys.sangsang.mapper.QaMapper;
import kr.co.bnksys.sangsang.mapper.UserMapper;
import kr.co.bnksys.sangsang.model.JobPosting;
import kr.co.bnksys.sangsang.model.RecommendRequest;
import kr.co.bnksys.sangsang.model.RecommendResponse;
import kr.co.bnksys.sangsang.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    HomeMapper homeMapper;

    @Autowired
    private RecommendService recommendService;


    @Autowired
    QaMapper qaMapper;


    @Autowired
    private JobPostingMapper jobPostingMapper;


    @GetMapping("/home")
    public HashMap fn_Home(HttpSession session){

        System.out.println("====================fn_Home 호출========================");

        HashMap resultMap = new HashMap();
        
        // 전체 채용 통계
        resultMap.put("totJobOpening", homeMapper.selectTotJobOpening());

        // 참여기관별 채용 직렬
        resultMap.put("agencyJobOpening", homeMapper.selectAgencyJobOpening());

        // 참여기관별 채용 직렬
        resultMap.put("agencyJobOpeningJobseries", homeMapper.selectAgencyJobOpeningJobseries());


        // 추천 채용정보
        HashMap loginUser = (HashMap<String, Object>) session.getAttribute("loginUser");

        HashMap scores = qaMapper.selectResultData(loginUser);
        System.out.println("====================== loginUser : " + loginUser);
        System.out.println("====================== scores : " + scores);

        List<RecommendResponse> recommendJobOpeningPython = new ArrayList<>();
        List<HashMap> recommendJobOpening = new ArrayList<>();

        if(scores != null && !scores.isEmpty()){
            RecommendRequest recommendRequest = new RecommendRequest();
            recommendRequest.setTop_k(5);
            recommendRequest.setUser_scores(scores);

            System.out.println("====================== recommendRequest : " + recommendRequest);

            recommendJobOpeningPython = recommendService.getRecommendations(recommendRequest);

            for (RecommendResponse recommend : recommendJobOpeningPython) {
                HashMap map = new HashMap<>();
                map.put("id", recommend.getId());
                List<HashMap> jobPostInfoList = homeMapper.selectOneJobPostingById(map);

                if (jobPostInfoList != null) {
                    for (HashMap jobPostInfo : jobPostInfoList) {
                        recommendJobOpening.add(jobPostInfo);
                    }
                }
            }
        }
        resultMap.put("recommendJobOpening", recommendJobOpening);


        // 마감임박 채용
        resultMap.put("urgentJobOpening", homeMapper.selectUrgentJobOpening());

        // 경쟁률 낮은 채용
        resultMap.put("lowCompetitionRateJobOpening", homeMapper.selectLowCompetitionRateJobOpening());

        System.out.println("====================resultMap : " + resultMap);

        return resultMap;
    }
}
