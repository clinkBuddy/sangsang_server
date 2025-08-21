package kr.co.bnksys.sangsang.controller;

import kr.co.bnksys.sangsang.mapper.JobPostingScoreMapper;
import kr.co.bnksys.sangsang.model.JobPostingScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/job-posting-scores")
@CrossOrigin("/*")
public class JobPostingScoreController {

    private static final Logger log = LoggerFactory.getLogger(JobPostingScoreController.class);

    @Autowired
    private JobPostingScoreMapper jobPostingScoreMapper;

    /**
     * 채용공고 평가점수 등록 (CREATE)
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createJobPostingScore(@RequestBody JobPostingScore jobPostingScore) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            log.info("채용공고 평가점수 등록 요청: {}", jobPostingScore);
            jobPostingScoreMapper.insertJobPostingScore(jobPostingScore);
            
            response.put("success", true);
            response.put("message", "채용공고 평가점수가 성공적으로 등록되었습니다.");
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("채용공고 평가점수 등록 오류: {}", e.getMessage(), e);
            response.put("success", false);
            response.put("message", "채용공고 평가점수 등록 중 오류가 발생했습니다: " + e.getMessage());
            
            return ResponseEntity.status(500).body(response);
        }
    }

    /**
     * 채용공고 평가점수 단건 조회 (READ)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getJobPostingScore(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            log.info("채용공고 평가점수 조회 요청 - ID: {}", id);
            JobPostingScore jobPostingScore = jobPostingScoreMapper.selectJobPostingScoreById(id);
            
            if (jobPostingScore != null) {
                response.put("success", true);
                response.put("data", jobPostingScore);
            } else {
                response.put("success", false);
                response.put("message", "해당 ID의 채용공고 평가점수를 찾을 수 없습니다.");
                return ResponseEntity.status(404).body(response);
            }
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("채용공고 평가점수 조회 오류: {}", e.getMessage(), e);
            response.put("success", false);
            response.put("message", "채용공고 평가점수 조회 중 오류가 발생했습니다: " + e.getMessage());
            
            return ResponseEntity.status(500).body(response);
        }
    }

    /**
     * 채용공고 평가점수 목록 조회 (READ - LIST)
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> getJobPostingScoreList(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String jobPostingId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            log.info("채용공고 평가점수 목록 조회 요청 - email: {}, jobPostingId: {}, page: {}, size: {}", 
                    email, jobPostingId, page, size);
            
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("email", email);
            paramMap.put("jobPostingId", jobPostingId);
            paramMap.put("limit", size);
            paramMap.put("offset", page * size);
            
            List<JobPostingScore> jobPostingScores = jobPostingScoreMapper.selectJobPostingScoreList(paramMap);
            int totalCount = jobPostingScoreMapper.selectJobPostingScoreCount(paramMap);
            
            response.put("success", true);
            response.put("data", jobPostingScores);
            response.put("totalCount", totalCount);
            response.put("currentPage", page);
            response.put("pageSize", size);
            response.put("totalPages", (int) Math.ceil((double) totalCount / size));
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("채용공고 평가점수 목록 조회 오류: {}", e.getMessage(), e);
            response.put("success", false);
            response.put("message", "채용공고 평가점수 목록 조회 중 오류가 발생했습니다: " + e.getMessage());
            
            return ResponseEntity.status(500).body(response);
        }
    }

    /**
     * 이메일과 채용공고ID로 평가점수 조회
     */
    @GetMapping("/by-email-and-job")
    public ResponseEntity<Map<String, Object>> getJobPostingScoreByEmailAndJob(
            @RequestParam String email,
            @RequestParam String jobPostingId) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            log.info("이메일/채용공고ID로 평가점수 조회 요청 - email: {}, jobPostingId: {}", email, jobPostingId);
            
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("email", email);
            paramMap.put("jobPostingId", jobPostingId);
            
            JobPostingScore jobPostingScore = jobPostingScoreMapper.selectJobPostingScoreByEmailAndJobId(paramMap);
            
            if (jobPostingScore != null) {
                response.put("success", true);
                response.put("data", jobPostingScore);
            } else {
                response.put("success", false);
                response.put("message", "해당 조건의 채용공고 평가점수를 찾을 수 없습니다.");
                return ResponseEntity.status(404).body(response);
            }
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("이메일/채용공고ID로 평가점수 조회 오류: {}", e.getMessage(), e);
            response.put("success", false);
            response.put("message", "평가점수 조회 중 오류가 발생했습니다: " + e.getMessage());
            
            return ResponseEntity.status(500).body(response);
        }
    }

    /**
     * 채용공고 평가점수 수정 (UPDATE)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateJobPostingScore(
            @PathVariable Long id, 
            @RequestBody JobPostingScore jobPostingScore) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            log.info("채용공고 평가점수 수정 요청 - ID: {}, data: {}", id, jobPostingScore);
            
            // ID 설정
            jobPostingScore.setId(id);
            
            // 기존 데이터 존재 여부 확인
            JobPostingScore existingScore = jobPostingScoreMapper.selectJobPostingScoreById(id);
            if (existingScore == null) {
                response.put("success", false);
                response.put("message", "수정할 채용공고 평가점수를 찾을 수 없습니다.");
                return ResponseEntity.status(404).body(response);
            }
            
            jobPostingScoreMapper.updateJobPostingScore(jobPostingScore);
            
            response.put("success", true);
            response.put("message", "채용공고 평가점수가 성공적으로 수정되었습니다.");
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("채용공고 평가점수 수정 오류: {}", e.getMessage(), e);
            response.put("success", false);
            response.put("message", "채용공고 평가점수 수정 중 오류가 발생했습니다: " + e.getMessage());
            
            return ResponseEntity.status(500).body(response);
        }
    }

    /**
     * 채용공고 평가점수 삭제 (DELETE)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteJobPostingScore(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            log.info("채용공고 평가점수 삭제 요청 - ID: {}", id);
            
            // 기존 데이터 존재 여부 확인
            JobPostingScore existingScore = jobPostingScoreMapper.selectJobPostingScoreById(id);
            if (existingScore == null) {
                response.put("success", false);
                response.put("message", "삭제할 채용공고 평가점수를 찾을 수 없습니다.");
                return ResponseEntity.status(404).body(response);
            }
            
            jobPostingScoreMapper.deleteJobPostingScore(id);
            
            response.put("success", true);
            response.put("message", "채용공고 평가점수가 성공적으로 삭제되었습니다.");
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("채용공고 평가점수 삭제 오류: {}", e.getMessage(), e);
            response.put("success", false);
            response.put("message", "채용공고 평가점수 삭제 중 오류가 발생했습니다: " + e.getMessage());
            
            return ResponseEntity.status(500).body(response);
        }
    }
}
