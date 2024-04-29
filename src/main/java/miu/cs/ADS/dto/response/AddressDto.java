package miu.cs.ADS.dto.response;

import lombok.Data;

@Data
public class AddressDto {
    private Integer id;
    private String street;
    private String city;
    private String state;
    private Integer zipcode;
    private PatientDto patient;
}
