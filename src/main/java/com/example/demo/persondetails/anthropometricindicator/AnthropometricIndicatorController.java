package com.example.demo.persondetails.anthropometricindicator;

import com.example.demo.person.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@RestController
@RequestMapping("/persondetails")
public class AnthropometricIndicatorController {
    private final AnthropometricIndicatorService service;

    @PostMapping
    public AnthropometricIndicator createAnthropometricIndicator(@RequestBody CreateAnthropometricIndicator createAnthropometricIndicator) {
        return service.createAnthropometricIndicator(createAnthropometricIndicator);
    }
// Dzięki tym trzem poniższym metodą mogę wyświetlać tylko obliczoną wartość bez konieczności tworzenia klasy DTO.
// To rozwiązanie jest potencjalnie ryzykowane biorąc pod uwagę bezpieczeństwo danych i dostęp do nich przez osoby nieautoryzowane.
    @GetMapping("/calculate-bmi/{id}")
    public ResponseEntity<String> calculateBMI(@PathVariable UUID id) {
        AnthropometricIndicator anthropometricIndicator = service.calculateBMI(id);
        String bmi = anthropometricIndicator.getBmi();
        return ResponseEntity.status(HttpStatus.OK).body(bmi);
    }

    @GetMapping("/calculate-ppm/{id}")
    public ResponseEntity<String> calculatePPM(@PathVariable UUID id) {
        AnthropometricIndicator anthropometricIndicator = service.calculatePPM(id);
        String ppm = anthropometricIndicator.getPpm();
        return ResponseEntity.status(HttpStatus.OK).body(ppm);
    }

    @GetMapping("/calculate-cpm/{id}")
    public ResponseEntity<String> calculateCPM(@PathVariable UUID id) {
        AnthropometricIndicator anthropometricIndicator = service.calculateCPM(id);
        String cpm = anthropometricIndicator.getCpm();
        return ResponseEntity.status(HttpStatus.OK).body(cpm);
    }
    //Wyświetlenie wszystkich wskaźników antropometrycznych
    @GetMapping("/{id}")
    public AnthropometricIndicator getAnthropometricIndicator(@PathVariable UUID id) {
        return service.getAnthropometricIndicator(id);
    }
}
/*
Te trzy metody umozliwiają mi wyświetlenie obliczonego parametru, ale oprócz tego parametru wyświetlą się wszystkie inne.
    @GetMapping("/calculate-bmi/{id}")
    public AnthropometricIndicator calculateBMI(@PathVariable UUID id) {
        return service.calculateBMI(id);
    }

    @GetMapping("/calculate-ppm/{id}")
    public AnthropometricIndicator calculatePPM(@PathVariable UUID id) {
        return service.calculatePPM(id);
    }

    @GetMapping("/calculate-cpm/{id}")
    public AnthropometricIndicator calculateCPM(@PathVariable UUID id) {
        return service.calculateCPM(id);
    }
}

 */

    /*
    Metoda do przypisania współczynnika PAL przez użytkownika po jego wyborze (robota Frontendu z wyborem)
    Zmiana tego na stałe przypisanie współczynnika PAL do użykownika (wpływa to na Service i ServiceImpl)
    @GetMapping("/calculate-cpm/{id}")
    public AnthropometricIndicator calculateCPM(@RequestParam EnumPalCoefficient palCoefficient, @PathVariable UUID id) {
        return service.calculateCPM(palCoefficient, id);
        */


