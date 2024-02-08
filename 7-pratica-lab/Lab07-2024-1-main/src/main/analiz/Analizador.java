package analiz;

import java.util.ArrayList;
import java.util.List;

public class Analizador {

    public int[] acha_sequencia(double[] probs, int[] valores) {
        int n = probs.length;
        double[][] dp = new double[n][n];
        int[][] choices = new int[n][n];

        // Calcula o valor esperado para responder apenas à primeira pergunta
        for (int i = 0; i < n; i++) {
            dp[i][0] = probs[i] * valores[i];
            choices[i][0] = i;
        }

        // Calcula o valor esperado para responder a todas as perguntas
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][len - 1] = -1;
                for (int k = i; k < j; k++) {
                    double currentExpectedValue = dp[i][k - i] * (1 - probs[k])
                            + dp[k + 1][j - k - 1] * probs[k];
                    if (currentExpectedValue > dp[i][len - 1]) {
                        dp[i][len - 1] = currentExpectedValue;
                        choices[i][len - 1] = k;
                    }
                }
            }
        }

        // Reconstrói a sequência ótima
        List<Integer> sequenceList = new ArrayList<>();
        reconstructSequence(choices, 0, n - 1, sequenceList);

        // Converte a lista de sequência para um array
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = sequenceList.get(i);
        }

        return sequence;
    }
/// Método auxiliar para reconstruir a sequência ótima
private void reconstructSequence(int[][] choices, int i, int len, List<Integer> sequenceList) {
    if (len >= 0) {
        sequenceList.add(choices[i][len]);
        int nextIndex = choices[i][len] + 1;
        if (nextIndex <= len && nextIndex < choices.length)
            reconstructSequence(choices, nextIndex, len - (choices[i][len] - i), sequenceList);
    }
}


}
