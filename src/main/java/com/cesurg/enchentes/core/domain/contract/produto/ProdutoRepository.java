package com.cesurg.enchentes.core.domain.contract.produto;

import com.cesurg.enchentes.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoRepository {
    public void create(Produto produto);
    public List<Produto> read();
    public void update(int id, Produto produto);
    public void delete(int id);
}
