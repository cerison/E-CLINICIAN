package miu.cs.ADS.repository;

import miu.cs.ADS.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurgeryRepository  extends JpaRepository<Surgery, Integer> {
    public List<Surgery> findByNameContaining(String name);

}
