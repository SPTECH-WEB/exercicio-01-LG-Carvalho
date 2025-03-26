package com.fatura.apiFatura.controller;

import com.fatura.apiFatura.model.Fatura;
import com.fatura.apiFatura.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;
    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping
    public List<Fatura> listarFaturas() {
        return faturaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fatura> buscarFatura(@PathVariable Long id) {
        Optional<Fatura> fatura = faturaService.buscarPorId(id);
        return fatura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fatura> criarFatura(@Valid @RequestBody Fatura fatura) {
        Fatura novaFatura = faturaService.salvar(fatura);
        return ResponseEntity.ok(novaFatura);
    }
}
