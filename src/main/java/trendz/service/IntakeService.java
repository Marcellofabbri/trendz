package trendz.service;

import trendz.model.dto.ProteinIntakeRequestCreate;
import trendz.model.dto.ProteinIntakeResponse;
import trendz.model.entity.ProteinIntake;
import trendz.repository.ProteinIntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntakeService {

    @Autowired
    private ProteinIntakeRepository proteinIntakeRepository;

    public ProteinIntakeResponse createIntake(ProteinIntakeRequestCreate request) {
        ProteinIntake newProteinIntake = new ProteinIntake(request.getCreatedAt(), request.getMeasurement());
        ProteinIntake save = proteinIntakeRepository.save(newProteinIntake);
        ProteinIntakeResponse response = new ProteinIntakeResponse(save.getId(), save.getCreatedAt(), save.getMeasurement());
        return response;
    }
}
