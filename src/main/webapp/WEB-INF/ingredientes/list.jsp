<%-- 
    Document   : list
    Created on : 12/09/2017, 12:01:55
    Author     : G0006185
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <c:set var="path" value="${pageContext.request.contextPath}" scope="request"/>
        <style type="text/css">
			@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
			@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
	</style>
    </head>
    <body>
        <table class="table table-hover table-condensed table-striped table-bordered">
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Nome</td>
                    <td>Categoria</td>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lista}" var="ingrediente">
                    <tr>
                        <td>${ingrediente.id}</td>
                        <td>${ingrediente.nome}</td>
                        <td>${ingrediente.categoria}</td>
                    </tr>
                </c:forEach>
               
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3">Total: ${lista.size()}</td>
                </tr>
            </tfoot>
        </table>
                <script type="text/javascript" src="${path}/static/js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${path}/static/js/ingredientes.js"></script>
    </body>
</html>
