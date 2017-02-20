		<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel center">Lista de Produtos</h4>
					</div>
					<div class="modal-content">
						<table
							class="table table-striped table-bordered table-hover table-responsive">
							<thead>
								<tr>
									<th class="pointer">Modelo</th>
									<th class="pointer">Categoria</th>
									<th class="pointer">Marca</th>
									<th class="pointer">Valor</th>
									<th class="pointer">Quantidade</th>
									<th><span class="glyphicon glyphicon-align-justify"></span></th>
								</tr>
							</thead>
							<tbody>
								<tr dir-paginate="produto in produtos  | itemsPerPage: pageSize"
									current-page="currentPage">

									<td>{{produto.modelo}}</td>
									<td>{{produto.categoria}}</td>
									<td>{{produto.marca}}</td>
									<td>{{produto.valor}}</td>
									<td>{{produto.quantidade}}</td>
									<td>
										<button class="btn btn-default"
											ng-click="adicionarProdutoComissao(produto)">
											<i class="fa fa-plus"></i> 
										</button>
									</td>
								</tr>
							</tbody>
						</table>

						<div class="pull-right" ng-controller="OtherController">
							<dir-pagination-controls boundary-links="true"
								on-page-change="pageChangeHandler(newPageNumber)"
								template-url="pages/include/dirPagination.tpl.jsp"></dir-pagination-controls>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>	