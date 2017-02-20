<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
function piscando(){
             
                var tempo = 500; //1000 = 1s      
               
                blinks = document.getElementsByTagName("pisca");    
                for(var i=0;i<blinks.length;i++){
                                if(blinks[i].getAttribute("style")=="VISIBILITY: hidden"){                              
                                                blinks[i].setAttribute("style", "VISIBILITY: visible");                         
                                }else{                   
                                                blinks[i].setAttribute("style", "VISIBILITY: hidden");                       
                                }
                }                             
                setTimeout('piscando()', tempo);            
}
</script>
<div class="navbar navbar-default" role="navigation">
	<div class="navbar-inner">
		<div class="container">

			<div class="navbar-header">
				<a href="#/">
					  <!-- <img align="middle" src="resources/img/logo3.png" /> -->          
				</a>
			</div>

			<div class="collapse navbar-collapse">
				<div >
					<ul class="nav navbar-nav">
						<li><a href="#/"> 
								<i class="fa fa-home "></i>
								Home
							</a>
						</li>
	
						<li class="dropdown"><a href="#/clientes"> 
								<span class="glyphicon glyphicon-user"></span>
								Cliente
							</a>
						</li>
						
						<li class="dropdown">
							<a href="#/produtos"> 
								<i class="fa fa-archive"></i> 
								Produto
							</a>
						</li>
						
							<li class="dropdown">
								<a href="#/fornecedores">
									<i class="fa fa-search fa-fw fa-lg"></i>
									Fornecedor
								</a>
							</li>
							
						<li class="dropdown">
							<a href="#/funcionarios"> 
								<i class="fa fa-pencil-square-o"></i>
								Funcionário
							</a>
						</li>
	
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
								<i class="fa fa-list-ul"></i> 
								Serviço
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#/venda/registrar">Registrar </a></li>
								<li><a href="#/venda/consultar">Consultar O.S</a></li>
								<li><a href="#/venda/consultarOrcamento">Consultar Orçamento</a></li>
								<li>
									<a href="#/">
										Relatório
										<span class="glyphicons glyphicons-pie-chart"></span>
									</a>
								</li>
							</ul>
						</li>

					</ul>
						
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="http://localhost:8085/Equipar/">
								<i class="fa fa-unlock fa-fw fa-lg"></i> 
								Logout
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
