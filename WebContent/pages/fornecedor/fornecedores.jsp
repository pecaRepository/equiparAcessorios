<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<p class="alert alert-danger" ng-show="mensagem.length">{{mensagem}}</p>

<div>

	<a href="#/fornecedores/novo" class="btn btn-default"> 
		<i class="fa fa-plus"></i> Novo Fornecedor
	</a>

	<div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th><span class="glyphicon glyphicon-align-justify"></span></th>
					<th class="pointer">Razão Social</th>
					<th class="pointer">CNPJ</th>
					<th class="pointer">Telefone</th>
					<th class="pointer">Endereço</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="fornecedor in fornecedores  | itemsPerPage: pageSize"
					current-page="currentPage">

					<td>
						<span id="popover-button-{{fornecedor.codigo}}" class="glyphicon glyphicon-align-justify" onmouseover="showPopover(this.id)"></span>
						<div id="group-popover-button-{{fornecedor.codigo}}" class="popover right" >
							<div class="arrow"></div>
							<h3 class="popover-title">
								Opções Cliente
								<button type="button" id="close-popover-{{fornecedor.codigo}}" class="close" onclick="hidePopover(this.id)">&times;</button>
							</h3>
							<div innerId="group-popover-button-{{fornecedor.codigo}}" class="popover-content" style="font-size:25px; min-width: 200px;">
								<button style="height: 30px"  class="btn btn-default btn-xs"  ui-jq="tooltip" title="Visualizar" ng-click="visualizar(fornecedor.codigo)"><span class="glyphicon glyphicon-eye-open"></span></button>
								<button style="height: 30px" class="btn btn-default btn-xs"  ui-jq="tooltip" title="Alterar" ng-click="alterar(fornecedor.codigo)"><span class="glyphicon glyphicon-pencil"></span></button>
								<button style="height: 30px" class="btn btn-default btn-xs"  ui-jq="tooltip" title="Excluir" ng-click="excluir(fornecedor)"><span class="glyphicon glyphicon-remove"></span></button>
							</div>
						</div>
					</td>
					<td>{{fornecedor.nome}}</td>
					<td>{{fornecedor.cnpj}}</td>
					<td>{{fornecedor.telefone}}</td>
					<td>{{fornecedor.endereco}}</td>
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