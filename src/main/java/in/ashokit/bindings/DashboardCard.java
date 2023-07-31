package in.ashokit.bindings;

public class DashboardCard {

	private Long plansCnt;
	private Long approvedCnt;
	private Long deniedCnt;
	private Double beniftAmtGiven;
	
	private UserAccForm user;

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

	public UserAccForm getUser() {
		return user;
	}

	public void setUser(UserAccForm user) {
		this.user = user;
	}

	public Double getBeniftAmtGiven() {
		return beniftAmtGiven;
	}

	public void setBeniftAmtGiven(Double beniftAmtGiven) {
		this.beniftAmtGiven = beniftAmtGiven;
	}

}