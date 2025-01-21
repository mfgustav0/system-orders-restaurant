package br.com.mfgustavo.infrastruture.dtos;

import br.com.mfgustavo.domain.enums.StatusOrder;

public record OrderDto(
        Long id,
        StatusOrder status,
        Double total) {
}
