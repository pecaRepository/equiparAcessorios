<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<div class="panel panel-default col-xs-10 col-xs-offset-1">

		<button class="btn btn-primary" data-toggle="modal"
			data-target=".bs-example-modal-lg">Produtos</button>

		<div class="modal fade bs-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<jsp:include page="teste.jsp" />
			</div>
		</div>


		<div class="clearfix"></div>

		<div class="panel panel-default">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="pointer">Modelo</th>
						<th class="pointer">Categoria</th>
						<th class="pointer">Marca</th>
						<th class="pointer">Valor</th>
						<th class="pointer">Comissao</th>
						<th><span class="glyphicon glyphicon-align-justify"></span></th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="produtoComissao in produtosComissao">

						<td>{{produtoComissao.modelo}}</td>
						<td>{{produtoComissao.categoria}}</td>
						<td>{{produtoComissao.marca}}</td>
						<td>{{produtoComissao.valor}}</td>
						<td><input id="campoTelefone" type="text"
							ng-model="produtoComissao.comissao"></td>
						<td>
							<button class="btn btn-default"
								ng-click="removerProdutoComissao(produtoComissao)">
								<i class="fa fa-minus"></i>
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>


		<!-- AQUI APARECE A LISTA DOS PRODUTOS SELECIONADOS -->

		<div class="pull-right">
			<button class="btn btn-default" ng-disabled="cliForm.$invalid"
				ng-click="salvar(produtosComissao)">
				<i class="fa fa-floppy-o"></i> {{botao}}
			</button>
			<button class="btn btn-default">
				<a href="#/">Cancel</a>
			</button>
		</div>

	</div>
</div>
