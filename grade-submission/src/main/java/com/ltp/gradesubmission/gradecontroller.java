package com.ltp.gradesubmission;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class gradecontroller {
  /*List<Grade>studentGrades= Arrays.asList(
          new Grade("harry","bangla","c++"),
          new Grade("hermonie","english","a++"),
          new Grade("nevila","math","b++"),
          new Grade("arif","arithmatic","c++"),
          new Grade("HELLO","india studies","bc++")
  );
   */
    List<Grade>studentGrades=new ArrayList<>();
    @GetMapping("/grades")
    public String getGrades(Model model){
        //Grade grade=new Grade("harry","portion","c++");
        // model.addAttribute("grades",studentGrades);
        //return grades;  (response template html files)
        model.addAttribute("grades",studentGrades);
        return "grades";
    }
    @GetMapping("/shows")
    public ModelAndView getShows(){

        Map<String,Show> model=new HashMap<String,Show>();
        model.put("first",new Show("Braking bad","one",4.99) );
        model.put("second",new Show("GAME OF THRONES","TEW",9.99));
        model.put("thrid",new Show("friends","three",5.99));
        model.put("fourth",new Show("bing bang","firstone",5.99));
        return new ModelAndView("shows",model);
    }
    @GetMapping(value="/")
    public String getCondtion(Model model){
        model.addAttribute("sales",50);
        model.addAttribute("product","chair");
        return "condition";
    }

   @GetMapping("/gradeshow")
    public  String gradeshow(Model model){
       model.addAttribute("grade",new Grade());
        return "form";
   }
   @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade){
    studentGrades.add(grade);
    return "redirect:/grades";
   }
    /*
    * @GetMapping("/")
    * public String gradeForm(Model model){
    * model.addAttribute("grade",new Grade("harry","eng","c++"));
    * return form;
    * }
    * */
    /*
    * @GetMappinng("/shows")
    * public String getShows(Model mode){
    *   mode.addAttributes("first",new Show("harry","two",900));
    * }
    *
    * @GetMapping("/shows")
    * public ModelAndView getShows(){
    *  Map<String,show>mode=new HashMap<String,show>();
    * mode.put("first",new Show("harry","second",90.00));
    * return new ModelAndView("shows",model)
    * }
    *
    * */
}