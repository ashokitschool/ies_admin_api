package in.ashokit.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.UserAccForm;
import in.ashokit.service.AccountService;

@RestController
public class AccountRestController {
	
	private Logger logger = LoggerFactory.getLogger(AccountRestController.class);

    @Autowired
    private AccountService accService;

    @PostMapping("/user")
    public ResponseEntity<String> createAccount(@RequestBody UserAccForm userAccForm){
       
    	logger.debug("Account Creation Process Started...");
    	
    	boolean status = accService.createUserAccount(userAccForm);
    	
    	logger.debug("Account Creation Process Completed...");
    	
        if(status){
        	logger.info("Account Created Successfully..");
            return new ResponseEntity<>("Account Created", HttpStatus.CREATED); //201
        }else{
        	logger.info("Account Creation Failed..");
            return new ResponseEntity<>("Account Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);//500
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserAccForm>> getUsers(){
    	logger.debug("Fetching User Accounts process started..");
        List<UserAccForm> userAccForms = accService.fetchUserAccounts();
        logger.debug("Fetching User Accounts process completed..");
        logger.info("User Accounts Fetched success....");
        return new ResponseEntity<>(userAccForms, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserAccForm> getUser(@PathVariable("userId") Integer userId){
        UserAccForm userAccById = accService.getUserAccById(userId);
        logger.info("User account fetched successfully..");
        return new ResponseEntity<>(userAccById, HttpStatus.OK);
    }

    @PutMapping("/user/{userId}/{status}")
    public ResponseEntity<List<UserAccForm>> updateUserAcc(@PathVariable("userId") Integer userId,
                                                           @PathVariable("status")String status){
    	logger.debug("User account update process started..");
    	accService.changeAccStatus(userId, status);
    	logger.debug("User account update process completed..");
        logger.info("User account status updated successfully..");
        List<UserAccForm> userAccForms = accService.fetchUserAccounts();
        return new ResponseEntity<>(userAccForms, HttpStatus.OK);
    }

}
