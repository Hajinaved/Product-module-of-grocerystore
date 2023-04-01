<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
.totalalign {
	border: 2px black solid;
	margin-left: 20%;
	margin-right: 20%;
	margin-top: 20%;
	padding: 20px;
}

input {
	margin-left: 10%;
	width: 50px;
}
</style>
</head>
<body>
	<form
		style="margin-left: 20%; margin-right: 20%; border: 5px dashed black; width: 30%; height: 500px;"
		action="TU?id">
		<h2
			style="width: auto; font-family: monospace; margin: auto; text-align: center;">ENTER
			PRODUCT DETAILS</h2>
		<div class="totalalign">
			<input type="hidden" name="id" value="${c1}">
			
			 NAME : <input
				size="auto" type="text" name="product-name" value="${c2}"><br>
				
			CATEGORY : ${c3} <select name="category" value="${c3}">
				<option value="dairy" selected="${c3}">dairy</option>
				<option value="vegetable" selected="${c3}">vegetable</option>
				<option value="drinks" selected="${c3}">drinks</option>
				<option value="fruits" selected="${c3}">fruits</option>
				<option value="cereals" selected="${c3}">cereals</option>
				<option value="grains" selected="${c3}">grains</option>
			</select><br>
			 SUB-CATEGORY : ${c4}<select name="sub" selec="${c4}">
				<option value="energy">energy</option>
				<option value="juice">juice</option>
				<option value="milk">milk</option>
				<option value="curd">curd</option>
				<option value="salads">salads</option>
				<option value="pulses">pulses</option>
				<option value="oatmeals">oatmeals</option>

			</select><br> STOCK:<input type="text" name="stock" value="${c5}">
			<br> PRICE : <input type="text" name="price" value="${c6}">
			<br> <input type="submit" value="UPDATE">
		</div>



	</form>
	

</body>
</html>