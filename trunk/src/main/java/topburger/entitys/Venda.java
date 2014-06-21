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
import javax.persistence.Table;

import org.hibernate.type.TimestampType;

import topburger.infraestrutura.ObjetoPersistente;

@Entity
@Table(name="tbvenda")
public class Venda implements ObjetoPersistente<Integer> {
	
	@Id
	@Column(name="vendcodigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbvendamesa", joinColumns = { 
			@JoinColumn(name = "vendcodigo", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "mescodigo", 
					nullable = false, updatable = false) })
	private List<Mesa> mesas;
	
	
	@Column(name="vendbalcao")
	private Boolean balcao;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbvendafuncionario", joinColumns = { 
			@JoinColumn(name = "vendcodigo", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "funcodigo", 
					nullable = false, updatable = false) })
	private List<Funcionario> funcionarios;
	@Column(name="venfuncionarios")
	private BigDecimal valor;
	
	@Column(name="vendatavenda")
	private TimestampType dataVenda;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbvendaprato", joinColumns = { 
			@JoinColumn(name = "vendcodigo", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "pracodigo", 
					nullable = false, updatable = false) })
	private List<Prato> pratos;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public List<Mesa> getMesas() {
		return mesas;
	}
	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
	public Boolean getBalcao() {
		return balcao;
	}
	public void setBalcao(Boolean balcao) {
		this.balcao = balcao;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TimestampType getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(TimestampType dataVenda) {
		this.dataVenda = dataVenda;
	}
	public List<Prato> getPratos() {
		return pratos;
	}
	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
	
	

}
