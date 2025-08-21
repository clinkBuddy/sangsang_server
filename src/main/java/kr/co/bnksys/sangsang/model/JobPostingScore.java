package kr.co.bnksys.sangsang.model;

import java.time.LocalDateTime;

public class JobPostingScore {
    private Long id;
    private Double 공감사회기술;
    private Double 성실성;
    private Double 개방성;
    private Double 외향성;
    private Double 우호성;
    private Double 정서안정성;
    private Double 기술전문성;
    private Double 인지문제해결;
    private Double 대인영향력;
    private Double 자기관리;
    private Double 적응력;
    private Double 학습속도;
    private Double 대인민첩성;
    private Double 성과민첩성;
    private Double 자기인식;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 기본 생성자
    public JobPostingScore() {}

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double get공감사회기술() {
        return 공감사회기술;
    }

    public void set공감사회기술(Double 공감사회기술) {
        this.공감사회기술 = 공감사회기술;
    }

    public Double get성실성() {
        return 성실성;
    }

    public void set성실성(Double 성실성) {
        this.성실성 = 성실성;
    }

    public Double get개방성() {
        return 개방성;
    }

    public void set개방성(Double 개방성) {
        this.개방성 = 개방성;
    }

    public Double get외향성() {
        return 외향성;
    }

    public void set외향성(Double 외향성) {
        this.외향성 = 외향성;
    }

    public Double get우호성() {
        return 우호성;
    }

    public void set우호성(Double 우호성) {
        this.우호성 = 우호성;
    }

    public Double get정서안정성() {
        return 정서안정성;
    }

    public void set정서안정성(Double 정서안정성) {
        this.정서안정성 = 정서안정성;
    }

    public Double get기술전문성() {
        return 기술전문성;
    }

    public void set기술전문성(Double 기술전문성) {
        this.기술전문성 = 기술전문성;
    }

    public Double get인지문제해결() {
        return 인지문제해결;
    }

    public void set인지문제해결(Double 인지문제해결) {
        this.인지문제해결 = 인지문제해결;
    }

    public Double get대인영향력() {
        return 대인영향력;
    }

    public void set대인영향력(Double 대인영향력) {
        this.대인영향력 = 대인영향력;
    }

    public Double get자기관리() {
        return 자기관리;
    }

    public void set자기관리(Double 자기관리) {
        this.자기관리 = 자기관리;
    }

    public Double get적응력() {
        return 적응력;
    }

    public void set적응력(Double 적응력) {
        this.적응력 = 적응력;
    }

    public Double get학습속도() {
        return 학습속도;
    }

    public void set학습속도(Double 학습속도) {
        this.학습속도 = 학습속도;
    }

    public Double get대인민첩성() {
        return 대인민첩성;
    }

    public void set대인민첩성(Double 대인민첩성) {
        this.대인민첩성 = 대인민첩성;
    }

    public Double get성과민첩성() {
        return 성과민첩성;
    }

    public void set성과민첩성(Double 성과민첩성) {
        this.성과민첩성 = 성과민첩성;
    }

    public Double get자기인식() {
        return 자기인식;
    }

    public void set자기인식(Double 자기인식) {
        this.자기인식 = 자기인식;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "JobPostingScore{" +
                "id=" + id +
                ", 공감사회기술=" + 공감사회기술 +
                ", 성실성=" + 성실성 +
                ", 개방성=" + 개방성 +
                ", 외향성=" + 외향성 +
                ", 우호성=" + 우호성 +
                ", 정서안정성=" + 정서안정성 +
                ", 기술전문성=" + 기술전문성 +
                ", 인지문제해결=" + 인지문제해결 +
                ", 대인영향력=" + 대인영향력 +
                ", 자기관리=" + 자기관리 +
                ", 적응력=" + 적응력 +
                ", 학습속도=" + 학습속도 +
                ", 대인민첩성=" + 대인민첩성 +
                ", 성과민첩성=" + 성과민첩성 +
                ", 자기인식=" + 자기인식 +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
