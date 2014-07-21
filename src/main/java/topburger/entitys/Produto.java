package topburger.entitys;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import topburger.infraestrutura.ObjetoPersistente;

@Entity
@Table(name="tbproduto")
public class Produto implements ObjetoPersistente<Integer>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6319913080730816316L;

	@Column(name="procodigo")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="prodescricao")
	private String descricao;
	
	
	@Column(name="provalidade")
	private Timestamp validade;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "produtos")
	private List<Prato> pratos;
	
	@Transient
	private boolean escolhido;


	@Override
	public Integer getCodigo() {
		return this.codigo;
	}
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Timestamp getValidade() {
		return validade;
	}


	public void setValidade(Timestamp validade) {
		this.validade = validade;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public List<Prato> getPratos() {
		return pratos;
	}
	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
	
	
	public boolean isEscolhido() {
		return escolhido;
	}
	public void setEscolhido(boolean escolhido) {
		this.escolhido = escolhido;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((validade == null) ? 0 : validade.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.getDescricao()+this.getCodigo();
	}
	
	

}
