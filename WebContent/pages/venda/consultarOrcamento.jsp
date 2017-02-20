<div>
	<div id="tes" class="panel panel-default ">
		<div class="panel-heading">Consulta Orçamento</div>
		<form name="cliForm">
			<div class="panel  col-xs-8 ">
				<div class="panel-body ">

					<div class="control-group col-xs-8">
						<label>CPF</label> <input ng-model="parametros.cpfCliente"
							id="campoCpf" class="form-control" maxlength="11"
							ui-mask="999.999.999-99"
							ng-disabled="clienteSelecionado == true" />
					</div>

					<div class="control-group col-xs-8">
						<label>Nome</label>
						<div class="input-group">
							<span class="input-group-addon"> <i class="fa fa-user"></i>
							</span> <input type="text" ng-model="parametros.nomeCliente"
								class="form-control" ng-disabled="clienteSelecionado == true" />
						</div>
					</div>

					<div class="control-group col-xs-4">
						<label>data</label>
						<div class="input-group">
							<span class="input-group-addon"> 
								<i class="fa fa-calendar"></i>
							</span> 
							<input type="text" class="form-control" ng-click="open($event)"
									datepicker-popup="{{format}}" ng-model="parametros.dataValidade"
									is-open="opened" datepicker-options="dateOptions" show-weeks="false"
									close-text="Close"/> 
						</div>
					</div>


					<div class="control-group col-xs-4">
						<button class="btn btn-primary" ng-click="consultarOS();">
							<i class="fa fa-search fa-fw"></i>
							Pesquisar
						</button>
					</div>

				</div>
			</div>
			<link href="../../resources/css/bootstrap.css" rel="stylesheet"
				type="text/css" />
			<link href="../../resources/css/bootstrap.min.css" rel="stylesheet"
				type="text/css" />

			<div class="clearfix"></div>
			<div class="clearfix"></div>
			<div class="clearfix"></div>

		</form>

		<div class="panel panel-default">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th><span class="glyphicon glyphicon-align-justify"></span></th>
						<th class="pointer">Data Validade</th>
						<th class="pointer">Cliente</th>
						<th class="pointer">Valor</th>
						<th><span class="glyphicon glyphicon-align-justify"></span></th>
						<th class="pointer"></th>
					</tr>
				</thead>
				<tbody>
					<tr dir-paginate="os in listaOS | itemsPerPage: pageSize "
						current-page="currentPage">
						
						
						<td>
							<span id="popover-button-{{os.cdCliente}}" class="glyphicon glyphicon-align-justify" onmouseover="showPopover(this.id)"></span>
							<div id="group-popover-button-{{os.cdCliente}}" class="popover right" >
								<div class="arrow"></div>
								<h3 class="popover-title">
									Opções Orçamento
									<button type="button" id="close-popover-{{os.codigoOrcamento}}" class="close" onclick="hidePopover(this.id)">&times;</button>
								</h3>
								<div innerId="group-popover-button-{{cliente.codigoOrcamento}}" class="popover-content" style="font-size:25px; min-width: 200px;">
									<button style="height: 30px"  class="btn btn-default btn-xs" ui-jq="tooltip" title="Visualizar" ng-click="consultarDetalhesOS(os)" data-toggle="modal" data-target=".ordermServico" ><span class="glyphicon glyphicon-eye-open"></span></button>
									<button style="height: 30px" class="btn btn-default btn-xs" ui-jq="tooltip"  title="Editar" ng-click="alterar(os.codigoOrcamento)"><span class="glyphicon glyphicon-pencil"></span></button>
									<button style="height: 30px" class="btn btn-default btn-xs" ui-jq="tooltip" title="Analisar" ng-click="analisarOrcamento(os.codigoOrcamento)"><span class="glyphicon glyphicon-check"></span></button>
									<button style="height: 30px" class="btn btn-default btn-xs" ui-jq="tooltip" title="Excluir" ng-click="excluirOrcamento(os)"><span class="glyphicon glyphicon-remove"></span></button>
									
								</div>
							</div>
						</td>
						<td>{{os.dataValidade | date:'dd/MM/yyyy HH:mm:ss'}}</td>
						<td>{{os.nomeCliente}}</td>
						<td>{{os.valorTotal | currency:'R$ '}}</td>
						<td>

							<button class="btn btn-primary" data-toggle="modal"
								ng-click="consultarDetalhesOS(os)" data-target=".ordermServico">
								<i class="fa fa-search fa-fw "></i>
							</button>
						</td>
						
						<td>
							<button  class=" btn btn-primary"
			 				ng-show="orcamento == true" 
			 				ng-click="efetuarOrcamento(os.codigoOrcamento)">
			 					Efetuar Venda
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
		</div>
		<button ng-hide="isLigar" class="btn btn-default">
			<a href='javascript:history.back(1)'>Voltar</a>
		</button>
	</div>
	<div id="imprimirok" class="modal fade ordermServico " tabindex="-1"
		role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width: 100%; height: 100%;">
			<jsp:include page="ordemServico.html" />
		</div>
	</div>
</div>