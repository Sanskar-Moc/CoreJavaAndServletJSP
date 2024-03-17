<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
<style>
    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .details {
        text-align: center;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="details">
            <h3>Registered Successfully</h3>
            <p>Name: ${student.name}</p>
            <p>Age: ${student.age}</p>
            <p>Mobile: ${student.mobNo}</p>
            <p>Address: ${student.address}</p>
        </div>
    </div>
</body>
</html>
