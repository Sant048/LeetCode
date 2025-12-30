package LongestSubstringWithoutRepeatingCharacters;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // "Vector B": Almacena la última posición (índice) vista de cada carácter.
        // Usamos 128 para cubrir todos los caracteres ASCII estándar (letras, números, símbolos).
        int[] mapaPosiciones = new int[128];

        // Inicializamos con -1 porque el índice 0 es una posición válida en el string.
        for (int i = 0; i < 128; i++) {
            mapaPosiciones[i] = -1;
        }

        int maximoLargo = 0;
        int izquierda = 0; // El inicio de nuestra "ventana" o subcadena actual.

        // "Vector A": Recorremos el string carácter por carácter (Búsqueda lineal).
        for (int derecha = 0; derecha < s.length(); derecha++) {
            char caracterActual = s.charAt(derecha);

            // BUSCAR COINCIDENCIA:
            // Si el carácter ya fue visto Y su posición es mayor o igual a 'izquierda',
            // significa que tenemos un duplicado dentro de nuestra ventana actual.
            if (mapaPosiciones[caracterActual] >= izquierda) {
                // Saltamos 'izquierda' justo después de la última posición de la coincidencia.
                izquierda = mapaPosiciones[caracterActual] + 1;
            }

            // GUARDAR POSICIÓN: Actualizamos el "Vector B" con el índice más reciente.
            mapaPosiciones[caracterActual] = derecha;

            // CALCULAR SOLUCIÓN: La distancia entre punteros nos da el tamaño de la subcadena.
            // Se suma 1 porque los índices empiezan en 0.
            maximoLargo = Math.max(maximoLargo, derecha - izquierda + 1);
        }

        return maximoLargo;
    }
}