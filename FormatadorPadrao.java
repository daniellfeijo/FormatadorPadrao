public class FormatadorPadrao {
	String string = "";
	String primeiraLetra = "";
	String frase = "";

	public String formatar(String string) {
		primeiraLetra = "" + string.charAt(0);
		frase = primeiraLetra.toUpperCase();
		// Meu primeiro passo foi varrer toda a frase
		// em busca de espaços em brancos
		// onde tiver espaço em branco ele marca
		// como true
		boolean[] espaco;
		espaco = new boolean[string.length()];
		for (int i = 1; i < string.length(); i++) {
			String letra = "" + string.charAt(i);
			if (letra.equals(" ")) {
				espaco[i] = true;
			} else {
				espaco[i] = false;
			}
		}
		for (int i = 1; i < string.length(); i++) {
			String letra = "" + string.charAt(i);
			// Se a próxima letra for um espaço em
			// branco
			if (espaco[i] == true) {
				if (espaco[i + 1] == true) {
					if (espaco[i + 2] == true) {
						// bloco para 3 espaços em branco
						String maiuscula = "" + string.charAt(i + 3);
						maiuscula = maiuscula.toUpperCase();
						frase = frase + " " + maiuscula;
						i = i + 3;

					} else {
						// bloco para 2 espaços em branco
						String maiuscula = "" + string.charAt(i + 2);
						maiuscula = maiuscula.toUpperCase();
						frase = frase + " " + maiuscula;
						i = i + 2;
					}
				} else {
					// bloco para 1 espaço em branco
					String maiuscula = "" + string.charAt(i + 1);
					maiuscula = maiuscula.toUpperCase();
					frase = frase + " " + maiuscula;
					i = i + 1;

				}
			} else {
				// Se a próxima letra não for espaço
				if (!(letra.equals(" "))) {
					String minuscula = "" + string.charAt(i);
					minuscula = minuscula.toLowerCase();
					frase = frase + minuscula;
				}
			}
		}
		return frase;
	}

	public static void main(String[] args) {
		FormatadorPadrao fmt = new FormatadorPadrao();
		System.out.println(fmt.formatar("TESTE   DO   METODO"));

	}

}
