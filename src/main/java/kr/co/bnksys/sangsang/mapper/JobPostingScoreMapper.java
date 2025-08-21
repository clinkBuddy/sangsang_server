package kr.co.bnksys.sangsang.mapper;

import kr.co.bnksys.sangsang.model.JobPostingScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JobPostingScoreMapper {

    /**
     * 채용공고 평가점수 등록
     */
    void insertJobPostingScore(JobPostingScore jobPostingScore);

    /**
     * 채용공고 평가점수 조회 (ID로)
     */
    JobPostingScore selectJobPostingScoreById(Long id);

    /**
     * 채용공고 평가점수 목록 조회
     */
    List<JobPostingScore> selectJobPostingScoreList(Map<String, Object> paramMap);

    /**
     * 채용공고 평가점수 수정
     */
    void updateJobPostingScore(JobPostingScore jobPostingScore);

    /**
     * 채용공고 평가점수 삭제
     */
    void deleteJobPostingScore(Long id);

    /**
     * 특정 이메일과 채용공고ID로 점수 조회
     */
    JobPostingScore selectJobPostingScoreByEmailAndJobId(Map<String, Object> paramMap);

    /**
     * 전체 개수 조회 (페이징용)
     */
    int selectJobPostingScoreCount(Map<String, Object> paramMap);
}
