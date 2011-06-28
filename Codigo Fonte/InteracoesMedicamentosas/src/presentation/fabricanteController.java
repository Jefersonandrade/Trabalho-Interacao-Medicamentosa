package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.FabricanteRepository;
import domainModel.Fabricante;

@WebServlet("/fabricantes")
public class fabricanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declara��o do Reposit�rio
	FabricanteRepository repositorio;
    
	//Construtor do Servlet
    public fabricanteController() {
        super();
        
      //Inicializa��o do Reposit�rio
        repositorio = new FabricanteRepository();
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
					//carrega o Fabricante do BD
					Fabricante fabricante = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o Fabricante para a p�gina JSP
					request.setAttribute("fabricante", fabricante);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
		
			//Chamar P�gina JSP
			RequestDispatcher editar = request.getRequestDispatcher("fabricanteEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o par�metro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o fabricante do BD 
				Fabricante fabricante = repositorio.Open(Integer.parseInt(del));
				
				//Apaga fabricante carregado da base 
				repositorio.Delete(fabricante);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS os fabricantes
		List fabricantes = repositorio.getAllbyName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("fabricantes", fabricantes);
		
		//Chamar a p�gina JSP
		RequestDispatcher listagem = request.getRequestDispatcher("fabricantesListagem.jsp");
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
			
			
			Fabricante fabricante;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				fabricante = repositorio.Open(Integer.parseInt(cod));
			else
				fabricante = new Fabricante();
			
			fabricante.setNome(nome);
			
			repositorio.Save(fabricante);
			
			// Gera uma listagem de fabricantes
			List fabricantes = repositorio.getAllbyName();
			
			// Passa a listagem para a p�gina JSP
			request.setAttribute("fabricantes", fabricantes);
			
			// Chamar a p�gina JSP
			RequestDispatcher listagem = request.getRequestDispatcher("fabricantesListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
			
	}

}
