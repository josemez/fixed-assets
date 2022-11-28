package com.fixed_asset.appasset.infrastructure.persistence.entity;

import com.fixed_asset.appasset.domain.ActualState;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
public class AssetDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)

    private String name;
    private String description;
    @Column(nullable = false, length = 50)
    private String type;
    @Column(nullable = false, unique=true, length = 50)
    private String serial;
    @Column(name="internal_inventory_number", nullable = false)
    private int internalInventoryNumber;
    private int weight;
    private int tall;
    private int width;
    private int length;
    @Column(name="purchase_value", nullable = false)
    private double purchaseValue;
    @Column(name="date_purchase", nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime datePurchase;
    @Column(name="discharge_date", nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime dischargeDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ActualState state;
    private String color;

    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "area_id")
    private Integer areaId;

    public AssetDB() {
    }



    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private PersonDB person;

    @ManyToOne
    @JoinColumn(name = "area_id", insertable = false, updatable = false)
    private AreaDB area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getInternalInventoryNumber() {
        return internalInventoryNumber;
    }

    public void setInternalInventoryNumber(int internalInventoryNumber) {
        this.internalInventoryNumber = internalInventoryNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTall() {
        return tall;
    }

    public void setTall(int tall) {
        this.tall = tall;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public LocalDateTime getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDateTime datePurchase) {
        this.datePurchase = datePurchase;
    }

    public LocalDateTime getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDateTime dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public ActualState getState() {
        return state;
    }

    public void setState(ActualState state) {
        this.state = state;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPersonId() {
        return personId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public PersonDB getPerson() {
        return person;
    }

    public void setPerson(PersonDB person) {
        this.person = person;
    }

    public AreaDB getArea() {
        return area;
    }

    public void setArea(AreaDB area) {
        this.area = area;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
