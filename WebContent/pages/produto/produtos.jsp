<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<p class="alert alert-danger" ng-show="mensagem.length">{{mensagem}}</p>

<div>
	<a href="#/produtos/novo" class="btn btn-default"> <i
		class="fa fa-plus"></i> Novo Produto
	</a>
	<div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th><span class="glyphicon glyphicon-align-justify"></span></th>
					<th class="pointer">Modelo</th>
					<th class="pointer">Categoria</th>
					<th class="pointer">Marca</th>
					<th class="pointer">Valor</th>
					<th class="pointer">Quantidade</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="produto in produtos  | itemsPerPage: pageSize"
					current-page="currentPage">

					<td><span id="popover-button-{{produto.codigo}}"
						class="glyphicon glyphicon-align-justify"
						onmouseover="showPopover(this.id)"></span>
						<div id="group-popover-button-{{produto.codigo}}"
							class="popover right">
							<div class="arrow"></div>
							<h3 class="popover-title">
								Opções Produto
								<button type="button" id="close-popover-{{produto.codigo}}"
									class="close" onclick="hidePopover(this.id)">&times;</button>
								{{produto.codigo}}
							</h3>
							<div innerId="group-popover-button-{{produto.codigo}}"
								class="popover-content"
								style="font-size: 25px; min-width: 200px;">
								<button style="height: 30px" class="btn btn-default btn-xs"
									ui-jq="tooltip" title="Visualizar"
									ng-click="visualizar(produto.codigo)">
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
								<button style="height: 30px" class="btn btn-default btn-xs"
									ui-jq="tooltip" title="Editar"
									ng-click="alterar(produto.codigo)">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>

								<button style="height: 30px" class="btn btn-default btn-xs"
									ui-jq="tooltip" title="Excluir" ng-click="excluir(produto)">
									<span class="glyphicon glyphicon-remove"></span>
								</button>
							</div>
						</div></td>
					<td>{{produto.modelo}}</td>
					<td>{{teste(produto.categoria);}}</td>
					<td>{{produto.marca}}</td>
					<td>{{produto.valor | currency:'R$ '}}</td>
					<td>{{produto.quantidade}}</td>
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