package br.ifsul.edu.br.repository;

import br.ifsul.edu.br.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class AnimalRepository {

    private final ArrayList<Animal> animais = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    public AnimalRepository() {
        animais.add(new Animal(
                contadorId.getAndIncrement(),
                "Bidu", "Cachorro", "Labrador",
                "Cachorro dócil, usa coleira vermelha. Fugiu durante tempestade.",
                "https://media.istockphoto.com/id/532320781/pt/foto/labrador-dourado-cachorrinho-com-coleira-vermelha.jpg?s=170667a&w=0&k=20&c=gnIPQE56p1WBuwSFHCqUdLZ_8ya4EYmsZmUkJ4Y49r0=",
                "Porto Alegre", "(51) 94002-8922", "Perdido", "05/11/2024"
        ));
        animais.add(new Animal(
                contadorId.getAndIncrement(),
                "Lara", "Gato", "Siamês",
                "Gatinha tímida, olhos azuis, possui microchip.",
                "https://redesuldenoticias.com.br/content/uploads/2018/05/mimi2.jpg",
                "Canoas", "(51) 91234-5678", "Perdido", "07/12/2024"
        ));
        animais.add(new Animal(
                contadorId.getAndIncrement(),
                "Bolinha", "Cachorro", "Poodle",
                "Encontrado na Av. Independência sem coleira, muito raivoso.",
                "https://i.redd.it/yui73z7872b71.jpg",
                "São Leopoldo", "(51) 96666-7777", "Encontrado", "18/02/2025"
        ));
        animais.add(new Animal(
                contadorId.getAndIncrement(),
                "Luna", "Cachorro", "Akita",
                "Cachorro brincalhão e agitado, possui coleira rosa, encontrada correndo no Parque do trabalhador.",
                "https://i.pinimg.com/736x/e8/7c/25/e87c25e9a32bda9020eb462fac8f9f32.jpg",
                "São Leopoldo", "(51) 94002-8922", "Encontrado", "01/05/2026"
        ));
        animais.add(new Animal(
                contadorId.getAndIncrement(),
                "Didi", "Gato", "Persa",
                "Gato irritado e ranzinza, sem coleira ou qualquer identificação.",
                "https://static.vecteezy.com/ti/fotos-gratis/p2/11382064-o-gato-persa-amarelo-deitado-no-chao-gratis-foto.jpg",
                "Sapucaia do Sul", "(51) 96666-7777", "Perdido", "24/07/2025"
        ));
        animais.add(new Animal(
                contadorId.getAndIncrement(),
                "Bud", "Cachorro", "Vira-Lata",
                "Cachorro calmo e carinhoso, visto pela última vez no centro de Sapucaia do Sul",
                "https://adotar.com.br/upload/2018-11/animais_imagem402494.jpg",
                "Sapucaia do Sul", "(51) 94002-8922", "Perdido", "20/09/2025"
        ));
    }

    public List<Animal> listarTodos() {
        return new ArrayList<>(animais);
    }

    public Optional<Animal> buscarPorId(Long id) {
        return animais.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    public List<Animal> buscarPorEspecie(String especie) {
        return animais.stream()
                .filter(a -> a.getEspecie().equalsIgnoreCase(especie))
                .collect(Collectors.toList());
    }

    public List<Animal> buscarPorStatus(String status) {
        return animais.stream()
                .filter(a -> a.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public Animal salvar(Animal animal) {
        animal.setId(contadorId.getAndIncrement());
        animais.add(animal);
        return animal;
    }

    public boolean remover(Long id) {
        return animais.removeIf(a -> a.getId().equals(id));
    }
}