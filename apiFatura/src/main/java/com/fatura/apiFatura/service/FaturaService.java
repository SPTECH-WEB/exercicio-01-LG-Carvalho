package com.fatura.apiFatura.service;

import com.fatura.apiFatura.model.Fatura;
import com.fatura.apiFatura.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {
    private final FaturaRepository faturaRepository;
    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }


    public List<Fatura> listarTodos(){
        return faturaRepository.findAll();
    }

    public Optional<Fatura> buscarPorId(Long id){
        return faturaRepository.findById(id);
    }

    public Fatura salvar(Fatura fatura){
        return faturaRepository.save(fatura);
    }
}
