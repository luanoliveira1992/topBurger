package topburger.entitys;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import topburger.infraestrutura.ObjetoPersistente;

@Entity
@Table(name="tbnatureza")
public class Natureza implements ObjetoPersistente<Integer> {
	
	@Id
	@Column(name="natcodigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="natdescricao")
	private String descricao;
	
	@Column(name="natultimaatualizacao")
	@Version
	private Timestamp ultAtualizacao;
	
	

	@Override
	public Integer getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getId() {
		return codigo;
	}



	public void setId(Integer codigo) {
		this.codigo = codigo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Timestamp getUltAtualizacao() {
		return ultAtualizacao;
	}



	public void setUltAtualizacao(Timestamp ultAtualizacao) {
		this.ultAtualizacao = ultAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Natureza other = (Natureza) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

}
