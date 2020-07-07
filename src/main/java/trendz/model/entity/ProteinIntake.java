package trendz.model.entity;
 
import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "protein_intake")

public class ProteinIntake implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "createdAt")
    private OffsetDateTime createdAt;

    @Column (name = "measurement")
    private int measurement;

    public ProteinIntake() {
    }

    public ProteinIntake(OffsetDateTime createdAt, int measurement) {
        this.createdAt = createdAt;
        this.measurement = measurement;
    }

    public int getMeasurement() {
        return measurement;
    }

    public void setMeasurement(int measurement) {
        this.measurement = measurement;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

}