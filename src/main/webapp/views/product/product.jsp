<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <th>${product.id_product}</th>
                <th>${product.productName}</th>
                <th>${product.description}</th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>