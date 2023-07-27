package in.ashokit.service;

import in.ashokit.bindings.UnlockAccForm;

@Servce
public class AccountServiceImpl implements AccountService{
    @Override
    public boolean createUserAccount(UserAccountForm accForm) {
        return false;
    }

    @Override
    public List<UserAccountForm> fetchUserAccounts() {
        return null;
    }

    @Override
    public UserAccountForm getUserAccById(Integer accId) {
        return null;
    }

    @Override
    public String changeAccStatus(Integer accId, String status) {
        return null;
    }

    @Override
    public String unlockUserAccount(UnlockAccForm unlockAccForm) {
        return null;
    }
}
