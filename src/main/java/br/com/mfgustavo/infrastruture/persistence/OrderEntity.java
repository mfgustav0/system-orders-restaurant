package br.com.mfgustavo.infrastruture.persistence;

import br.com.mfgustavo.domain.enums.StatusOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "tab_orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusOrder status;
    private Double total;

    public OrderEntity() {
    }

    public OrderEntity(Long id, StatusOrder status, Double total) {
        this.id = id;
        this.status = status;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
