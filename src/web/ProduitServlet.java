package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Operation;
import metier.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private Operation op;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
    @Override
	public void init() throws ServletException{
		// op = new Operation();
	} 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Récupérer les informations
     if(request.getParameter("actiontype") == null){
		String ID = request.getParameter("ID");
		String nom = request.getParameter("nom");
		String desc = request.getParameter("desc");;
		String price = request.getParameter("price");;
		String state = request.getParameter("state");;
		//Afficher les informations
		/*PrintWriter pw = response.getWriter();
		pw.println("<html><head><tiltle>Liste des produits</head><body><h3>");
		pw.println(nom+" - "+desc+" - "+price+" - "+state+" .");
		pw.println("</h3></body><html>");*/
		
		// Creation des objets
		Operation op = new Operation();
		// Traitement
		System.out.println("Action = Ajouter produit !");
		op.add(new Produit(Long.parseLong(ID), nom, desc, Integer.parseInt(price), Integer.parseInt(state)));
		System.out.println("Done !");
		ProduitBeans pb = new ProduitBeans();
	     pb.setList(op.getProduits());
		 request.setAttribute("model", pb);
		 request.getRequestDispatcher("index.jsp").forward(request, response);
	
		}
     else{
    	    Operation op = new Operation();
			System.out.println("Action = Supprimer !");
			op.remove(Long.parseLong(request.getParameter("id")));
			ProduitBeans pb = new ProduitBeans();
		     pb.setList(op.getProduits());
			 request.setAttribute("model", pb);
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		}
     
	}

}
