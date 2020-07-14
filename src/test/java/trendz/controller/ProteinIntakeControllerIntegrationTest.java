package trendz.controller;

import dbConfig.DbConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import trendz.repository.ProteinIntakeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DbConfig.class})
@ActiveProfiles("DaoTest")
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:dao/TestData.sql")
public class PostgresEmbeddedDaoTestingApplicationTests {
    @Autowired
    private ProteinIntakeRepository repo;
    @Test
    public void testCustomerSave() {
        repo.save(Customer.builder()
                .id(new Random().nextLong())
                .address("brussels")
                .name("TestName")
                .build());
        Assert.assertTrue(repo.findCustomerByName("TestName") != null);
    }
}
