package kr.co.bnksys.sangsang.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface QaMapper {

    void insertResultData(HashMap<String, Object> paramMap);

    String selectDataDupYn(HashMap<String, Object> paramMap);

    void deleteResultData(HashMap<String, Object> paramMap);

    Object selectResultData(HashMap<String, Object> paramMap);
    
}
