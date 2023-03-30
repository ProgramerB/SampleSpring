package Exp.Web.Service;

import Exp.Web.Model.Bored;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAPI {
    public Bored getBored(){
        final String uri = "http://www.boredapi.com/api/activity";
        RestTemplate restTemplate = new RestTemplate();
        Bored bored = restTemplate.getForObject(uri, Bored.class);
//        Bored bored = new Bored("tp","no",5,6.8,123,"",0.1);
        return bored;
    }

    public String getMeal(){
        final String uri = "https://www.themealdb.com/api/json/v1/1/random.php";
        RestTemplate restTemplate = new RestTemplate();
        String meal = restTemplate.getForObject(uri, String.class);
        return meal;
    }
}
