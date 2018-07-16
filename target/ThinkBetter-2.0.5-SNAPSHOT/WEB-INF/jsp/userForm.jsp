<html>
<head>
    <title>User Form</title>
</head>
<body>
<h2>User Details</h2>
<form method="post" action="saveDetails">   // saveDetails url mapping in EmployeeController
    Enter User Name : <input type="text" name="userName"/>
    Enter User Email Address: <input type="email" name="userEmail">
    <input type="submit" value="valider">
</form>
</body>
</html>