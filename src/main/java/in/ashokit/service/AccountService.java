package in.ashokit.service;

import in.ashokit.bindings.UnlockAccForm;

public interface AccountService {

    public boolean createUserAccount(UserAccountForm accForm);

    public List<UserAccountForm> fetchUserAccounts( );

    public UserAccountForm getUserAccById(Integer accId);

    public String changeAccStatus(Integer accId, String status);

    public String unlockUserAccount(UnlockAccForm unlockAccForm);

}
