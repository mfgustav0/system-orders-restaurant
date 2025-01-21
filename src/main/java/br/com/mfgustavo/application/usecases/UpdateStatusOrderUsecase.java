package br.com.mfgustavo.application.usecases;

import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.domain.enums.StatusOrder;

public interface UpdateStatusOrderUsecase {
    Order execute(Long id, StatusOrder statusOrder);
}
