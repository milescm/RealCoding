package org.cnu.realcoding.weathercrawler.weathercrawler.controller;
import org.cnu.realcoding.weathercrawler.weathercrawler.domain.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class DogController {

    private List<Dog> dogList = new ArrayList<>();


    //http://localhost:8080/dogs 둘다 같은거
                          //http://127.0.0.1:8080.dogs

    //post method , getMethod받을꺼면 getmapping
    //강아지 추가 메소드
    @PostMapping("/dogs")
    public void insertDog(@RequestBody Dog dog){
    dogList.add(dog);


    }

    @GetMapping("/dogs")
    public List<Dog> findAllDogs(){
        return dogList;
    }

//    //여기 다시 해보기
//    @GetMapping("/dogs") //http://localhost:8080/dogs/ian
//    public Dog findDogs(@PathVariable String name){
//        return (Dog) dogList;
//    }

//    @GetMapping("/dogs") //http://localhost:8080/dogs?name=ian
//    public Dog findDogs2(@RequestParam String name){
//        for (int i = 0; i < dogList.size(); i++){
//            if(dogList.get(i).getName().equals(name)){
//                return dogList.get(i);
//            }
//        }
//        return null;
//    }



}
