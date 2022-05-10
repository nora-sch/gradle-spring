package fr.eni.demospringbootwebmvc.mmi.controller;

import fr.eni.demospringbootwebmvc.bll.CourseService;
import fr.eni.demospringbootwebmvc.bll.TrainerService;
import fr.eni.demospringbootwebmvc.bo.Course;
import fr.eni.demospringbootwebmvc.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trainers")
@SessionAttributes({"allCourses", "SpringSession"})
public class TrainerController {

    //Injection du TrainerService
    private TrainerService trainerService;
    private CourseService courseService;
    @Autowired
    public TrainerController(TrainerService trainerService, CourseService courseService) {
        this.trainerService = trainerService;
        this.courseService = courseService;
    }

    @GetMapping
    public String allTrainers(Model model) {
        List<Trainer> lstTrainers = trainerService.findAll();
        model.addAttribute("trainers", lstTrainers);
        return "view-trainers";
    }

    @GetMapping("/detail")
    public String detailTrainer(
            @RequestParam(name = "email",
                    required = false,
                    defaultValue = "coach@campus-eni.fr") String emailTrainer, Model model) {
        System.out.println("Le paramètre - " + emailTrainer);
        Trainer trainer = trainerService.findByEmail(emailTrainer);
        // Ajout de l'instance dans le modèle
        model.addAttribute("trainer", trainer);
        //Appel de la méthode de chargement des cours en session
        //loadCourses(model);
        return "view-trainer-form";
    }

    //Pour utiliser le membre required = false
    //Il faut mettre les 2 url supportées +
    @GetMapping({"/detail/variable/", "/detail/variable/{email}"})
    public String detailTrainer2(
            @PathVariable(name = "email", required = false) String emailTrainer) {
    //Il n'est pas possible de passer une valeur par défaut si la variable n'existe pas dans URL
    //Il est possible de le faire par codage en testant null
        if(emailTrainer == null) {
            emailTrainer = "coach@campus-eni.fr";
        }
        System.out.println("La variable - " + emailTrainer);
        //Redirection vers la page d'accueil
        return "redirect:/";
       // return "view-trainer-form";
    }

      /*
        @PostMapping
         public String createOrUpdateTrainer(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String firstName,
            @RequestParam(required = true) String lastName, Model model) {
        System.out.println("Les paramètres");
        System.out.println("Email - " + email);
        System.out.println("FirstName - " + firstName);
        System.out.println("LastName - " + lastName);
            List<Trainer> lstTrainers = trainerService.findAll();
            model.addAttribute("trainers", lstTrainers);
        return "view-trainers";
    }
      */
      @PostMapping
      public String updateTrainer(@ModelAttribute("trainer")Trainer trainer) {
          System.out.println(trainer) ;
          trainerService.update(trainer) ;
          return "redirect:/trainers";
      }



    //Ajout d'un cours au formateur courant
    @PostMapping("/courses")
    public String addCourse(@RequestParam(required = true) String email,
                            @RequestParam(name="addCourse", required = true) String id) {
        Trainer trainer = trainerService.findByEmail(email);
        long idCourse = Long.parseLong(id);
        Course c = courseService.findById(idCourse);
        trainer.getLstCourses().add(c);
        trainerService.update(trainer);
        return "redirect:/trainers/detail?email="+email;
    }

    @ModelAttribute("allCourses")
    public List<Course> getCourses(){
        System.out.println("getCourses");
        return courseService.findAll();
    }

    // Méthode pour charger la liste des cours en session
    /*
    private void loadCourses(Model model) {
        Object sessionAttribute = model.getAttribute("allCourses");
        if (sessionAttribute == null) {
            System.out.println("Chargement en session de tous les cours");
            model.addAttribute("allCourses", courseService.findAll());
        }
    }
    */

}
