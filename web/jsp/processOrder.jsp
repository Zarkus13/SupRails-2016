<%-- 
    Document   : processOrder
    Created on : 28 nov. 2014, 13:00:14
    Author     : alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process and order</title>
    </head>
    <body>
        <form method="POST" action="#">
            <input type="hidden" name="tripId" value="${param.tripId}" />
            Firstname : <input type="text" name="firstname" /> <br/>
            Lastname : <input type="text" name="lastname" /><br/>
            Email : <input type="text" name="email" /><br/>
            <input type="submit" value="Process order" />
        </form>
    </body>
</html>
