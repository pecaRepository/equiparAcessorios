package br.com.equiparAcessorios.service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class testeData {

	public static void main(String[] args) {
		Date dataNova = new Date();
		Calendar dataInicial = new GregorianCalendar();
		dataInicial.setTime(dataNova);
		dataInicial.set(Calendar.HOUR, 0);
		dataInicial.set(Calendar.MINUTE, 00);
		dataInicial.set(Calendar.SECOND, 00);
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(dt.format(dataInicial.getTime()));	
		Calendar dataFinal = new GregorianCalendar();
		dataFinal.setTime(dataNova);
		dataFinal.set(Calendar.HOUR, 11);
		dataFinal.set(Calendar.MINUTE, 59);
		dataFinal.set(Calendar.SECOND, 59);
		System.out.println(dt.format(dataFinal.getTime()));
	}
}
