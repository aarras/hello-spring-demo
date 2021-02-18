package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam Arras
 */
@Controller
//@ResponseBody
//@RequestMapping("hello")
public class HelloController {

    /*
    // Handles request at path /hello
    @GetMapping("hello")
    public String hello() { return "Hello, Spring!"; }
    */

    // Handles request at path /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() { return "Goodbye, Spring!"; }

    /*
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) { return "Hello, " + name + "!"; }
    */

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    /*
    // Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) { return "Hello, " + name + "!"; }
    */

    // Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    /*
    // Handles request of the form /form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='hello'>" + // submit a request to /hello
                            "<input type='text' name='name'>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }
    */

    /*
    // Handles request of the form with POST method at /form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" + // submit a request to /hello
                            "<input type='text' name='name'>" +
                            "<input type='submit' value='Greet Me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }
    */

    // Handles request of the form with POST method at /form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
