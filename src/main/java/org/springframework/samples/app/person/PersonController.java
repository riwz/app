//package org.springframework.samples.app.owner;
//
//import java.util.Collection;
//import java.util.Map;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//class OwnerController {
//
//    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
//    private final OwnerRepository owners;
//
//    @Autowired
//    public OwnerController(OwnerRepository clinicService) {
//        this.owners = clinicService;
//    }
//
//    @InitBinder
//    public void setAllowedFields(WebDataBinder dataBinder) {
//        dataBinder.setDisallowedFields("id");
//    }
//
//    @RequestMapping(value = "/owners/new", method = RequestMethod.GET)
//    public String initCreationForm(Map<String, Object> entity) {
//        Person person = new Person();
//        entity.put("person", person);
//        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//    }
//
//    @RequestMapping(value = "/owners/new", method = RequestMethod.POST)
//    public String processCreationForm(@Valid Person person, BindingResult result) {
//        if (result.hasErrors()) {
//            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//        } else {
//            this.owners.save(person);
//            return "redirect:/owners/" + person.getId();
//        }
//    }
//
//    @RequestMapping(value = "/owners/find", method = RequestMethod.GET)
//    public String initFindForm(Map<String, Object> entity) {
//        entity.put("person", new Person());
//        return "owners/findOwners";
//    }
//
//    @RequestMapping(value = "/owners", method = RequestMethod.GET)
//    public String processFindForm(Person person, BindingResult result, Map<String, Object> entity) {
//
//        // allow parameterless GET request for /owners to return all records
//        if (person.getLastName() == null) {
//            person.setLastName(""); // empty string signifies broadest possible search
//        }
//
//        // find owners by last name
//        Collection<Person> results = this.owners.findByLastName(person.getLastName());
//        if (results.isEmpty()) {
//            // no owners found
//            result.rejectValue("lastName", "notFound", "not found");
//            return "owners/findOwners";
//        } else if (results.size() == 1) {
//            // 1 person found
//            person = results.iterator().next();
//            return "redirect:/owners/" + person.getId();
//        } else {
//            // multiple owners found
//            entity.put("selections", results);
//            return "owners/ownersList";
//        }
//    }
//
//    @RequestMapping(value = "/owners/{ownerId}/edit", method = RequestMethod.GET)
//    public String initUpdateOwnerForm(@PathVariable("ownerId") int ownerId, Model entity) {
//        Person person = this.owners.findById(ownerId);
//        entity.addAttribute(person);
//        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//    }
//
//    @RequestMapping(value = "/owners/{ownerId}/edit", method = RequestMethod.POST)
//    public String processUpdateOwnerForm(@Valid Person person, BindingResult result, @PathVariable("ownerId") int ownerId) {
//        if (result.hasErrors()) {
//            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//        } else {
//            person.setId(ownerId);
//            this.owners.save(person);
//            return "redirect:/owners/{ownerId}";
//        }
//    }
//
//    /**
//     * Custom handler for displaying an person.
//     *
//     * @param ownerId the ID of the person to display
//     * @return a ModelMap with the entity attributes for the view
//     */
//    @RequestMapping("/owners/{ownerId}")
//    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
//        ModelAndView mav = new ModelAndView("owners/ownerDetails");
//        mav.addObject(this.owners.findById(ownerId));
//        return mav;
//    }
//}
