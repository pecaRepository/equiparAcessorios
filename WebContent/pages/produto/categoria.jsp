<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-xs-6 col-xs-offset-3">
	<form name="prodForm">
		<div class="panel panel-default ">
			<div class="panel-heading">
				<i class="fa fa-archive"></i>
				{{cabecalho}}
			</div>

			<div class="panel-body ">

				<div class="control-group col-xs-12">
					<label>Nome</label>
						<input type="text" ng-disabled="isVisualizar" ng-model="obj.nome" class="form-control" required />
				</div>

			<div class="control-group col-xs-12">
				<hr />
				<div class="pull-right">
					<button class="btn btn-default" ng-hide="isVisualizar" ng-disabled="prodForm.$invalid" ng-click="send(obj)">
						<i class="fa fa-floppy-o"></i> {{botao}}
					</button>
					<button class="btn btn-default">
						<a  href='javascript:history.back(1)'>{{botao2}}</a>
					</button>
				</div>
			</div>
		</div>
</div>