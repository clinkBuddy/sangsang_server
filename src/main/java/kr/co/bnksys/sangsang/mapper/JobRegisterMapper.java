package kr.co.bnksys.sangsang.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface JobRegisterMapper {

    void insertJobRegister(HashMap paramMap);


    void insertJobScore(HashMap paramMap);
}
