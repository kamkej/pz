<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<table class="table table-hover table-condensed table-striped table-bordered">
    <fmt:setLocale value="pt_BR"/>
    <thead>
        <tr>
            <td>#</td>
            <td>Nome</td>
            <td>Preço</td>
            <td>Tamanho</td>
            <td>ingredientes</td>
            <td>Deletar</td>
            <td>Editar</td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${pizza}" var="pizza">
        <tr data-id="${pizza.id}">
            <td>${pizza.id}</td>
            <td>${pizza.nome}</td>
            <td>
                <fmt:formatNumber type="currency" value="${pizza.preco}"/>
            </td>
            <td>${pizza.tamanho}</td>
            <td>${pizza.ingredientes}</td>

            <td><button type="button" class="btn btn-danger btn-deletar">X</button></td>
            <td><button type="button" class="btn btn-editar glyphicon glyphicon-pencil">X</button></td>
        </tr>
    </c:forEach>
 
</tbody>
<tfoot>
    <tr>
        <td colspan="7">Total:<span id="quantidade-ingredientes"> ${pizza.size()}</span></td>
    </tr>
    <tr>
        <td colspan="7">
            <button type="button" class="btn btn-primary" data-toggle="modal"
             data-target="#modal-pizza">Cadastrar Pizza</button>
        </td>
    </tr>
</tfoot>
</table>