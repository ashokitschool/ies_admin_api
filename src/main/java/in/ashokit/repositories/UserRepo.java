package in.ashokit.repositories;

import in.ashokit.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    @Query("update UserEntity set accStatus=:status where userId=:userId")
    public Integer updateAccStatus(Integer userId, String status);

    public UserEntity findByEmail(String email);

    public UserEntity findByEmailAndPwd(String email, String pwd);
}
