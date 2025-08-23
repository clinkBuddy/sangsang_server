package kr.co.bnksys.sangsang.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface QaMapper {

    void insertResultData(HashMap paramMap);

    String selectDataDupYn(HashMap paramMap);

    void deleteResultData(HashMap paramMap);

    HashMap selectResultData(HashMap paramMap);

    HashMap selectRecommendDetail(String strId);

    //AI 조언
    String selectCommentResult(HashMap paramMap);

}
