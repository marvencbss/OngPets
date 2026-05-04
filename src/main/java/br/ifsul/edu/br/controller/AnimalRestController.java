package br.ifsul.edu.br.controller;

import br.ifsul.edu.br.model.Animal;
import br.ifsul.edu.br.repository.AnimalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animais")
public class AnimalRestController {

    private final AnimalRepository repository;

    public AnimalRestController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Animal> listar(
            @RequestParam(required = false) String especie,
            @RequestParam(required = false) String status) {

        if (especie != null) {
            return repository.buscarPorEspecie(especie);
        } else if (status != null) {
            return repository.buscarPorStatus(status);
        } else {
            return repository.listarTodos();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Long id) {
        Optional<Animal> animal = repository.buscarPorId(id);
        if (animal.isPresent()) {
            return ResponseEntity.ok(animal.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody Animal animal) {
        Animal salvo = repository.salvar(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        boolean removido = repository.remover(id);
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}