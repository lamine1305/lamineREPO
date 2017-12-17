<%@page import="metier.Operation"%>
<%@ page import="web.ProduitBeans" %>
<%@ page import="metier.Produit" %>
<%@ page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Project by Maatalla</title>
</head>
<body>
   <%
     ProduitBeans produits;
     if(request.getAttribute("model") != null)
     produits = (ProduitBeans) request.getAttribute("model");
     else{
    	 Operation o = new Operation();
    	 produits = new ProduitBeans();
    	 produits.setList(o.getProduits());
     }
   
   %>
  
  <h3>Hello again, we're back with Java EE  :D  Let's go !</h3>
  <h5>Ajouter un nouveau produit:</h5>
 <form action="prodserv" method="post">
  <table border="1" width="50%" align="center">
   <tr>
     <td>ID</td>
     <td><input type="text" name="ID"></td>
   </tr>
   <tr>
     <td>Nom</td>
     <td><input type="text" name="nom"></td>
   </tr>
   <tr>
     <td>Description</td>
     <td><input type="text" name="desc"></td>
   </tr>
   <tr>
     <td>Prix</td>
     <td><input type="text" name="price"></td>
   </tr>
   <tr>
     <td>Etat</td>
     <td><input type="text" name="state"></td>
   </tr>
   <tr>
     <td colspan="2"><input type="submit" value="Valider" /></td>
   </tr>
  </table>
 </form>
 <table border="1" width="60%" align="center">
   <tr>
    <th>ID</th>
    <th>Nom</th>
    <th>Description</th>
    <th>Prix</th>
    <th>Etat</th>
    <th>Option</th>
   </tr>
   <%
    if(produits != null){
    Iterator<Produit> iterator = produits.getList().iterator();
    while(iterator.hasNext()){
    	Produit p = iterator.next();
    
   %>
   <tr>
     <td><%=p.getId() %></td>
     <td><%=p.getNom() %></td>
     <td><%=p.getDesc() %></td>
     <td><%=p.getPrice() %></td>
     <td><%=p.getEtat() %></td>
     <td>
       <form action="prodserv" method="post">
         <input type="hidden" name="id" value="<%=p.getId() %>">
         <input type="hidden" name="actiontype" value="supprimer">
         <input type="submit" value="supprimer">
       </form>
     </td>
   
   </tr>
   <%}} %>
 </table>
</body>
</html>