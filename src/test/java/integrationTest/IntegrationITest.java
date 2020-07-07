package integrationTest;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import trendz.model.entity.ProteinIntake;
import trendz.repository.ProteinIntakeRepository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@AutoConfigureEmbeddedDatabase
public class IntegrationITest {

    @Autowired
    private ProteinIntakeRepository repo;

    private void addThreeEntries() {
        repo.save(new ProteinIntake(OffsetDateTime.of(LocalDateTime.of(2020, 07, 01, 0, 0), ZoneOffset.UTC), 50));
        repo.save(new ProteinIntake(OffsetDateTime.of(LocalDateTime.of(2020, 07, 02, 0, 0), ZoneOffset.UTC), 60));
        repo.save(new ProteinIntake(OffsetDateTime.of(LocalDateTime.of(2020, 07, 03, 0, 0), ZoneOffset.UTC), 70));
    }

//    @Test
//    public void entryIsSaved() {
//        repository.save()
//
//        assertThat(entryOptional).hasValueSatisfying(entry -> {
//            assertThat(entry.getId()).isNotNull();
//            assertThat(entry.get).isEqualTo("Dave");
//            assertThat(entry.getLastName()).isEqualTo("Syer");
//        });
//    }

    @Test
    public void testRetrieveCertainEntry() {
        addThreeEntries();
        get("/api/intakes/1").then().statusCode(200).assertThat()
                .body("data.measurement", equalTo(50));
    }
}