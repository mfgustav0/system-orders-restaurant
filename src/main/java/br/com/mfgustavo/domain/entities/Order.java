package br.com.mfgustavo.domain.entities;

import br.com.mfgustavo.domain.enums.StatusOrder;

public record Order(
        Long id,
        StatusOrder status,
        Double total) {
}
