package com.todo_list.backendspringboot.controller;

import com.todo_list.backendspringboot.entity.Stat;
import com.todo_list.backendspringboot.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stat")
public class StatController {
    //TODO add logger for controller
    private final StatService statRepository;
    private final Long defaultId = 1L;

    public StatController(StatService statRepository) {
        this.statRepository = statRepository;
    }

    @GetMapping("")
    public ResponseEntity<Stat> findById() {
        return ResponseEntity.ok(statRepository.findById(defaultId));
    }
}
