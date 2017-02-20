package br.com.equiparAcessorios.entity;

public class ValidaLoginTeste {

	public boolean validar(String login, String senha){
		String l = "tpeca";
		String s = "251";
		
		System.out.println(login);
		System.out.println(senha);
		if(login.equals(l) && senha.equals(s)){
			return true;
		}else{
			return false;
		}
	}
}
