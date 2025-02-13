package com.fabdev.lojavirtual.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fabdev.lojavirtual.entities.Produto;
import com.fabdev.lojavirtual.entities.ProdutoImagem;
import com.fabdev.lojavirtual.repositories.ProdutoImagemRepository;
import com.fabdev.lojavirtual.repositories.ProdutoRepository;

@Service
public class ProdutoImagemService {
	
	@Autowired
	private ProdutoImagemRepository rep;
	
	@Autowired
	private ProdutoRepository repProduto;
	
	
	public List<ProdutoImagem> listarTodas() {
		
		return rep.findAll();
	}
	
	public ProdutoImagem inserir(Long idProduto, MultipartFile file) {
		
		Produto produto = repProduto.findById(idProduto).get();
		
		ProdutoImagem prodImagem = new ProdutoImagem();
		
		try {
			if(!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				String nomeImagem = String.valueOf(idProduto) + file.getOriginalFilename();
				
				Path caminho = Paths.get("C:/dev/workspaces/wSTS/proj-loja-virtual/imagens/" + nomeImagem);
				Files.write(caminho, bytes);
				
				prodImagem.setNome(nomeImagem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		prodImagem.setProduto(produto);
		prodImagem.setDataCriacao(new Date());
		prodImagem = rep.saveAndFlush(prodImagem);
		return prodImagem;		
	}
	
	public ProdutoImagem alterar(ProdutoImagem produtoImagem) {
		
		produtoImagem.setDataAtualizacao(new Date());
		return rep.saveAndFlush(produtoImagem);
	}
	
	public void excluir(Long id) {
		
		ProdutoImagem produtoImagem = rep.findById(id).get();
		
		String nomeImagem = produtoImagem.getNome();
		
		if (nomeImagem != null && !nomeImagem.isEmpty()) {
	        Path caminho = Paths.get("C:/dev/workspaces/wSTS/proj-loja-virtual/imagens/" + nomeImagem);
	        try {
	            Files.deleteIfExists(caminho);
	        } catch (IOException e) {
	            e.printStackTrace(); // Considere usar um logger em produção
	        }
	    }		
		rep.delete(produtoImagem);
	}
}
