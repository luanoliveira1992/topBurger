package topburger.entitys;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import topburger.infraestrutura.ObjetoPersistente;

@Entity
@Table(name="tbfuncionario")
public class Funcionario implements ObjetoPersistente<Integer> {
	
	@Id
	@Column(name="funcodigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name="funnome")
	@NotEmpty
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="funtipo",nullable=false)
	private TipoFuncionario tipo;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "funcionarios")
     private List<Venda> vendas;
	
	@Column(name="funtel")
	@Max(11)
	@Min(10)
	private Long telefone;
	
	@Column(name="fundatanascimento")
	private Date dataNascimento;
	
	@Email
	@NotNull
	private String email;
	
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

	public TipoFuncionario getTipo() {
		return tipo;
	}

	public void setTipo(TipoFuncionario tipo) {
		this.tipo = tipo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Venda> getVendas() {
		return vendas;
	}
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}


}
