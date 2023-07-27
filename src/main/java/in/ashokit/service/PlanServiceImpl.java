package in.ashokit.service;

import in.ashokit.bindings.PlanForm;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService{
    @Override
    public boolean createPlan(PlanForm planForm) {
        return false;
    }

    @Override
    public List<PlanForm> fetchPlans() {
        return null;
    }

    @Override
    public PlanForm getPlanById(Integer planId) {
        return null;
    }

    @Override
    public String changePlanStatus(Integer planId, String status) {
        return null;
    }
}
