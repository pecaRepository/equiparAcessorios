package br.com.equiparAcessorios.enumeration;

public enum TipoSexo {

	
	Masculino("Masculino"), 
	Feminino("Feminino");
	
	public String descricao;

	TipoSexo(String valor) {
		descricao = valor;
	}

	public String getDescricao() {
		return descricao;
	}
}
