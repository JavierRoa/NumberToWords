public class NumberToWords {
    public static void main(String[] args) {
        System.out.println(getDigitCount(0));
        System.out.println(getDigitCount(123));
        System.out.println(getDigitCount(-12));
        System.out.println(getDigitCount(5200));
        System.out.println(reverse(-121));
        System.out.println(reverse(1212));
        System.out.println(reverse(1234));
        System.out.println(reverse(100));
        numberToWords(123);
        numberToWords(1010);
        numberToWords(1000);
        numberToWords(-12);
    }
    private static void numberToWords(int number) {
        // Valido que number sea positivo.
        if(number<0) {
            System.out.println("Invalid Value");
        }
        // Imprimo respuesta final en caso de number 0.
        else if (number == 0) {
            System.out.println("Zero");
        }
        String result = "";  // Creo un string vacío
        int reversedNumber = reverse(number);  // Creo una variable para procesar, cuyo valor es el resultado de la función reverse con parámetro number.
        int reversedNumberDigitCount = getDigitCount(reversedNumber);  // Creo una variable, cuyo valor es el número de dígitos de reversedNumber.
        while(reversedNumber>0) {
            int lastDigit = reversedNumber % 10;  // Creo (o reasigno) una variable con el valor actual del mod 10 de reversedNumber.
            // Uso un switch para imprimir la palabra escrita de cada valor de lastDigit.
            switch (lastDigit) {
                case 0 -> result += "Zero";
                case 1 -> result += "One";
                case 2 -> result += "Two";
                case 3 -> result += "Three";
                case 4 -> result += "Four";
                case 5 -> result += "Five";
                case 6 -> result += "Six";
                case 7 -> result += "Seven";
                case 8 -> result += "Eight";
                case 9 -> result += "Nine";
            }
            reversedNumber /= 10;  // Divido reversedNumber / 10 para eliminar el último dígito.
            // Agrego " " en caso de que aún queden dígitos por pasar a palabras.
            if(reversedNumber>0) {
                result += " ";
            }
        }
        //  Uso un bucle for para agregar cada " Zero" que debería haber en el resultado, pero que por la función reverse fueron eliminados.
        for(int i = reversedNumberDigitCount; i < getDigitCount(number); i++) {
            result += " Zero";
        }
        System.out.println(result);  // Imprimo result.
    }
    private static int reverse(int number) {
        int reversedNumber = 0;  // Creo una variable para almacenar el número revertido.
        // Uso un bucle while, en el cual:
        while(number!=0) {
            int lastDigit = number % 10;  // Creo (o reasigno) una variable al mod 10 de number.
            reversedNumber = reversedNumber * 10 + lastDigit;  // Multiplico reversedNumber * 10 y le sumo lastDigit.
            number /= 10;  // Divido number / 10, para eliminar el último dígito.
        }
        return reversedNumber;  // Retorno.
    }
    private static int getDigitCount(int number){
        int absNumber = Math.abs(number);  // Creo una variable cuyo valor es el absoluto de number.
        return Integer.toString(absNumber).length();  // Retorno el largo de absNumber, transformado en string.
    }
}