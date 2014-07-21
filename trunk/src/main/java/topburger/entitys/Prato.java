package topburger.entitys;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import topburger.infraestrutura.ObjetoPersistente;

@Entity
@Table(name="tbprato")
public class Prato implements ObjetoPersistente<Integer> {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pracodigo")
	private Integer codigo;
	
	@Column(name="pranome")
	@NotEmpty
	private String nome;
	
	@NotNull
	@Column(name="pravalor")
	private BigDecimal valor;
	
	@Column(name="pravalorcalorico")
	private String valorCalorico;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbpratoproduto", joinColumns = { 
			@JoinColumn(name = "pracodigo", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "prodcodigo", 
					nullable = false, updatable = false) })
	@JoinColumn(name="praproduto", nullable=true)
	private List<Produto> produtos;

	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "pratos")
    private List<Venda> vendas;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getValorCalorico() {
		return valorCalorico;
	}
	public void setValorCalorico(String valorCalorico) {
		this.valorCalorico = valorCalorico;
	}
	public List<Venda> getVendas() {
		return vendas;
	}
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
