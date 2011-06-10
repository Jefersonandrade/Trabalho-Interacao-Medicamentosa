package presentation;

import dataAccess.PrincipioAtivoRepository;
import dataAccess.ReacaoRepository;
import domainModel.PrincipioAtivo;
import domainModel.Reacao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reacao")
public class reacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Declara��o do Reposit�rio
	ReacaoRepository reacaorepositorio;
    
	//Construtor do Servlet
    public reacaoController() {
        super();
        
      //Inicializa��o do Reposit�rio
        reacaorepositorio = new ReacaoRepository();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Verificar se o Par�metro edit foi passado
		String edit = request.getParameter("edit");
		
		//Codigo que executa quando o parametro edit � passado
		if(edit!= null){
			if(!edit.equalsIgnoreCase("new")){
				//Converter 
				try{
					//carrega o Reacao do BD
					Reacao reacao = reacaorepositorio.Open(Integer.parseInt(edit));
					
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
				Reacao reacao = reacaorepositorio.Open(Integer.parseInt(del));
				
				//Apaga reacao carregado da base 
				reacaorepositorio.Delete(reacao);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS as reacoes
		List reacoes = reacaorepositorio.getAllByName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("reacao", reacoes);
		
		//Chamar a p�gina JSP
		RequestDispatcher listagem = request.getRequestDispatcher("reacoesListagem.jsp");
		listagem.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
	}

}
