package br.ifsul.edu.br.controller;

import br.ifsul.edu.br.model.Animal;
import br.ifsul.edu.br.repository.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AnimalController {

    private final AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/animais")
    public String listar(
            @RequestParam(required = false) String especie,
            @RequestParam(required = false) String status,
            Model model) {

        if (especie != null) {
            model.addAttribute("animais", repository.buscarPorEspecie(especie));
            model.addAttribute("filtroEspecie", especie);
        } else if (status != null) {
            model.addAttribute("animais", repository.buscarPorStatus(status));
            model.addAttribute("filtroStatus", status);
        } else {
            model.addAttribute("animais", repository.listarTodos());
        }

        return "animais/lista";
    }

    @GetMapping("/animais/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Optional<Animal> animal = repository.buscarPorId(id);
        if (animal.isPresent()) {
            model.addAttribute("animal", animal.get());
            return "animais/detalhes";
        } else {
            return "redirect:/animais";
        }
    }

    @GetMapping("/animais/novo")
    public String formulario(Model model) {
        model.addAttribute("animal", new Animal());
        return "animais/formulario";
    }

    @PostMapping("/animais")
    public String salvar(@ModelAttribute Animal animal) {
        repository.salvar(animal);
        return "redirect:/animais";
    }

    @PostMapping("/animais/{id}/remover")
    public String remover(@PathVariable Long id) {
        repository.remover(id);
        return "redirect:/animais";
    }
}