package org.willwin.jhin.model.mapper.configuration;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * Base configuration for all MapStruct mappers.
 * This configuration ensures consistent settings across all mappers in the project.
 */
@MapperConfig(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface BaseMapperConfiguration
{

}
