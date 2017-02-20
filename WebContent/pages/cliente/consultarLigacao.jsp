<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<form name="cliForm">
		<div class="panel panel-default col-xs-8 col-xs-offset-2">
			<div class="panel-heading">
				<i class="fa fa-user"></i> Ligação - {{obj.nome}}
			</div>

			<div class="panel-body ">
				<div class="pull-left">
					<button class="btn btn-default"	ng-click="ligar(obj.cdCliente)">
							<i class="fa fa-floppy-o"></i> Registrar Ligação
					</button>
				</div>
				<div class="clearfix"></div>
				
				<div class="control-group col-xs-12">
					<label>data ligação</label>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
						<input type="text" class="form-control" ng-click="open($event)"
									datepicker-popup="{{format}}"  ng-model="parametros.dataInicio"
									is-open="opened" datepicker-options="dateOptions" show-weeks="false"
									close-text="Close" show-button-bar="false" /> 
					</div>
				</div>

				<div class=" col-xs-12 ">
					<button class="btn btn-default"	ng-click="consultarLigacoes()">
							<i class="fa fa-search fa-fw"></i> pesquisar
					</button>
					<button class="btn btn-default">
						<a  href='javascript:history.back(1)'>Voltar</a>
					</button>
				</div>
				
				<link href="../../resources/css/bootstrap.css" rel="stylesheet"
						type="text/css" />
					<link href="../../resources/css/bootstrap.min.css" rel="stylesheet"
						type="text/css" />

				<div class="control-group col-xs-6">
					<table class="table table-striped table-bordered table-hover table-responsive">
						<thead>
							<tr>
								<th class="pointer">Data</th>
								<th class="pointer">Titulo</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-click="carregarDescricao(ligacao)" dir-paginate="ligacao in ligacoes  | itemsPerPage: pageSize"
								current-page="currentPage">

								 
								<td><span>{{ligacao.dtLigacao | date:"MM/dd/yyyy 'at' h:mma"}}</span></td>
								<td>{{ligacao.titulo}}</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="control-group col-xs-6">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th class="pointer text-center">Descrição</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>{{descricao}}</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</form>
</div>