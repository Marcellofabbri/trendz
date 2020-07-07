package trendz.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class ProteinIntakeRequestCreate {
    private final OffsetDateTime createdAt;
    private final int measurement;

    @JsonCreator
    public ProteinIntakeRequestCreate(@JsonProperty("createdAt") OffsetDateTime createdAt,
                                      @JsonProperty("measurement") int measurement) {
        this.createdAt = createdAt;
        this.measurement = measurement;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public int getMeasurement() {
        return measurement;
    }
}
