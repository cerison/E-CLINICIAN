package miu.cs.ADS.repository;

import miu.cs.ADS.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
    public List<Dentist> findDentistByFnameContainingOrLnameContainingOrSpecnContaining(String fname, String lname, String specn);

}
