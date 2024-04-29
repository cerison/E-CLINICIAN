package miu.cs.ADS.repository;

import miu.cs.ADS.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    public List<Address> findAddressesByStreetContainingOrCityContainingOrStateContaining(String street, String city, String state);

}