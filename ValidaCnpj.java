//Verifica se o CNPJ informado é valido ou não 

import javax.swing.JOptionPane;

public class ValidaCnpj  {
		private int[] cnpjInt = new int[14];
		private int somaDosDigitos, digito1, digito2, peso = 6;
		private String comparar, ultimoDigito, cnpj;

		public  boolean VerificaCnpj() {
			cnpj = JOptionPane.showInputDialog("Informe o CNPJ ");
			
			while (cnpj == null) {
				JOptionPane.showConfirmDialog(null, "CNPJ não informado", null, JOptionPane.CLOSED_OPTION);
				return false;
			}
			
			cnpj = cnpj.replace(".", "");
			cnpj = cnpj.replace("-", "");
			cnpj = cnpj.replace("/", "");
			
			while (cnpj.length() != 14 || cnpj.substring(0, 6).equals(cnpj.substring(6, 12)) || cnpj.equals("12345678901234")) {
				return false;
			}
			
			for (int i = 0; i < 12; i++) {
				cnpjInt[i] = Character.getNumericValue(cnpj.charAt(i));
				somaDosDigitos += cnpjInt[i] * peso;
				if (peso == 9) {
					peso = 1;
				}
				peso++;
			}
			
			digito1 = somaDosDigitos % 11;
			if (digito1 > 9) {
				digito1 = 0;
			}
			
			somaDosDigitos = 0;
			peso = 5;
			for (int i = 0; i < 13; i++) {
				cnpjInt[i] = Character.getNumericValue(cnpj.charAt(i));
				somaDosDigitos += cnpjInt[i] * peso;
				if (peso == 9) {
					peso = 1;
				}
				peso++;
			}
			
			digito2 = somaDosDigitos % 11;
			if (digito2 > 9) {
				digito2 = 0;
			}
			
			comparar = Integer.toString(digito1) + Integer.toString(digito2);
			ultimoDigito = cnpj.substring(12);
			if (!comparar.equals(ultimoDigito)) {
				JOptionPane.showConfirmDialog(null, "Cnpj Invalido", null, JOptionPane.CLOSED_OPTION);
				return false;
			}
			return true;
		}
	}
