package miu.cs.ADS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.cs.ADS.enums.Roles;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Roles roleName;
}