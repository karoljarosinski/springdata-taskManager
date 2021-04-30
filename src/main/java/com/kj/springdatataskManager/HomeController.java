package com.kj.springdatataskManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final TaskRepositorium taskRepositorium;

    public HomeController(TaskRepositorium taskRepositorium) {
        this.taskRepositorium = taskRepositorium;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Status status) {
        model.addAttribute("task", new Task());
        List<Task> tasks = new ArrayList<>();
        if (status != null) {
            tasks = taskRepositorium.findByStatus(status);
        } else {
            tasks = taskRepositorium.findAll();
        }
        model.addAttribute("tasks", tasks);
        return "home";
    }

    @PostMapping("/add")
    public String add(Task task) {
        task.setStatus(Status.ACTIVE);
        taskRepositorium.save(task);
        return "redirect:/";
    }

    @PostMapping("/done")
    public String done(Task task) {
        return "redirect:/";
    }
}
