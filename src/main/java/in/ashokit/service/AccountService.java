package in.ashokit.service;

import in.ashokit.bindings.UnlockAccForm;
import in.ashokit.bindings.UserAccForm;

import java.util.List;

public interface AccountService {

    public boolean createUserAccount(UserAccForm accForm);

    public List<UserAccForm> fetchUserAccounts( );

    public UserAccForm getUserAccById(Integer accId);

    public String changeAccStatus(Integer accId, String status);

    public String unlockUserAccount(UnlockAccForm unlockAccForm);

}
