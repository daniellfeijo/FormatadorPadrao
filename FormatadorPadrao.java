public class FormatadorPadrao {
	String primeiraLetra = "";
	String frase = "";

	/**
	 * Método para Formatar frases digitadas pelo usuário colocando num padrão
	 * adotado pelo sistema.
	 * 
	 * @param fraseOriginal
	 * @return frase
	 */
	public String formatar(String fraseOriginal) {
		// Se for N.A. ou N.E. não fazer nada e retornar
		// a frase original mesmo.
		if ((fraseOriginal.equals("N.A.")) || (fraseOriginal.equals("N.E."))
				|| (fraseOriginal.equals("A/C"))
				|| (fraseOriginal.equals("A/I"))) {
			return fraseOriginal;
		}
		// Tratando logo a primeira letra
		primeiraLetra = "" + fraseOriginal.charAt(0);
		frase = primeiraLetra.toUpperCase();
		// Meu primeiro passo foi varrer toda a frase
		// em busca de espaços em brancos
		// onde tiver espaço em branco ele marca
		// como true
		boolean[] espaco;
		espaco = new boolean[fraseOriginal.length()];
		for (int i = 1; i < fraseOriginal.length(); i++) {
			String letra = "" + fraseOriginal.charAt(i);
			if (letra.equals(" ")) {
				espaco[i] = true;
			} else {
				espaco[i] = false;
			}
		}
		for (int i = 1; i < fraseOriginal.length(); i++) {
			String letra = "" + fraseOriginal.charAt(i);
			// Se a próxima letra for um espaço em
			// branco
			if (espaco[i] == true) {
				//Se o espaço branco for a
				//última letra de o break
				if(fraseOriginal.length()==i+1){
					break;
				}
				if (espaco[i + 1] == true) {
					if(fraseOriginal.length()==i+2){
						break;
					}
					if (espaco[i + 2] == true) {
						// bloco para 3 espaços em branco
						if(fraseOriginal.length()==i+3){
							break;
						}
						String maiuscula = "" + fraseOriginal.charAt(i + 3);
						maiuscula = maiuscula.toUpperCase();
						frase = frase + " " + maiuscula;
						i = i + 3;

					} else {
						// bloco para 2 espaços em branco
						String maiuscula = "" + fraseOriginal.charAt(i + 2);
						maiuscula = maiuscula.toUpperCase();
						frase = frase + " " + maiuscula;
						i = i + 2;
					}
				} else {
					// bloco para 1 espaço em branco
					String maiuscula = "" + fraseOriginal.charAt(i + 1);
					maiuscula = maiuscula.toUpperCase();
					frase = frase + " " + maiuscula;
					i = i + 1;

				}
			} else {
				// Se a próxima letra não for espaço
				if (!(letra.equals(" "))) {
					String minuscula = "" + fraseOriginal.charAt(i);
					minuscula = minuscula.toLowerCase();
					frase = frase + minuscula;
				}
			}
		}
		return frase;
	}

}
