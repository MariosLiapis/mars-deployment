package com.example.mars_deployment.controller;

import com.example.mars_deployment.model.SpaceResources;
import com.example.mars_deployment.repository.SpaceResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing space station resources.
 */
@RestController
@RequestMapping("/resources")
public class SpaceResourceController {

    /**
     * Repository for interacting with SpaceResources.
     */
    @Autowired
    private SpaceResourceRepository repository;

    /**
     * Constructor for injecting the repository.
     *
     * @param repository the resource repository
     */
    public SpaceResourceController(SpaceResourceRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves all resources.
     *
     * @return list of all space resources
     */
    @GetMapping
    public List<SpaceResources> getAll() {
        return repository.findAll();
    }

    /**
     * Creates a new space resource.
     *
     * @param resources the resource to create
     * @return the created resource
     */
    @PostMapping
    public SpaceResources create(@RequestBody SpaceResources resources) {
        return repository.save(resources);
    }

    /**
     * Retrieves a resource by ID.
     *
     * @param id the resource ID
     * @return the resource if found, or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<SpaceResources> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    /**
     * Updates an existing resource by ID.
     *
     * @param id the resource ID
     * @param newResource the updated resource data
     * @return the updated resource, or 404 if not found
     */
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

    /**
     * Deletes a resource by ID.
     *
     * @param id the resource ID
     * @return 204 No Content if deleted, or 404 if not found
     */
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
