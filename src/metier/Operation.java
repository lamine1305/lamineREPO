package metier;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Operation {

	private ArrayList<Produit> produits = new ArrayList<Produit>();

	public ArrayList<Produit> getProduits() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maatalla1","root","maat123alla");
			java.sql.PreparedStatement ps = cn.prepareStatement("SELECT * FROM produit");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Produit p = new Produit();
				p.setId(rs.getLong("id"));
				p.setNom(rs.getString("nom"));
				p.setDesc(rs.getString("desc"));
				p.setPrice(rs.getInt("price"));
				p.setEtat(rs.getInt("etat"));
				produits.add(p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error when trying to add elements into table Produit. Please check that shitty code you put !");
			e.printStackTrace();
		}
		return produits;
	}

	
	
	public void add(Produit p){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maatalla1","root","maat123alla");
			java.sql.PreparedStatement ps = cn.prepareStatement("INSERT INTO  produit VALUES (NULL, ?, ?, ?, ?)");
			ps.setString(1, p.getNom());
			ps.setString(2, p.getDesc());
			ps.setLong(3, p.getPrice());
			ps.setLong(4, p.getEtat());
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error when trying to add elements into table Produit. Please check that shitty code you put !");
			e.printStackTrace();
		}
		// produits.add(p);		
	}
	public void remove(Long id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maatalla1","root","maat123alla");
			java.sql.PreparedStatement ps = cn.prepareStatement("DELETE FROM produit WHERE id = ?");
			ps.setLong(1, id);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error when trying to add elements into table Produit. Please check that shitty code you put !");
			e.printStackTrace();
		}
		/* for(Produit p:produits){
			if(p.getId()==id){
				produits.remove(p);
			break;
			}
		} */
	}
	
}
