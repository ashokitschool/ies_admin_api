package in.ashokit.exception;

import java.time.LocalDateTime;

public class AppExcepiton {

	private String exCode;

	private String exDesc;

	private LocalDateTime exDate;

	public String getExCode() {
		return exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}

	public String getExDesc() {
		return exDesc;
	}

	public void setExDesc(String exDesc) {
		this.exDesc = exDesc;
	}

	public LocalDateTime getExDate() {
		return exDate;
	}

	public void setExDate(LocalDateTime exDate) {
		this.exDate = exDate;
	}

}
