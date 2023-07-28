package in.ashokit.repositories;

import in.ashokit.entities.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepo extends JpaRepository<PlanEntity, Integer> {
}
