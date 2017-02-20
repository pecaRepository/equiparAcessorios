<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>

	<form name="cliForm">
		<div class="panel panel-default col-xs-12">
			
			<div class=" col-xs-6">
				<jsp:include page="cliente.jsp"/>
			</div>
		
		
			<div class="panel panel-default col-lg-6 active">
				<div class="panel-heading control-group ">
					<i class="fa fa-user"></i> Ligar para {{obj.nome}}
				</div>
	
				<div class="panel-body ">
					
					<div class="control-group col-xs-6">
						<label ng-model="obj2.dataAtual">data ligação: {{dataAtual}}</label>
					</div>
					
					<div class="control-group col-xs-8">
						<label>Titulo</label>
						</span> <input type="text" ng-model="obj2.titulo" class="form-control" required />
					</div>
					
					<div class="control-group col-xs-12">
						<label>Descrição</label>
						
						<textarea class="form-control" ng-model="obj2.descricao" rows="6"></textarea>
					</div>
					
				</div>
				<div class="pull-right">
					<button class="btn btn-default" ng-disabled="cliForm.$invalid" ng-click="send(obj2)">
						<i class="fa fa-floppy-o"></i> {{botao}}
					</button>
					<button class="btn btn-default" >
						<a  href='javascript:history.back(1)'>{{botao2}}</a>
					</button>
				</div>
			</div>
			
			<div class="pull-right">
				<button class="btn btn-primary" data-toggle="modal"
			data-target=".ordermServico" ng-click="consultarOS(obj.cdCliente)">Lista OS</button>
			</div>
			
		</div>
		
		<div class="modal fade ordermServico " tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" style="width: 100%; height: 100%;">
				<jsp:include page="../venda/consultarOS.jsp" />
			</div>
		</div>
	</form>
</div>