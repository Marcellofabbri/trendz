package eu.marcellofabbri.trendz.model;
 
import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "proteinIntake")

public class ProteinIntake implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "date")
    private OffsetDateTime date;

    @Column (name = "measurement")
    private int measurement;

    protected ProteinIntake() {
    }

}