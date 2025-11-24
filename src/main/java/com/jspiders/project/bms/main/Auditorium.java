package com.jspiders.project.bms.main;

import jakarta.persistence.*;

@Entity
@Table(name = "audi")
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//use Auto-Increment
    private Long id;
    @Column(name = "audi_name")
    private String name;

    @Column(name = "audi_seat_rows")
    private Integer seatRows;

    @Column(name = "audi_seat_columns")
    private Integer seatColumns;

    @OneToOne(cascade = CascadeType.ALL)//Type of Assc.
    @JoinColumn(name = "address_id")//Creates FK
    private AudiAddress audiAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(Integer seatRows) {
        this.seatRows = seatRows;
    }

    public Integer getSeatColumns() {
        return seatColumns;
    }

    public void setSeatColumns(Integer seatColumns) {
        this.seatColumns = seatColumns;
    }

    public AudiAddress getAudiAddress() {
        return audiAddress;
    }

    public void setAudiAddress(AudiAddress audiAddress) {
        this.audiAddress = audiAddress;
    }
}







