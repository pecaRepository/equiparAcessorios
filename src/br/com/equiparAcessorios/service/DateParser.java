package br.com.equiparAcessorios.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DateParser {



	public static final Date parseStringToDateBDO(String data) {

		Date retorno = null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			if (data != null && data.length() > 0) {
				retorno = simpleDateFormat.parse(data);
			}
		} catch (ParseException e) {
		}
		return retorno;
	}

	public static final Date parseStringBEAToDateJanela(String data) {
		Date retorno = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH");
		try {
			if (data != null && data.length() > 0) {
				retorno = simpleDateFormat.parse(data);
			}
		} catch (ParseException e) {
		}
		return retorno;
	}

	public static final Date parseStringBEAToDateFechamentoOS(String data) {
		Date retorno = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss");
		try {
			if (data != null && data.length() > 0) {
				retorno = simpleDateFormat.parse(data);
			}
		} catch (ParseException e) {
		}
		return retorno;
	}

	public static final String parseDateCRMToString(Date data) {
		String retorno = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH");
		retorno = simpleDateFormat.format(data);
		return retorno;
	}

	public static final Date parseXMLStringToDateCancel(String data) {
		Date retorno = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss");
		try {
			if (data != null && data.length() > 0) {
				retorno = simpleDateFormat.parse(data);
			}
		} catch (ParseException e) {

			// Nao tratado erro, nao necessario para esse caso, se der erro
			// grava null na tabela controle_mensagem no cenario cancel
		}
		return retorno;
	}

	public static final Date parseSACToDate(String data) {

		Date retorno = null;
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		try {
			retorno = simpleDateFormat.parse(data);
		} catch (ParseException e) {
		}
		return retorno;
	}

	public static final Date parseSACToDateNoDashes(String data, String hora) {

		Date retorno = null;
		String pattern = "yyyyMMddHHmmss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		try {
			retorno = simpleDateFormat.parse(data + hora);
		} catch (ParseException e) {
		}
		return retorno;
	}

	public static final String parseDateToXMLString(Date data) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("GMT-00:00"));
		String newDate = df.format(data);
		newDate = newDate.replace(" ", "T");
		newDate += ".0Z";

		return newDate;
	}

	public static final String parseDateToXMLStringBDO(Date data) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("GMT-00:00"));
		String newDate = df.format(data);
		newDate = newDate.replace(" ", "T");
		newDate += ".0Z";

		return newDate;
	}

	public static final String parseDatePadrao(Date data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String newDate = df.format(data);
		return newDate;
	}

	public static final String parseStringBDOToXMLString(String data) {

		String newDateString = null;

		try {

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date newDate = df.parse(data);
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df2.setTimeZone(TimeZone.getTimeZone("GMT-00:00"));
			newDateString = df2.format(newDate);
			newDateString = newDateString.replace(" ", "T");
			newDateString += ".0Z";

		} catch (ParseException e) {

		}

		return newDateString;
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(parseDatePadrao(new Date()));

	}

}
