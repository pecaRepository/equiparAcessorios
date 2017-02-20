<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<p class="alert alert-danger" ng-show="mensagem.length">{{mensagem}}</p>

<div>

	<a href="#/funcionarios/novo" class="btn btn-default"> <i
		class="fa fa-plus"></i> Novo Funcionario
	</a>
	
	<div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th><span class="glyphicon glyphicon-align-justify"></span></th>
					<th class="pointer">Nome</th>
					<th class="pointer">Email</th>
					<th class="pointer">Apelido</th>
					<th class="pointer">Telefone</th>
					<th class="pointer">Cargo</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="funcionario in funcionarios  | itemsPerPage: pageSize"
					current-page="currentPage">

					<td>
						<span id="popover-button-{{funcionario.codigo}}" class="glyphicon glyphicon-align-justify" onmouseover="showPopover(this.id)"></span>
						<div id="group-popover-button-{{funcionario.codigo}}" class="popover right" >
							<div class="arrow"></div>
							<h3 class="popover-title">
								Opções Funcionário 
								<button type="button" id="close-popover-{{funcionario.codigo}}" class="close" onclick="hidePopover(this.id)">&times;</button>
							</h3>
							<div innerId="group-popover-button-{{funcionario.codigo}}" class="popover-content" style="font-size:25px; min-width: 200px;">
								<button style="height: 30px"  class="btn btn-default btn-xs"  ui-jq="tooltip" title="Visualizar" ng-click="visualizar(funcionario.codigo)"><span class="glyphicon glyphicon-eye-open"></span></button>
								<button style="height: 30px" class="btn btn-default btn-xs"  ui-jq="tooltip" title="Editar" ng-click="alterar(funcionario.codigo)"><span class="glyphicon glyphicon-pencil"></span></button>
								<button style="height: 30px" class="btn btn-default btn-xs"  ui-jq="tooltip" title="Comissão" ng-click="comissao(funcionario.codigo)"><span class="glyphicon glyphicon-certificate"></span></button>
								
								<button style="height: 30px" class="btn btn-default btn-xs"  ui-jq="tooltip" title="Excluir" ng-click="excluir(funcionario)"><span class="glyphicon glyphicon-remove"></span></button>
							</div>
						</div>
					</td>
					<td>{{funcionario.nome}}</td>
					<td>{{funcionario.email}}</td>
					<td>{{funcionario.apelido}}</td>
					<td>{{funcionario.telefone}}</td>
					<td>{{funcionario.cargo}}</td>
				</tr>
			</tbody>
		</table>
		<div class="pull-right" ng-controller="OtherController">
			<dir-pagination-controls boundary-links="true"
				on-page-change="pageChangeHandler(newPageNumber)"
				template-url="pages/include/dirPagination.tpl.jsp"></dir-pagination-controls>
		</div>
	</div>
</div>