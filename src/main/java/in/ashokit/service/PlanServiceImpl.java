package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.bindings.PlanForm;

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
