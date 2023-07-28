package in.ashokit.bindings;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlanForm {

    private String planCategory;
    private String planName;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
}
