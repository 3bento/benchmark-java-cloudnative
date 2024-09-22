package dev.ebento.jakartaee10rest.mapper;

import dev.ebento.jakartaee10rest.dto.PersonDTO;
import dev.ebento.jakartaee10rest.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface PersonMapper {

    List<PersonDTO> toMap(List<PersonEntity> persons);
    PersonDTO toMap(PersonEntity person);
    PersonEntity toMap(PersonDTO personDTO);
}