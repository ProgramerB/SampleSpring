package Exp.Web.Controller;

import Exp.Web.Model.Bored;
import Exp.Web.Model.Sample;
import Exp.Web.Repository.SampleRepository;
import Exp.Web.Service.ExternalAPI;
import Exp.Web.Service.SampleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SampleController {
//    @Autowired
//    private SampleRepository sampleRepository;

    @Autowired
    private SampleService sampleService;

    @Autowired
    private ExternalAPI externalAPI;

    @GetMapping
    public List<Sample> getAll(){
        return sampleService.getAll();
    }

//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public Sample getById(@PathVariable Integer id){
        return sampleService.getById(id);
    }

    @PostMapping
    public Sample add(@RequestBody Sample sample){
        return sampleService.add(sample);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        sampleService.delete(id);
    }

//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public Sample update(@RequestBody Sample sample){
        return sampleService.update(sample);
    }

    @GetMapping("/check")
    public String check(){
        return "check pass";
    }

    @GetMapping(value = "/bored")
    public Bored getBored(){
        return externalAPI.getBored();
    }
    @GetMapping(value = "/meal",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMeal(){
        return externalAPI.getMeal();
    }
}
