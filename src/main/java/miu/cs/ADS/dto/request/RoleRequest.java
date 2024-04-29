package miu.cs.ADS.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.cs.ADS.model.Role;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
    List<Role> roles;
}
