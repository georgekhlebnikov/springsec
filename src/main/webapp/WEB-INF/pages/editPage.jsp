<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- проверяем поле user.name. Если оно пустое - это новый юзер, мы должны заполнить для него
все данные и добавить в список. Если поле не пустое, значит юзер из списка и его нужно просто изменить -->
<html>
<head>
        <title>EDIT</title>
</head>
<body>


<form:form method="POST" action="777" modelAttribute="user" acceptCharset="utf-8">

                <form:hidden path="id" />
        <table border="3px">
            <tr>
                <td><form:label path="name">Имя</form:label></td>
                <td><form:input path="name"/></td>
            </tr>

            <tr>
                <td><form:label path="password">Пароль</form:label></td>
                <td><form:input path="password"/></td>
            </tr>

            <tr>
                <td><input type="submit" value="Edit user"></td>
            </tr>

        </table>
</form:form>

</body>
</html>
