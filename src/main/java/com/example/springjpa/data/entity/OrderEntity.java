package com.example.springjpa.data.entity;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name = "orders")
public class OrderEntity {

    public OrderEntity() {}

    public OrderEntity(Integer id, Date createdDate, Integer cancelReason) {
        this.id = id;
        this.createdDate = createdDate;
        this.cancelReason = cancelReason;
    }

    @Id
    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "created_date")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "cancel_reason")
    private Integer cancelReason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(Integer cancelReason) {
        this.cancelReason = cancelReason;
    }
}
