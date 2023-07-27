package in.ashokit.service;

import in.ashokit.bindings.DashboardCard;
import in.ashokit.bindings.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public String login(LoginForm loginForm) {
        return null;
    }

    @Override
    public boolean recoverPwd(String email) {
        return false;
    }

    @Override
    public DashboardCard fetchDashboardInfo() {
        return null;
    }
}
