package org.springframework.samples.app.person;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.app.person.Person;
import org.springframework.samples.app.person.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
class PersonController {

//    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "persons/createOrUpdatePersonForm";
    @Autowired
    private PersonRepository persons;

//    @Autowired
//    public PersonController(PersonRepository appService) {
//        this.persons = appService;
//    }

//    @InitBinder
//    public void setAllowedFields(WebDataBinder dataBinder) {
//        dataBinder.setDisallowedFields("id");
//    }

//    @RequestMapping(value = "/persons/new", method = RequestMethod.GET)
//    public String initCreationForm(Map<String, Object> entity) {
//        Person person = new Person();
//        entity.put("person", person);
//        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//    }

//    @RequestMapping(value = "/persons/new", method = RequestMethod.POST)
//    public String processCreationForm(@Valid Person person, BindingResult result) {
//        if (result.hasErrors()) {
//            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//        } else {
//            this.persons.save(person);
//            return "redirect:/persons/" + person.getId();
//        }
//    }

    @GetMapping("/persons/find")
    public String initFindForm(Model model) {
        model.addAttribute("person", new Person());
        return "persons";
    }

    @GetMapping("/persons")
    public String processFindForm(Person person) {

        Collection<Person> results = persons.findByLastName(person.getLastName());

        person = results.iterator().next();

        return "redirect:/persons/" + person.getId();
    }

//    @RequestMapping(value = "/persons/{ownerId}/edit", method = RequestMethod.GET)
//    public String initUpdateOwnerForm(@PathVariable("ownerId") UUID personId, Model entity) {
//        Person person = this.persons.findById(personId);
//        entity.addAttribute(person);
//        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//    }

//    @RequestMapping(value = "/persons/{personId}/edit", method = RequestMethod.POST)
//    public String processUpdatePersonForm(@Valid Person person, BindingResult result, @PathVariable("personId") UUID personId) {
//        if (result.hasErrors()) {
//            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//        } else {
//            person.setId(personId);
//            this.persons.save(person);
//            return "redirect:/persons/{personId}";
//        }
//    }

    @PostMapping("/persons/{personId}")
    public ModelAndView showPerson(@PathVariable("personId") UUID personId) {
        ModelAndView mav = new ModelAndView("persons/personDetails");
        mav.addObject(persons.findById(personId));
        return mav;
    }
}
