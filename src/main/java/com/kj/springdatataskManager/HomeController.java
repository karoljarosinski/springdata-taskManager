package com.kj.springdatataskManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final taskRepository taskRepository;

    public HomeController(taskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Status status) {
        model.addAttribute("task", new Task());
        List<Task> tasks;
        if (status != null) {
            tasks = taskRepository.findByStatus(status);
        } else {
            tasks = taskRepository.findAll();
        }
        model.addAttribute("tasks", tasks);
        return "home";
    }

    @PostMapping("/add")
    public String add(Task task) {
        task.setStatus(Status.ACTIVE);
        taskRepository.save(task);
        return "redirect:/";
    }

    @PostMapping("/done/{id}")
    public String done(@PathVariable Long id, Task task) {
        taskRepository.markAsComplete(id);
        return "redirect:/";
    }
}
