package pl.biuropodrozy.entity.Trip;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private FromLocation fromLocation;
    @OneToOne
    private DestinyLocation destinyLocation;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;
    private Catering catering;
    @Column(name = "price_adult")
    private Double priceForAdult;
    @Column(name = "price_child")
    private Double priceForChild;
    private boolean promoted;
    private Integer numberOfAdult;
    private Integer numberOfChild;

    public Trip(FromLocation fromLocation, DestinyLocation destinyLocation, LocalDate startDate, LocalDate endDate, Catering catering, Double priceForAdult, Double priceForChild, boolean promoted) {
        this.fromLocation = fromLocation;
        this.destinyLocation = destinyLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.catering = catering;
        this.priceForAdult = priceForAdult;
        this.priceForChild = priceForChild;
        this.promoted = promoted;
    }

    public Trip() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FromLocation getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(FromLocation fromLocation) {
        this.fromLocation = fromLocation;
    }

    public DestinyLocation getDestinyLocation() {
        return destinyLocation;
    }

    public void setDestinyLocation(DestinyLocation destinyLocation) {
        this.destinyLocation = destinyLocation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Catering getCatering() {
        return catering;
    }

    public void setCatering(Catering catering) {
        this.catering = catering;
    }

    public Double getPriceForAdult() {
        return priceForAdult;
    }

    public void setPriceForAdult(Double priceForAdult) {
        this.priceForAdult = priceForAdult;
    }

    public Double getPriceForChild() {
        return priceForChild;
    }

    public void setPriceForChild(Double priceForChild) {
        this.priceForChild = priceForChild;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public Integer getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(Integer numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public Integer getNumberOfChild() {
        return numberOfChild;
    }

    public void setNumberOfChild(Integer numberOfChild) {
        this.numberOfChild = numberOfChild;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                '}';
    }
}
