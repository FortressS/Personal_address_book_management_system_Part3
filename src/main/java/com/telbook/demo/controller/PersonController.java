package com.telbook.demo.controller;

import com.telbook.demo.dao.PersonRepository;
import com.telbook.demo.entity.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonRepository personRepository;

    @Autowired
    public void setCustomerRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping(value = "/add")
    String add(@RequestParam("name") String name,
               @RequestParam("tel") String tel,
               @RequestParam("e-mail") String e_mail,
               @RequestParam("address") String address,
               @RequestParam("QQ") String QQ){
        person person = new person();
        person.setName(name);
        person.setTel(tel);
        person.setEMail(e_mail);
        person.setAddress(address);
        person.setQQ(QQ);

        personRepository.save(person);
        return "redirect:/success";
    }

    @GetMapping("/find")
    List<person> find(String name){
        List<person> personList = personRepository.findByName(name);
        return personList;
    }

    @GetMapping("/isNewTel")
    String isNewTel(String tel){
        List<person> personList = personRepository.findByTel(tel);
        if(personList.isEmpty()) return "new telephone number";
        else return "telephone number already exists!";
    }
}
