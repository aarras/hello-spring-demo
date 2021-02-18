package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Adam Arras
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    /*
    // Handles request at path /hello/hello
    @GetMapping("hello")
    public String hello() { return "Hello, Spring!"; }
    */

    // Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() { return "Goodbye, Spring!"; }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) { return "Hello, " + name + "!"; }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) { return "Hello, " + name + "!"; }

    /*
    // Handles request of the form /hello/form
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

    // Handles request of the form with POST method at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" + // submit a request to /hello
                            "<input type='text' name='name'>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }


}
