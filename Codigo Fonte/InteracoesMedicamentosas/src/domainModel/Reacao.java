package domainModel;
import javax.persistence.*;


@Entity
@Table(name="reacoes")
public class Reacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")//Colocar o que esta no Banco de Dados
	private int id;
	
	@Column(name="descricao")
	private String nome;
		

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
}
