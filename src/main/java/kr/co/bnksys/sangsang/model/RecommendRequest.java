package kr.co.bnksys.sangsang.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Map;

public class RecommendRequest {

    private Map<String, Number> user_scores;
    private Integer top_k;

    public RecommendRequest() {}

    public RecommendRequest(Map<String, Number> user_scores, Integer top_k) {
        this.user_scores = user_scores;
        this.top_k = top_k;
    }

    public Map<String, Number> getUser_scores() {
        return user_scores;
    }

    public void setUser_scores(Map<String, Number> user_scores) {
        this.user_scores = user_scores;
    }

    public Integer getTop_k() {
        return top_k;
    }

    public void setTop_k(Integer top_k) {
        this.top_k = top_k;
    }

    @Override
    public String toString() {
        return "RecommendRequest{" +
                "user_scores=" + user_scores +
                ", top_k=" + top_k +
                '}';
    }
}
