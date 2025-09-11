package com.cesurg.enchentes.infra.controller;

import com.cesurg.enchentes.core.domain.contract.produto.ProdutoUseCase;
import com.cesurg.enchentes.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProdutoController {
    @Autowired
    private ProdutoUseCase produtoUseCase;

    @PostMapping("/produto/cadastro")
    public void create(@RequestBody Produto produto) {
        produtoUseCase.create(produto);
    }

    @GetMapping("/produto")
    public List<Produto> read(){
        return produtoUseCase.read();
    }

    @PutMapping("/produto/{id}")
    public void update(@RequestBody Produto produto, @PathVariable int id) {
        produtoUseCase.update(id, produto);
    }

    @DeleteMapping("/produto/delete/{id}")
    public void delete(@PathVariable int id) {
        produtoUseCase.delete(id);
    }
}
