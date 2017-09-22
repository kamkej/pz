<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<table class="table table-hover table-condensed table-striped table-bordered">
    <thead>
        <tr>
            <td>Codigo</td>
            <td>Nome</td>
            <td>Categoria</td>
            <td>açao</td>
            <td>açao</td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${lista}" var="ingrediente">
        <tr data-id="${ingrediente.id}">
            <td>${ingrediente.id}</td>
            <td>${ingrediente.nome}</td>
            <td>${ingrediente.categoria}</td>
            <td><button type="button" class="btn btn-danger btn-deletar">X</button></td>
            <td><button type="button" class="btn btn-editar glyphicon glyphicon-pencil">X</button></td>
        </tr>
    </c:forEach>
 
</tbody>
<tfoot>
    <tr>
        <td colspan="5">Total:<span id="quantidade-ingredientes"> ${lista.size()}</span></td>
    </tr>
    <tr>
        <td colspan="5">
            <button type="button" class="btn btn-primary" data-toggle="modal"
             data-target="#modal-ingrediente">Cadastrar Ingrediente</button>
        </td>
    </tr>
</tfoot>
</table>