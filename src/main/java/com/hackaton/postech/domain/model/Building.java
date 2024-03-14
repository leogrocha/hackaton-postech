package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.BuildingRequestDTO;
import com.hackaton.postech.domain.dto.request.BuildingUpdateDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "tb_building")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"buildingId"})
@ToString
@Getter
@Setter
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buildingId;

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "locality_id")
    private Locality locality;


  public static Building ofSave(BuildingRequestDTO buildingRequestDTO) {
    var building = new Building();
    BeanUtils.copyProperties(buildingRequestDTO, building);
    return building;
  }

  public static Building ofUpdate(BuildingUpdateDTO buildingUpdateDTO) {
    var building = new Building();
    BeanUtils.copyProperties(buildingUpdateDTO, building);
    return building;
  }
}
