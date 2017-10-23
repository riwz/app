//package org.springframework.samples.app.owner;
//
//import java.util.Collection;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.util.StringUtils;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping("/owners/{ownerId}")
//class PetController {
//
//    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
//    private final PetRepository pets;
//    private final OwnerRepository owners;
//
//    @Autowired
//    public PetController(PetRepository pets, OwnerRepository owners) {
//        this.pets = pets;
//        this.owners = owners;
//    }
//
//    @ModelAttribute("types")
//    public Collection<PetType> populatePetTypes() {
//        return this.pets.findPetTypes();
//    }
//
//    @ModelAttribute("person")
//    public Person findOwner(@PathVariable("ownerId") int ownerId) {
//        return this.owners.findById(ownerId);
//    }
//
//    @InitBinder("person")
//    public void initOwnerBinder(WebDataBinder dataBinder) {
//        dataBinder.setDisallowedFields("id");
//    }
//
//    @InitBinder("pet")
//    public void initPetBinder(WebDataBinder dataBinder) {
//        dataBinder.setValidator(new PetValidator());
//    }
//
//    @RequestMapping(value = "/pets/new", method = RequestMethod.GET)
//    public String initCreationForm(Person person, ModelMap entity) {
//        Pet pet = new Pet();
//        person.addPet(pet);
//        entity.put("pet", pet);
//        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
//    }
//
//    @RequestMapping(value = "/pets/new", method = RequestMethod.POST)
//    public String processCreationForm(Person person, @Valid Pet pet, BindingResult result, ModelMap entity) {
//        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && person.getPet(pet.getName(), true) != null){
//            result.rejectValue("name", "duplicate", "already exists");
//        }
//        if (result.hasErrors()) {
//            entity.put("pet", pet);
//            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
//        } else {
//            person.addPet(pet);
//            this.pets.save(pet);
//            return "redirect:/owners/{ownerId}";
//        }
//    }
//
//    @RequestMapping(value = "/pets/{petId}/edit", method = RequestMethod.GET)
//    public String initUpdateForm(@PathVariable("petId") int petId, ModelMap entity) {
//        Pet pet = this.pets.findById(petId);
//        entity.put("pet", pet);
//        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
//    }
//
//    @RequestMapping(value = "/pets/{petId}/edit", method = RequestMethod.POST)
//    public String processUpdateForm(@Valid Pet pet, BindingResult result, Person person, ModelMap entity) {
//        if (result.hasErrors()) {
//            pet.setOwner(person);
//            entity.put("pet", pet);
//            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
//        } else {
//            person.addPet(pet);
//            this.pets.save(pet);
//            return "redirect:/owners/{ownerId}";
//        }
//    }
//
//}
