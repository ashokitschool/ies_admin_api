package in.ashokit.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.DashboardCard;
import in.ashokit.bindings.LoginForm;
import in.ashokit.bindings.UserAccForm;
import in.ashokit.constants.AppConstants;
import in.ashokit.entities.EligEntity;
import in.ashokit.entities.UserEntity;
import in.ashokit.repositories.EligRepo;
import in.ashokit.repositories.PlanRepo;
import in.ashokit.repositories.UserRepo;
import in.ashokit.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private EligRepo eligRepo;

    @Autowired
    private EmailUtils emailUtils;

    @Override
    public String login(LoginForm loginForm) {

        UserEntity entity = userRepo.findByEmailAndPwd(loginForm.getEmail(), loginForm.getPwd());

        if(entity == null){
            return AppConstants.INVALID_CRED;
        }

        if(AppConstants.Y_STR.equals(entity.getActiveSw()) && AppConstants.UNLOCKED.equals(entity.getAccStatus())){
            return AppConstants.SUCCESS;
        }else {
            return AppConstants.ACC_LOCKED;
        }
    }

    @Override
    public boolean recoverPwd(String email) {
        UserEntity userEntity = userRepo.findByEmail(email);
        if(null == userEntity){
            return false;
        }else{
        	String subject = AppConstants.RECOVER_SUB;
    		String body = readEmailBody(AppConstants.PWD_BODY_FILE, userEntity);
          return emailUtils.sendEmail(subject, body, email);
        }
    }

    @Override
    public DashboardCard fetchDashboardInfo() {
        long plansCount = planRepo.count();

        List<EligEntity> eligList = eligRepo.findAll();

        Long approvedCnt =
                eligList.stream().filter(ed-> ed.getPlanStatus().equals(AppConstants.AP)).count();

        Long deniedCnt =
                eligList.stream().filter(ed -> ed.getPlanStatus().equals(AppConstants.DN)).count();

        Double total = eligList.stream().mapToDouble(ed -> ed.getBenefitAmt()).sum();

        DashboardCard card = new DashboardCard();

        card.setPlansCnt(plansCount);
        card.setApprovedCnt(approvedCnt);
        card.setDeniedCnt(deniedCnt);
        card.setBeniftAmtGiven(total);

        return card;
    }
    
    @Override
    public UserAccForm getUserByEmail(String email) {
    	UserEntity userEntity = userRepo.findByEmail(email);
    	UserAccForm user = new UserAccForm();
    	BeanUtils.copyProperties(userEntity, user);
    	return user;
    }
    
    private String readEmailBody(String filename, UserEntity user) {
		StringBuilder sb = new StringBuilder();
		try (Stream<String> lines = Files.lines(Paths.get(filename))) {
			lines.forEach(line -> {
				line = line.replace(AppConstants.FNAME, user.getFullName());
				line = line.replace(AppConstants.PWD, user.getPwd());
				line = line.replace(AppConstants.EMAIL, user.getEmail());
				sb.append(line);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
