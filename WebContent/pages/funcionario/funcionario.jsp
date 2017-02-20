<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<p class="alert alert-danger" ng-show="mensagem.length">{{mensagem}}</p>

<div class="col-xs-6 col-xs-offset-3">
	<form name="funcForm">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-user"></i> Funcionario
			</div>

			<div class="panel-body ">

				<div class="control-group col-xs-12">
					<label>Nome</label>
					<div class="input-group">
						<span class="input-group-addon"> <i class="fa fa-user"></i>
						</span> <input type="text" ng-disabled="isVisualizar" ng-model="obj.nome" class="form-control" required />
					</div>
				</div>

				<div class="control-group col-xs-8">
					<label>E-mail</label>
					<div class="input-group">
						<span class="input-group-addon"> <i class="fa fa-envelope"></i>
						</span> <input type="text" ng-disabled="isVisualizar" ng-model="obj.email" class="form-control" />
					</div>
				</div>

				<div class="control-group col-xs-4">
					<label>Apelido</label> 
					<input ng-disabled="isVisualizar" ng-model="obj.apelido" class="form-control" required maxlength="11" />
				</div>

				<div class="control-group col-xs-6">
					<label>Telefone</label>
					<div class="input-group">
						<span class="input-group-addon"> <i class="fa fa-phone"></i></span> 
						<input id="campoTelefone" ng-disabled="isVisualizar" ng-model="obj.telefone" type="text" class="form-control" ui-mask="99999-999?9" />
						
					</div>
				</div>


				<div class="control-group col-xs-6">
					<label>Cargo</label> 
					<input ng-disabled="isVisualizar" ng-model="obj.cargo" type="text" class="form-control" />
				</div>
			</div>

			<div class="control-group col-xs-12">
				<hr />
				<div class="pull-right">
					<button class="btn btn-default" ng-hide="isVisualizar" ng-disabled="funcForm.$invalid" ng-click="send(obj)">
						<i class="fa fa-floppy-o"></i> Salvar
					</button>
					<button class="btn btn-default">
						<a  href='javascript:history.back(1)'>Voltar</a>
					</button>
				</div>
			</div>
		</div>
</div>