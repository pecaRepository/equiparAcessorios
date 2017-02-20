package br.com.equiparAcessorios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaDados {
	
	public static void main(String[] args) {
		List<String> valores = new ArrayList<String>();
		valores.add("Testando validador de SQL inject quando receber UPDATE");
		new ValidaDados().FazerValidacao(valores);
	}
	
	public Boolean FazerValidacao(List<String> valores){
		Boolean validacao = true;
		List<String> parametros = new ArrayList<String>();
		parametros.add("INSERT");
		parametros.add("UPDATE");
		parametros.add("DELETE");
		parametros.add("DROP");
		parametros.add("'");
		parametros.add(";");
		
		if(valores.size() != 0){
			for(int i = 0; i<valores.size(); i++){
				String valorValidar = valores.get(i).toUpperCase();
				if(parametros.size() != 0){
					for(int i2 = 0; i2 < parametros.size(); i2++ ){
						String parametro = parametros.get(i2).toUpperCase();
						Pattern pegaJava = Pattern.compile(parametro);      
						Matcher m = pegaJava.matcher(valorValidar);   
						     
						while (m.find()) {   
						    validacao = false;   
						} 
					} 
				}
			}
		}else{
			System.out.println("Não exitem valores para ser validados");
		}
		return validacao;
	}
}
