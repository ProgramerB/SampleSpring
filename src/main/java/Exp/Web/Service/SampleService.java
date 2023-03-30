package Exp.Web.Service;

import Exp.Web.Model.Sample;
import Exp.Web.Repository.SampleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public List<Sample> getAll(){
        return sampleRepository.findAll();
    }

    public Sample getById(Integer id){
        return sampleRepository.getReferenceById(id);
    }

    public Sample add(Sample sample){
        return sampleRepository.saveAndFlush(sample);
    }

    public void delete(Integer id){
        sampleRepository.deleteById(id);
    }

    public Sample update(Sample sample){
        Sample sample1 = sampleRepository.getReferenceById(sample.getId());
        BeanUtils.copyProperties(sample,sample1,"id");
        return sampleRepository.saveAndFlush(sample1);
    }
}
