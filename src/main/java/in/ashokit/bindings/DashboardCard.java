package in.ashokit.bindings;

import lombok.Data;

public class DashboardCard {

    private Long plansCnt;
    private Long approvedCnt;
    private Long deniedCnt;
    private Double beniftAmtGiven;

    public Long getPlansCnt() {
        return plansCnt;
    }

    public void setPlansCnt(Long plansCnt) {
        this.plansCnt = plansCnt;
    }

    public Long getApprovedCnt() {
        return approvedCnt;
    }

    public void setApprovedCnt(Long approvedCnt) {
        this.approvedCnt = approvedCnt;
    }

    public Long getDeniedCnt() {
        return deniedCnt;
    }

    public void setDeniedCnt(Long deniedCnt) {
        this.deniedCnt = deniedCnt;
    }

    public Double getBeniftAmtGiven() {
        return beniftAmtGiven;
    }

    public void setBeniftAmtGiven(Double beniftAmtGiven) {
        this.beniftAmtGiven = beniftAmtGiven;
    }
}