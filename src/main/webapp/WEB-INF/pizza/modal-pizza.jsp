<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<div class="modal fade" id="modal-pizza" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="form-pizza" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">Informações da Pizza</h4>
                </div>
                <div class="modal-body">
                    <label for="nome">Nome: </label>
                    <input id="nome" name="nome" class="form-control">
                    <label for="preco">Preço </label>
                    <input id="preco" name="preco" class="form-control">
                     <label for="tamanho">tamanho </label>
                    <select id="tamanho" name="tamanho" class="form-control">
                        <c:forEach items="${tamanhos}" var="tamanho">
                            <option value="${tamanho}">${tamanho}</option>
                        </c:forEach>
                    </select>
                    <label for="Ingredientes">Ingredientes </label>
                    <select id="ingredientes" name="Ingredientes" class="form-control" multiple="multiple">
                        <c:forEach items="${ingredientes}" var="ingrediente">
                            <option value="${ingrediente.id}">${ingrediente.nome}</option>
                        </c:forEach>
                    </select>
                     <input id="id" name="id" type="hidden">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <button id="btn-salvar" type=button class="btn btn-primary">Salvar Informações</button>
                </div>
            </form>
        </div>
    </div>
</div>