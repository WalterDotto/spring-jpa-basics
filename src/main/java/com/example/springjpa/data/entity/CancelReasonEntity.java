package com.example.springjpa.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reasons")
public class CancelReasonEntity {

  public CancelReasonEntity(){}

  public CancelReasonEntity(Integer id, String description){
    this.id = id;
    this.description = description;
  }

  @Id
  @Column(name = "reason_id", insertable = false, updatable = false)
  private Integer id;

  @Column(name = "description", insertable = false, updatable = false)
  private String description;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
