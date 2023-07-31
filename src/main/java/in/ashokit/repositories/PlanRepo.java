package in.ashokit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entities.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Integer> {
}
