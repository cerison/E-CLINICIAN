package miu.cs.ADS.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.cs.ADS.model.Address;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleSurgeryDto {
        private Integer id;
        private String name;
        private Address address;
}
