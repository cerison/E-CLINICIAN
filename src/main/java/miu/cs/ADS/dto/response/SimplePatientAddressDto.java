package miu.cs.ADS.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.cs.ADS.model.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplePatientAddressDto {
    Integer id;
    String fname;
    String lname;
    String phone;
    String email;
    String patNo;
    String dob;
    Address address;
}