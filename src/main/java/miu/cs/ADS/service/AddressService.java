package miu.cs.ADS.service;

import miu.cs.ADS.dto.response.AddressDto;
import miu.cs.ADS.exception.NotFoundException;
import miu.cs.ADS.model.Address;

import java.util.List;

public interface AddressService {
        public List<AddressDto> getAddress();
        public Address getAddress(Integer id);
        List<AddressDto> searchAddress(String query);
        public void addAddress(Address address);
        public Address updateAddress(Integer id, Address address)  throws NotFoundException;
        public void deleteAddress(Integer id)  throws NotFoundException;

}
