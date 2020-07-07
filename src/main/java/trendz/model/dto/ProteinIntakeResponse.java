package trendz.model.dto;

import java.time.OffsetDateTime;

public class ProteinIntakeResponse {
    private final long id;
    private final OffsetDateTime createdAt;
    private final int measurement;


    public ProteinIntakeResponse(long id, OffsetDateTime createdAt, int measurement) {
        this.id = id;
        this.createdAt = createdAt;
        this.measurement = measurement;
    }

    public long getId() {
        return id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public int getMeasurement() {
        return measurement;
    }
}
