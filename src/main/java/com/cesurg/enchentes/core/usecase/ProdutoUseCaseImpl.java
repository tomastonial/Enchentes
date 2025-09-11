package com.cesurg.enchentes.core.usecase;

import com.cesurg.enchentes.core.domain.contract.produto.ProdutoRepository;
import com.cesurg.enchentes.core.domain.contract.produto.ProdutoUseCase;
import com.cesurg.enchentes.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {
    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public void create(Produto produto) {
        produtoRepository.create(produto);
    }

    @Override
    public List<Produto> read() {
        return produtoRepository.read();
    }

    @Override
    public void update(int id, Produto produto) {
        produtoRepository.update(id, produto);
    }

    @Override
    public void delete(int id) {
        produtoRepository.delete(id);
    }
}
