package in.ashokit.bindings;

import lombok.Data;

@Data
public class DashboardCard {

    private Integer plansCnt;
    private Integer approvedCnt;
    private Integer deniedCnt;
    private Double beniftAmtGiven;
}