package org.example.controller;

import org.example.entity.Library;
import org.example.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;

    @GetMapping("")
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Library> getLibraryById(@PathVariable("id") Long id){
        return libraryRepository.findById(id);
    }

    @PostMapping("")
    public Library createLibrary(@RequestBody Library library){
        return  libraryRepository.saveAndFlush(library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id) {

        libraryRepository.deleteById(id);
    }



}
