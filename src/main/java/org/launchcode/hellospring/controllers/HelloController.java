package org.launchcode.hellospring.controllers;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")

public class HelloController {

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Sri";
    }

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST},value={"hello"})
    @ResponseBody
    public String helloWithRequestParam(@RequestParam String name){
        return "Hello "+ name;
    }

    @GetMapping("hello/{value}")
    @ResponseBody
    public String helloWithPathVariable(@PathVariable String value){
        return "Hello " + value + "!";
    }

    @GetMapping("form")
    public String formSubmit(){
        return "form";
    }

    @PostMapping("languages")
    @ResponseBody
    public static String greetingBasedOnLanguage(@RequestParam String greetingName, @RequestParam String language){
        String greeting = " ";
        switch (language){
            case "French":
                greeting = "Bonjour "+ greetingName;
                break;
            case "Mandarin":
                greeting = "ni hao "+ greetingName;
                break;
            case "Tamil":
                greeting = "Vanakkam "+ greetingName;
                break;
            case "English":
                greeting = "Greeting "+ greetingName;
                break;
            case "Hindi":
                greeting = "Namaste "+ greetingName;
                break;
        }
        return "<html>"+
                "<body style='background-color:DodgerBlue;'>" +
                "<h1 style ='color: green;'>" + greeting+ "</h1>"+
                "</body>" +
                "</html>";
    }

    @GetMapping("greetingform")
    @ResponseBody
    public String greetingform(){
        return "<html>"+
                "<body>"+
                "<form method= 'post' action= 'languages'>"+
                "<input type= 'text' name= 'greetingName'/>"+
                "<label for='language'></label>"+
                "<select name='language' id='language'>" +
                "    <option value='Hindi'>Hindi</option>" +
                "    <option value='Tamil'>Tamil</option>" +
                "    <option value='Mandarin'>Mandarin</option>" +
                "    <option value='English'>English</option>" +
                "    <option value='French'>French</option>" +
                "</select>" +
                "<input type= 'submit' value= 'Greet me'/>" +
                "</form>"+
                "</body>"+
                "</html>";
    }

}
