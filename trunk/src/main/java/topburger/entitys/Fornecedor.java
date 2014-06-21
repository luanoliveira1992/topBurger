package topburger.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import topburger.infraestrutura.ObjetoPersistente;

@Entity
@Table(name="tbfornecedor")
public class Fornecedor implements ObjetoPersistente<Integer> {
	
	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="forcodigo")
	private Integer codigo;
	
	@Column(name="forrazaosocial")
	private String razaosocial;
	
	@Column(name="forcnpj")
	private String cnpj;
	
	@Column(name="forcpf")
	private String cpf;
	
	@Column(name="forcontatoTelefonico")
	private String contatoTelefonico;
	
	@Column(name="foremail")
	private String email;

	@Override
	public Integer getCodigo() {
		return this.codigo;
	}
	
	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getContatoTelefonico() {
		return contatoTelefonico;
	}

	public void setContatoTelefonico(String contatoTelefonico) {
		this.contatoTelefonico = contatoTelefonico;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		Fornecedor other = (Fornecedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	

}
