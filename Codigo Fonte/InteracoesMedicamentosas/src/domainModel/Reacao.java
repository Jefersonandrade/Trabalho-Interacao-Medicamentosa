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
	
	@Column(name="pa1")
	private int pa1;
	
	@Column(name="pa2")
	private int pa2;

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

	public int getPa1() {
		return pa1;
	}

	public void setPa1(int pa1) {
		this.pa1 = pa1;
	}

	public int getPa2() {
		return pa2;
	}

	public void setPa2(int pa2) {
		this.pa2 = pa2;
	}
}
