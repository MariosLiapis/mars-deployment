package com.example.mars_deployment.controller;

import com.example.mars_deployment.model.SpaceResources;
import com.example.mars_deployment.repository.SpaceResourceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class SpaceResourceController {

    private final SpaceResourceRepository repository;

    public SpaceResourceController(SpaceResourceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SpaceResources> getAll(){
        return repository.findAll();
    }

    @PostMapping
    public SpaceResources create(@RequestBody SpaceResources resources) {
        return repository.save(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpaceResources> getById(@PathVariable Long id) {
        return repository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpaceResources> update(@PathVariable Long id, @RequestBody SpaceResources newResource) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(newResource.getName());
                    existing.setQuantity(newResource.getQuantity());
                    SpaceResources updated = repository.save(existing);
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repository.findById(id)
        .map(resource -> {
            repository.delete(resource);
            return ResponseEntity.noContent().<Void>build();
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
