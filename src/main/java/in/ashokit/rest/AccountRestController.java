package in.ashokit.rest;

import java.util.List;

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

    @Autowired
    private AccountService accService;

    @PostMapping("/user")
    public ResponseEntity<String> createAccount(@RequestBody UserAccForm userAccForm){
        boolean status = accService.createUserAccount(userAccForm);
        if(status){
            return new ResponseEntity<>("Account Created", HttpStatus.CREATED); //201
        }else{
            return new ResponseEntity<>("Account Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);//500
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserAccForm>> getUsers(){
        List<UserAccForm> userAccForms = accService.fetchUserAccounts();
        return new ResponseEntity<>(userAccForms, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserAccForm> getUser(@PathVariable("userId") Integer userId){
        UserAccForm userAccById = accService.getUserAccById(userId);
        return new ResponseEntity<>(userAccById, HttpStatus.OK);
    }

    @PutMapping("/user/{userId}/{status}")
    public ResponseEntity<List<UserAccForm>> updateUserAcc(@PathVariable("userId") Integer userId,
                                                           @PathVariable("status")String status){
        accService.changeAccStatus(userId, status);
        List<UserAccForm> userAccForms = accService.fetchUserAccounts();
        return new ResponseEntity<>(userAccForms, HttpStatus.OK);
    }

}
