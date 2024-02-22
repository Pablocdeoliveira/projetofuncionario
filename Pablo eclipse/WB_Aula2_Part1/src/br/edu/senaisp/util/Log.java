package br.edu.senaisp.util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.LocalDate;

public class Log {

	private static String pathArquivo = "C:\\temp\\log\\";

	public float divisaoThrows(int a, int b) throws Exception {

	public static boolean escrever(String msg) {

		String pathDestino = pathArquivo + LocalDate.now().getYear() + "_" + LocalDate.now().getDayOfMonth() + "_"
				+ LocalDate.now().getMonth() + ".log";

		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(pathDestino, Charset.forName("UTF-8"), true));

			pw.append(msg).append("\n");

			pw.close();

			return true;

		} catch (Exception e) {

			System.out.println("Erro: " + e.getLocalizedMessage());

			return false;
		}

	}

}
