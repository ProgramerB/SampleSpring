package Exp.Web.Repository;

import Exp.Web.Model.Sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@DataJpaTest
class SampleRepositoryTest {
    @Autowired
    private SampleRepository sampleRepository;

    @Test
    public void saveSample(){
        Sample sample = Sample.builder().name("Second Sons").build();
        sampleRepository.save(sample);
    }

    @Test
    public void getAllSample(){
        List<Sample> sampleList = sampleRepository.findAll();
        System.out.println("sampleList = " + sampleList);
    }

    @Test
    public void getById(){

        System.out.println(sampleRepository.getReferenceById(2));

    }
}