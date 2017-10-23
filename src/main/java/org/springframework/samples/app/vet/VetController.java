//package org.springframework.samples.app.vet;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//class VetController {
//
//    private final VetRepository vets;
//
//    @Autowired
//    public VetController(VetRepository clinicService) {
//        this.vets = clinicService;
//    }
//
//    @RequestMapping(value = { "/vets.html" })
//    public String showVetList(Map<String, Object> entity) {
//        // Here we are returning an object of type 'Vets' rather than a collection of Vet
//        // objects so it is simpler for Object-Xml mapping
//        Vets vets = new Vets();
//        vets.getVetList().addAll(this.vets.findAll());
//        entity.put("vets", vets);
//        return "vets/vetList";
//    }
//
//    @RequestMapping(value = { "/vets.json", "/vets.xml" })
//    public @ResponseBody Vets showResourcesVetList() {
//        // Here we are returning an object of type 'Vets' rather than a collection of Vet
//        // objects so it is simpler for JSon/Object mapping
//        Vets vets = new Vets();
//        vets.getVetList().addAll(this.vets.findAll());
//        return vets;
//    }
//
//}
