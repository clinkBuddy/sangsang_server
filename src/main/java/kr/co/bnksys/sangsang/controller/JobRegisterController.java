package kr.co.bnksys.sangsang.controller;


import kr.co.bnksys.sangsang.mapper.JobRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class JobRegisterController {

    @Autowired
    JobRegisterMapper jobRegisterMapper;


    @PostMapping("/job-register")
    public HashMap fn_Register(@RequestBody HashMap paramMap){

        System.out.println("====================fn_Register 호출========================");

        HashMap resultMap = new HashMap();

        System.out.println("paramMap : " + paramMap.toString());

        try {

            // 채용공고 정보 등록
            jobRegisterMapper.insertJobRegister(paramMap);
            System.out.println("====================채용공고 정보 등록 성공!!!!");

            // 채용 직렬 점수 등록
            jobRegisterMapper.insertJobScore(paramMap);
            System.out.println("====================채용 직렬 점수 등록 성공!!!!");


            resultMap.put("RESULT","success");


        }catch(Exception e){
            resultMap.put("RESULT","error");
            resultMap.put("error_msg","오류가 발생했습니다. 관리자에게 문의하세요");
            System.out.println("====================채용공고 등록 실패!!!!");

            System.out.println("====================error: "+ e.getMessage());
            return resultMap;
        }

        return resultMap;
    }
}
