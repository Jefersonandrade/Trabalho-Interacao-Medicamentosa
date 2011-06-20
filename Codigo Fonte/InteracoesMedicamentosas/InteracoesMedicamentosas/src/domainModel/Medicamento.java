package domainModel;

import javax.persistence.*;

@Entity
@Table(name="medicamentos")
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private int id;

	
	@Column(name="nome")
	private String nome;
	
	/*@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="id_fabricante")
	private Fabricante fabricante;*/
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="id_principioativo")
	private PrincipioAtivo principioativo;
	
	@ManyToOne//(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="id_reacao")
	private Reacao reacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	*/
	public PrincipioAtivo getPrincipioativo() {
		return principioativo;
	}

	public void setPrincipioativo(PrincipioAtivo principioativo) {
		this.principioativo = principioativo;
	}

	public Reacao getReacao() {
		return reacao;
	}

	public void setReacao(Reacao reacao) {
		this.reacao = reacao;
	}
}
