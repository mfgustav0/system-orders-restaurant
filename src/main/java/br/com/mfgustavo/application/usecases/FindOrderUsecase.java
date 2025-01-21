package br.com.mfgustavo.application.usecases;

import br.com.mfgustavo.domain.entities.Order;

public interface FindOrderUsecase {
    Order execute(Long id);
}
