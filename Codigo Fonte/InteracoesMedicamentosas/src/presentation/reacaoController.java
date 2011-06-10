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
       
	//Declaração do Repositório
	ReacaoRepository reacaorepositorio;
    
	//Construtor do Servlet
    public reacaoController() {
        super();
        
      //Inicialização do Repositório
        reacaorepositorio = new ReacaoRepository();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Verificar se o Parâmetro edit foi passado
		String edit = request.getParameter("edit");
		
		//Codigo que executa quando o parametro edit é passado
		if(edit!= null){
			if(!edit.equalsIgnoreCase("new")){
				//Converter 
				try{
					//carrega o Reacao do BD
					Reacao reacao = reacaorepositorio.Open(Integer.parseInt(edit));
					
					//Passa o Reacao para a página JSP
					request.setAttribute("reacao", reacao);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
		
			//Chamar Página JSP
			RequestDispatcher editar = request.getRequestDispatcher("reacaoEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o parâmetro del foi passado
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
		
		//Chamar a página JSP
		RequestDispatcher listagem = request.getRequestDispatcher("reacoesListagem.jsp");
		listagem.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
	}

}
