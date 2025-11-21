package com.jspiders.project.bms;

import jakarta.persistence.*;

@Entity
@Table(name = "auditorium")
@MappedSuperclass
public class Audi extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "audi_name",nullable = false)
    private String name;

    @Column(name = "seat_rows",nullable = false)
    private Integer seatRows;

    @Column(name = "seat_columns",nullable = false)
    private Integer seatColumns;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addrs_id")//FK
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Audi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatRows=" + seatRows +
                ", seatColumns=" + seatColumns +
                ", address=" + address +
                '}';
    }
}








