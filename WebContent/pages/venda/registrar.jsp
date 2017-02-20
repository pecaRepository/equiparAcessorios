<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="">
	<div class="panel panel-default col-xs-10 col-xs-offset-1 hidden-print">

		<form name="vForm">
			<div class="panel  col-xs-8 ">
				<div class="panel-body ">

					<div class="control-group col-xs-8">
						<label>CPF</label> <input ng-model="obj.cpfCliente"
							id="campoCpf" class="form-control" required
							maxlength="11" type="text" ui-mask="999.999.999-99" 
							ng-change="consultarClientePorCPF(obj.cpfCliente);" />
					</div>

					<div class="control-group col-xs-8">
						<label>Nome</label>
						<div class="input-group">
							<span class="input-group-addon"> <i class="fa fa-user"></i>
							</span> <input type="text" ng-model="obj.nomeCliente"
								class="form-control" required />
						</div>
					</div>

					<div class="control-group col-xs-4">
						<label>Telefone</label>
						<div class="input-group">
							<span class="input-group-addon"> <i class="fa fa-phone"></i></span>
							<input id="campoTelefone" ng-model="obj.telefoneCliente"
								type="text" class="form-control" maxlength="9"
								required ui-mask="99999-999?9" />
						</div>
					</div>

					<div class="control-group col-xs-4">
						<label>Marca</label> <input ng-model="obj.veiculoMarca"
							type="text" class="form-control" required />
					</div>

					<div class="control-group col-xs-4">
						<label>Modelo</label> <input ng-model="obj.veiculoModelo"
							type="text" class="form-control" required />
					</div>

					<div class="control-group col-xs-4">
						<label>Placa</label> <input  ng-model="obj.veiculoPlaca" id="campoPlaca"
							type="text" class="form-control text-uppercase" required ui-mask="AAA-9999" value=" obj.veiculoPlaca = angular.uppercase(obj.veiculoPlaca)" />
					</div>

				</div>
			</div>
			<div class="panel col-xs-4 alert-info text-center text-capitalize"
				style="height: 250px;">
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<h1 class="">O.S nº 0000{{numeroOSVenda}}</h1>
			</div>

			<div class="pull-left">
				<button class="btn btn-primary" data-toggle="modal"
					data-target=".bs-example-modal-lg">Produtos</button>
					
				<button class="btn btn-primary" ng-click="adicionarMaoObra()">Mão
					de Obra</button>
			</div>

			<div class="modal fade bs-example-modal-lg" tabindex="-1"
				role="dialog" aria-labelledby="myLargeModalLabel" >
				<div class="modal-dialog modal-lg">
					<jsp:include page="../produto/lista.jsp" />
				</div>
			</div>

			<div class="clearfix"></div>

			<div class="panel panel-default">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="pointer">Nome</th>
							<th class="pointer">Qtd</th>
							<th class="pointer">Valor</th>
							<th class="pointer">Garantia</th>
							<th class="pointer">Funcionario</th>
							<th><span class="glyphicon glyphicon-align-justify"></span></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="itemVenda in itemsVenda">

							<td ng-show="itemVenda.tipo != editableInput">{{itemVenda.modelo}}
							</td>

							<td ng-show="itemVenda.tipo == editableInput"><input
								id="campoModelo" type="text" ng-model="itemVenda.modelo"
								required></td>
								
							<td><input id="campoQuantidade" type="text"
								ng-model="itemVenda.quantidadeVenda"
								ng-change="consultaQuantidade(itemVenda);"
								ng-show="itemVenda.tipo != editableInput"></td>
								
							<td><input id="campoValor" type="text"
								currency:"R$" ng-model="itemVenda.valor" required
								ng-change="consultaQuantidade(itemVenda);"></td>
								
							<td><input id="campoGarantia" type="text"
								ng-model="itemVenda.garantia" 
								ng-show="itemVenda.tipo != editableInput" required></td>

							<td><select class="form-control"
								ng-model="itemVenda.funcionario"
								 ng-disabled="isVisualizar"
								required>
									<option ng-repeat="funcionario in funcionario"
										ng-selected="obj.funcionario == funcionario"
										value="{{funcionario.codigo}}" >{{funcionario.apelido}}</option>
							</select></td>
							<td>
								<button class="btn btn-default"
									ng-click="removerItemVenda(itemVenda)">
									<i class="fa fa-minus"></i>
								</button>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th class="active text-right" colspan="4">Total</th>
							<th class="active text-info label-default" colspan="1">{{valorTotalLista
								| currency:'R$'}}</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</form>

		<button class="btn btn-primary" data-toggle="modal"
			data-target=".ordermServico" ng-disabled="vForm.$invalid"
			ng-click="gerarOS();">Gerar
			O.S</button>
			
		<button class="btn btn-primary" data-toggle="modal"
			data-target=".ordermServico" ng-click="gerarOrcamento()">Gerar Orçamento</button>

	</div>


</div>
<div id="imprimirok" class="modal fade ordermServico " tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" style="width: 100%; height: 100%;">
		<jsp:include page="ordemServico.html" />
	</div>
</div>