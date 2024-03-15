package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.LocalityRequestDTO;
import com.hackaton.postech.domain.dto.request.LocalityUpdateDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Entity
@Table(name = "tb_locality")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"localityId"})
@ToString
@Getter
@Setter
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long localityId;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "aminities", cascade = CascadeType.ALL)
    private List<Amenities> amenities;

    @OneToMany(mappedBy = "buildings", cascade = CascadeType.ALL)
    private List<Building> buildings;

    public static Locality ofSave(LocalityRequestDTO localityRequestDTO) {
        Locality locality = new Locality();
        BeanUtils.copyProperties(localityRequestDTO, locality);
        return locality;
    }

    public static Locality ofUpdate(LocalityUpdateDTO localityUpdateDTO) {
        Locality locality = new Locality();
        BeanUtils.copyProperties(localityUpdateDTO, locality);
        return locality;
    }
}
