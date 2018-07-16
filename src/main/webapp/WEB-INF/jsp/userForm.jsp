<html>
<head>
    <title>Inscription</title>
</head>
<body>
<h2>User Inscription</h2>
<form method="post" action="saveDetails">  
<!--  // saveDetails url mapping in EmployeeController -->
	<label for="id">Id</label>
	<input type="text" name ="id"><br>
    <label for="firstName">First Name </label>
    <input type="text" name="firstName"/><br>
    <label for ="lastName">Last Name </label>
    <input type ="text" name="lastName"><br>
    <label for="adress">Adress</label>
    <input type="text" name="adress"><br>
    <label for="zipCode">ZIP CODE</label>
    <input type="text" name="zipCode"><br>
    <label for="town">Town</label>
 <input type="text" name="town"><br> 
<label for="dateBirth">Date Of Birth</label> 
<input type="date" name= "dateBirth"><br> 
    <label for="email">Email Address</label> 
    <input type="email" name="email"><br>
    <input type="submit" value="valider">
</form>
</body>
</html>