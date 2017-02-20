<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<p class="alert alert-danger" ng-show="mensagem.length">{{mensagem}}</p>

<div class="col-xs-6 col-xs-offset-3">


	<form name="formulario" ng-submit="submeter()">
		<div class="panel panel-default  ">
			<div class="panel-heading">
				<i class="fa fa-archive"></i> Produto
			</div>
			<div class="panel-body ">

				<div class="control-group col-xs-12">
					<label>Modelo</label> <input type="text" ng-disabled="isVisualizar"
						ng-model="obj.modelo" class="form-control" required />
				</div>

				<div class="control-group col-xs-6">
					<label>Categoria</label> <select class="form-control"
						ng-model="obj.categoria" ng-disabled="isVisualizar">
						<option ng-repeat="categorias in categorias"
							ng-selected="obj.categoria == categorias "
							value="{{categorias.codigo}}">{{categorias.nome}}</option>
					</select>
				</div>

				<div class="control-group col-xs-6">
					<label>Marca</label> <input ng-disabled="isVisualizar"
						ng-model="obj.marca" id="campoCpf" class="form-control" required
						maxlength="30" />
				</div>

				<div class="control-group col-xs-6">
					<label>Valor</label>
					<div class="input-group">
						<span class="input-group-addon"> <i class="fa fa-money"></i>
						</span> <input ng-disabled="isVisualizar" ng-model="obj.valor"
							id="campoCpf" class="form-control" required maxlength="3" />
					</div>
				</div>

				<div class="control-group col-xs-6">
					<label>Quantidade</label> <input ng-disabled="isVisualizar"
						id="campoTelefone" ng-model="obj.quantidade" type="number"
						class="form-control" maxlength="3" />
				</div>

				<div class="control-group col-xs-12">
					<hr />
					<div class="pull-right">
						<button type="submit" class="btn btn-default" ng-hide="isVisualizar"
							ng-disabled="formulario.$invalid"">
							<i class="fa fa-floppy-o"></i> Salvar
						</button>
						<button class="btn btn-default">
							<a href='javascript:history.back(1)'>Voltar</a>
						</button>
					</div>
				</div>
			</div>
		</div>