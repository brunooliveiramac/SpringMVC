<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	  <link href="css/style.css" rel="stylesheet">
	  <meta charset = "utf-8">
      <meta http-equiv = "X-UA-Compatible" content = "IE = edge">
      <meta name = "viewport" content = "width = device-width, initial-scale = 1">
      
      <title>CRUD Spring MVC + RestWS JaxRS Jarsey</title>
      
      <!-- Bootstrap -->
      <link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">

	  <!-- Optional theme -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">



<meta http-equiv="Content-Type" content="text/html; charset=utf-8>
<title>Insert title here</title>
</head>
<body>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
      
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

     
    
	<h1>Adicionar Cliente</h1>
	
	<form  action="adicionarCliente" method="post">
		
		<input type="text" name="nome"> 
		<input type="text" name="endereco"> 
	    </br> 
		<button type="submit" class="btn btn-primary">Adicionar</button>
		
	</form>

<table border="1" align="center" style="width:70%">
            <tr>
                <th>User Id</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Editar</th>
                <th>Deletar</th>
            </tr>

           <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td>${cliente.id}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.endereco}</td>   
				    <td><a href="form/${cliente.id}">Editar</a></td>
				    <td><a href="removerCliente/${cliente.id}">Deletar</a></td>			    
                </tr> 
           </c:forEach>     
 </table> 
    
    
</body>
</html>