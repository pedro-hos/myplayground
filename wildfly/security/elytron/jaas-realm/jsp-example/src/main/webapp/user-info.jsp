<!DOCTYPE html>
<html lang="en">
	<head>
		<title>User Info</title>
	</head>
	<body>
		<p>Username: <%= request.getUserPrincipal().getName() %></p>
		<p>Roles: <%= request.isUserInRole("Admin") ? "Admin" : "" %> <%= request.isUserInRole("User") ? "User" : "" %></p>
	</body>
</html>