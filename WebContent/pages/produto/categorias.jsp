<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<div>
	
		<div class="pull-left">
			<button class="btn btn-default" ng-hide="isVisualizar" ng-disabled="prodForm.$invalid" ng-click="adicionar()">
				<i class="fa fa-plus"></i> Adicionar Categoria
			</button>
		</div>
		
		<div class="clearfix"></div>
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th><span class="glyphicon glyphicon-align-justify"></span></th>
					<th class="pointer">Categoria</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="categoria in categorias  | itemsPerPage: pageSize"
					current-page="currentPage">

					<td>
						<span id="popover-button-{{categoria.codigo}}" class="glyphicon glyphicon-align-justify" onmouseover="showPopover(this.id)"></span>
						<div id="group-popover-button-{{categoria.codigo}}" class="popover right" >
							<div class="arrow"></div>
							<h3 class="popover-title">
								Opções Categoria
								<button type="button" id="close-popover-{{categoria.codigo}}" class="close" onclick="hidePopover(this.id)">&times;</button>
							</h3>
							<div innerId="group-popover-button-{{categoria.codigo}}" class="popover-content" style="font-size:25px; min-width: 200px;">
								<button style="height: 30px"  class="btn btn-default btn-xs"  ui-jq="tooltip" title="Visualizar" ng-click="visualizar(categoria.codigo)"><span class="glyphicon glyphicon-eye-open"></span></button>
								<button style="height: 30px" class="btn btn-default btn-xs"  ui-jq="tooltip" title="Editar" ng-click="alterar(categoria.codigo)"><span class="glyphicon glyphicon-pencil"></span></button>
								<button style="height: 30px" class="btn btn-default btn-xs"  ui-jq="tooltip" title="Excluir" ng-click="excluir(categoria)"><span class="glyphicon glyphicon-remove"></span></button>
							</div>
						</div>
					</td>
					<td>{{categoria.nome}}</td>
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