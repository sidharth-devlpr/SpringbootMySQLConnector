package com.example.MySQLSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MySQLController {
    @Autowired
    MySQLRepository mySQLRepository;

    @PostMapping("/addPerson")
    public ResponseEntity<String> addPerson(@RequestBody Person person){
            if (mySQLRepository.findById(person.getIndex()).equals(Optional.empty())) {
                mySQLRepository.save(person);
                return new ResponseEntity<>("Item Saved", HttpStatus.OK);
            }
            else throw new ItemAlreadyExists("try the update link");

//        return new ResponseEntity<>("Id already exists",HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getAll")
    public List<Person> getAll(){
        return mySQLRepository.findAll();
    }

    @GetMapping("/getbyid/{Id}")
    public Person getById(@PathVariable("Id") Integer id){
        return mySQLRepository.findById(id).get();
    }
}
