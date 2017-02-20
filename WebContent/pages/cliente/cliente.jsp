<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<p class="alert alert-danger" ng-show="mensagem.length">{{mensagem}}</p>

<div>
	<form name="cliForm">
		<div class="panel panel-default col-xs-8 col-xs-offset-2"">
			<div class="panel-heading">
				<i class="fa fa-user"></i> Cliente
			</div>

			<div class="panel-body ">

				<div class="control-group col-xs-6">
					<label>Nome</label>
					<div class="input-group">
						<span class="input-group-addon"> <i class="fa fa-user"></i>
						</span> <input type="text" ng-model="obj.nome" ng-disabled="isVisualizar"
							class="form-control" required />
					</div>
				</div>

				<div class="control-group col-xs-6">
					<label>E-mail</label>
					<div class="input-group">
						<span class="input-group-addon"> <i class="fa fa-envelope"></i>
						</span> 
						<input type="text" ng-model="obj.email" ng-disabled="isVisualizar"
							class="form-control" />
					</div>
				</div>

				<div class="control-group col-xs-4">
					<label>CPF</label> <input ng-model="obj.cpf"
						ng-disabled="isVisualizar" id="campoCpf" class="form-control"
						required maxlength="11" ui-mask="999.999.999-99" />
				</div>

				<div class="control-group col-xs-4">
					<label>Sexo</label> {{obj.sexo}} <select class="form-control"
						ng-model="obj.sexo" ng-disabled="isVisualizar">
						<option ng-repeat="tipoSexo in tipoSexo"
							ng-selected="obj.sexo == tipoSexo" value="{{tipoSexo}}">{{tipoSexo}}</option>
					</select>
				</div>

				<div class="control-group col-xs-4">
					<label>Telefone</label>
					<div class="input-group">
						<span class="input-group-addon"> <i class="fa fa-phone"></i></span>
						<input id="campoTelefone" ng-model="obj.telefone"
							ng-disabled="isVisualizar" type="text" class="form-control" ui-mask="99999-999?9" />

					</div>
				</div>

				<div class="control-group col-xs-8">
					<label>Endereço</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="fa fa-map-marker"></i>
						</span> <input ng-model="obj.endereco" ng-disabled="isVisualizar"
							type="text" class="form-control" />
					</div>
				</div>

				<div class="control-group col-xs-4">
					<label>Cidade</label> <input ng-model="obj.cidade"
						ng-disabled="isVisualizar" type="text" class="form-control" />
				</div>
			</div>

			<div class="panel-heading">
				<i class="fa fa-car"></i> {{cabecalhoCarro}}
			</div>
			<div class="panel-body">
				<div class="control-group col-xs-6">
					<label>Marca</label> <input ng-model="obj.marca"
						ng-disabled="isVisualizar" type="text" class="form-control"
						required />
				</div>

				<div class="control-group col-xs-6">
					<label>Modelo</label> <input ng-model="obj.modelo"
						ng-disabled="isVisualizar" type="text" class="form-control"
						required />
				</div>

				<div class="control-group col-xs-6">
					<label>Placa</label> <input ng-model="obj.placa"
						ng-disabled="isVisualizar" id="campoPlaca" type="text"
						class="form-control text-uppercase" required ui-mask="AAA-9999" />
				</div>
			</div>

			<div class="control-group col-xs-12" >
				<hr />
				<div class="pull-right">
					<button class="btn btn-default" ng-disabled="cliForm.$invalid"
						ng-hide="isVisualizar" ng-click="send(obj)">
						<i class="fa fa-floppy-o"></i> Salvar
					</button>
					<button ng-hide="isLigar" class="btn btn-default">
						<a  href='javascript:history.back(1)'>Voltar</a>
					</button>
				</div>
			</div>
		</div>
</div>