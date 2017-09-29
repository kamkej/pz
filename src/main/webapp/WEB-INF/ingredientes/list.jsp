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
        <div class="container">
             <jsp:include page="../menu-pizzaria.jsp"></jsp:include>
            <c:if test="${not empty messageErro}">
                <div>
                    <div class="alert alert-danger">${messageErro}</div>
                </div>
            </c:if>
            <c:if test="${not empty messageInfo}">
                <div>
                    <div class="alert alert-info">${messageInfo}</div>
                </div>
            </c:if>
            <section  id="secao-ingredientes">
                <jsp:include page="tabela-ingredientes.jsp"/>
            </section>

            <jsp:include page="modal-ingredientes.jsp"/>
        </div>
        <script type="text/javascript" src="${path}/static/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${path}/static/js/ingredientes.js"></script>
    </body>
</html>
