package kr.co.bnksys.sangsang.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface HomeMapper {


    // 전체 채용
    HashMap selectTotJobOpening();


    // 참여기관별 채용
    List<HashMap> selectAgencyJobOpening();


    // 참여기관별 채용 직렬
    List<HashMap> selectAgencyJobOpeningJobseries();


    // 마감임박 채용
    List<HashMap> selectUrgentJobOpening();


    // 경쟁률 낮은 채용
    List<HashMap> selectLowCompetitionRateJobOpening();


    // id로 채용공고 정보 조회
    List<HashMap> selectOneJobPostingById(HashMap paramMap);

}
