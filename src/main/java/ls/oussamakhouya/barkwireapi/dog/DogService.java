package ls.oussamakhouya.barkwireapi.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public Iterable<Dog> list() {
        return dogRepository.findAll();
    }

    public Map<String, Dog> create(Dog dog) {
        Dog savedDog = dogRepository.save(dog);
        return createHashSingular(savedDog);
    }

    private Map<String, Dog> createHashSingular(Dog dog){
        Map<String, Dog> response = new HashMap<String, Dog>();
        response.put("dog", dog);

        return response;
    }

}