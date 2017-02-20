<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<p class="alert alert-danger" ng-show="mensagem.length">{{mensagem}}</p>

<div>
	<a href="#/clientes/novo" class="btn btn-default"> <i
		class="fa fa-plus"></i> Novo Cliente
	</a>
	<div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th><span class="glyphicon glyphicon-align-justify"></span></th>
					<th class="pointer">Nome</th>
					<th class="pointer">CPF</th>
					<th class="pointer">Email</th>
					<th class="pointer">Telefone</th>
					<th class="pointer">Carro</th>
					<th class="pointer">Placa</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="cliente in clientes  | itemsPerPage: pageSize "
					current-page="currentPage">

					<td><span id="popover-button-{{cliente.cdCliente}}"
						class="glyphicon glyphicon-align-justify"
						onmouseover="showPopover(this.id)"></span>
						<div id="group-popover-button-{{cliente.cdCliente}}"
							class="popover right">
							<div class="arrow"></div>
							<h3 class="popover-title">
								Opções Cliente
								<button type="button" id="close-popover-{{cliente.cdCliente}}"
									class="close" onclick="hidePopover(this.id)">&times;</button>
							</h3>
							<div innerId="group-popover-button-{{cliente.cdCliente}}"
								class="popover-content"
								style="font-size: 25px; min-width: 200px;">
								<button style="height: 30px" class="btn btn-default btn-xs"
									ui-jq="tooltip" title="Visualizar"
									ng-click="visualizar(cliente.cdCliente)">
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
								<button style="height: 30px" class="btn btn-default btn-xs"
									ui-jq="tooltip" title="Editar"
									ng-click="alterar(cliente.cdCliente)">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
								<button style="height: 30px" class="btn btn-default btn-xs"
									ui-jq="tooltip" title="Ligação"
									ng-click="consultarLigacao(cliente.cdCliente)">
									<span class="glyphicon glyphicon-earphone"></span>
								</button>
								<button style="height: 30px" class="btn btn-default btn-xs"
									ui-jq="tooltip" title="Consultar O.S"
									ng-click="consultarOS(cliente)">
									<i class="fa fa-clipboard"></i></span>
								</button>

								<button style="height: 30px" class="btn btn-default btn-xs"
									ui-jq="tooltip" title="Excluir Cliente"
									ng-click="excluir(cliente)">
									<span class="glyphicon glyphicon-remove"></span>
								</button>

							</div>
						</div></td>
					<td>{{cliente.nome}}</td>
					<td id="campoCpf">{{cliente.cpf}}</td>
					<td>{{cliente.email}}</td>
					<td id="campoTelefone">{{cliente.telefone}}</td>
					<td>{{cliente.modelo}}</td>
					<td id="campoPlaca">{{cliente.placa | uppercase}}</td>
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

