/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.entity;

import javax.persistence.*;

/**
 *
 * @author alexis
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TRAIN_TYPE")
public abstract class Train {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    protected TractionType traction;
    
    protected Long maxSpeed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TractionType getTraction() {
        return traction;
    }

    public void setTraction(TractionType traction) {
        this.traction = traction;
    }

    public Long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
}
