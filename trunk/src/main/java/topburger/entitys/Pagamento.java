package topburger.entitys;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.TimestampType;

@Entity
@Table(name="tbpagamento")
public class Pagamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pagcodigo")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="pagnatureza",referencedColumnName="natcodigo")
	private Natureza natureza;
	
	@ManyToOne
	@JoinColumn(name="pagfornecedor",referencedColumnName="forcodigo")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="pagfuncionario",referencedColumnName="funcodigo")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="pagvenda",referencedColumnName="vendcodigo")
	private Venda venda;
	
	@Column(name="pagvalor")
	private BigDecimal valor;
	
	@Column(name="pagdata")
	private TimestampType data;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Natureza getNatureza() {
		return natureza;
	}

	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TimestampType getData() {
		return data;
	}

	public void setData(TimestampType data) {
		this.data = data;
	}

}
