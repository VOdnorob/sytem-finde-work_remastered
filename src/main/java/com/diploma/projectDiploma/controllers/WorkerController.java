package com.diploma.projectDiploma.controllers;

import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.services.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/createWorker")
    public Worker createWorker(@Valid @RequestBody Worker worker) {
        return workerService.createWorker(worker);
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYER')")
    @GetMapping("/findWorker")
    public List<Worker> getAllWorkers() {
        return workerService.findAllWorkers();
    }


}



