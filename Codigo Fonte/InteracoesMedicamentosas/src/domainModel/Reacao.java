package domainModel;
import javax.persistence.*;

@Entity
@Table(name="reacao")
public class Reacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")//Colocar o que esta no Banco de Dados
	private int id;
	
	@Column(name="descricao")
	private String nome;
		
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="id_pa1")
	private PrincipioAtivo principioativo1;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="id_pa2")
	private PrincipioAtivo principioativo2;

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

	public PrincipioAtivo getPrincipioativo1() {
		return principioativo1;
	}

	public void setPrincipioativo1(PrincipioAtivo principioativo1) {
		this.principioativo1 = principioativo1;
	}

	public PrincipioAtivo getPrincipioativo2() {
		return principioativo2;
	}

	public void setPrincipioativo2(PrincipioAtivo principioativo2) {
		this.principioativo2 = principioativo2;
	}
	
	

}
