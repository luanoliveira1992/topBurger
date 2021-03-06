

package topburger.entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import topburger.infraestrutura.ObjetoPersistente;

@Entity
@Table(name="tbtipofuncionario")
public class TipoFuncionario implements ObjetoPersistente<Integer> {
	@Id
	@Column(name="tpfcodigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="tpfdescricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="nivcodigo",name="nivnivel")
	private NivelCargo nivel;
	
	@OneToMany()
	private List<Funcionario> funcionarios;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public NivelCargo getNivel() {
		return nivel;
	}
	public void setNivel(NivelCargo nivel) {
		this.nivel = nivel;
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(!(this instanceof TipoFuncionario)){
			return false;
		}
		if(this.getCodigo() != ((TipoFuncionario)obj).codigo){
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
        .append(codigo).toHashCode();
		
	}
	@Override
	public String toString() {
		return this.getDescricao()+"-"+this.getCodigo()+"-"+getNivel();
	}
	
	
}
