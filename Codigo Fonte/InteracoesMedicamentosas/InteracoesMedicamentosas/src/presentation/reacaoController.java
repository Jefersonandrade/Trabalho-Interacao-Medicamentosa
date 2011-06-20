package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.ReacaoRepository;
import domainModel.Reacao;

/**
 * Servlet implementation class reacaoController
 */
@WebServlet("/Reacoes")
public class reacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declara��o do Reposit�rio
	ReacaoRepository repositorio;
    
	//Construtor do Servlet
    public reacaoController() {
        super();
        
      //Inicializa��o do Reposit�rio
        repositorio = new ReacaoRepository();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Verificar se o Par�metro edit foi passado
		String edit = request.getParameter("edit");
		
		//Codigo que executa quando o parametro edit � passado
		if(edit!= null){
			if(!edit.equalsIgnoreCase("new")){
				//Converter 
				try{
					//carrega o Reacao do BD
					Reacao reacao = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o Reacao para a p�gina JSP
					request.setAttribute("reacao", reacao);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
		
			//Chamar P�gina JSP
			RequestDispatcher editar = request.getRequestDispatcher("reacaoEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o par�metro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o Reacao do BD 
				Reacao reacao = repositorio.Open(Integer.parseInt(del));
				
				//Apaga reacao carregado da base 
				repositorio.Delete(reacao);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS as reacoes
		List reacoes = repositorio.getAllByName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("reacoes", reacoes);
		
		//Chamar a p�gina JSP
		RequestDispatcher listagem = request.getRequestDispatcher("reacoesListagem.jsp");
		listagem.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			// Recebe os par�metros do formul�rio
			String cod = request.getParameter("id");
			String nome = request.getParameter("nome");
			
			Reacao reacao;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				reacao = repositorio.Open(Integer.parseInt(cod));
			else
				reacao = new Reacao();
			
			reacao.setNome(nome);
			
			repositorio.Save(reacao);
			
			// Gera uma listagem de rea��es
			List reacoes = repositorio.getAllByName();
			
			// Passa a listagem para a p�gina JSP
			request.setAttribute("reacoes", reacoes);
			
			// Chamar a p�gina JSP
			RequestDispatcher listagem = request.getRequestDispatcher("reacoesListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
			
	}

}
