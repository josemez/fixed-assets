package com.fixed_asset.appasset.infrastructure.persistence.entity;

import com.fixed_asset.appasset.domain.ActualState;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
public class AssetDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String type;
    private String serial;
    @Column(name="internal_inventory_number")
    private int internalInventoryNumber;
    private int weight;
    private int tall;
    private int width;
    private int length;
    @Column(name="purchase_value")
    private double purchaseValue;
    @Column(name="date_purchase")
    private LocalDateTime datePurchase;
    @Column(name="discharge_date")
    private LocalDateTime dischargeDate;
    @Enumerated(EnumType.STRING)
    private ActualState state;
    private String color;

}
