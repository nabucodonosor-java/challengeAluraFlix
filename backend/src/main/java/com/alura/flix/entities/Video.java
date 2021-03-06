package com.alura.flix.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alura.flix.dto.VideoDto;

@Entity
@Table(name = "tb_video")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String titulo;

	private String descricao;

	private String url;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Video() {
	}

	public Video(Long id, String titulo, String descricao, String url, Categoria categoria) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
		this.categoria = categoria;
	}
	
	public Video(Long id, String titulo, String descricao, String url) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
	}
	
	public Video(String titulo, String descricao, String url, Categoria categoria) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
		this.categoria = categoria;
	}
	
	public Video(VideoDto dto) {
		
		id = dto.getId();
		titulo = dto.getTitulo();
		descricao = dto.getDescricao();
		url = dto.getUrl();
		Long categoriaId = categoria.getId();
		dto.setCategoriaId(categoriaId);
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
