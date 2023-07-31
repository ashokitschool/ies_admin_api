package in.ashokit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entities.EligEntity;

public interface EligRepo extends JpaRepository<EligEntity, Integer> {
}
