package ru.mirea.practice24.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.practice24.services.BackupService;

@Controller
@RequiredArgsConstructor
public class BackupController {

    private final BackupService backupService;

    @RequestMapping(value = "/backup")
    public String backup() {
        backupService.backup();
        return "redirect:/home";
    }
}
