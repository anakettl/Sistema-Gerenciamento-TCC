package br.edu.ifrs.poa.tcc.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "areas-interesse")
public class AreaInteresse extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Descrição é obrigatória")
	@Column(length = 55, nullable = true)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "AreaInteresse [descricao=" + descricao + ", id=" + id + ", isNew()=" + isNew() + "]";
	}
		
}
