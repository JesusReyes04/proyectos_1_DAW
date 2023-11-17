int limSup;
        int limInf;
        int divisores = 0;
        int contador;
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce un rango de números");
        System.out.println("Introduce el limite superior");
        limSup = leer.nextInt();// se pide el limite superior
        System.out.println("Introduce el límite inferior");
        limInf = leer.nextInt(); // se pide el limite inferior
        while (limInf >= limSup) {
            System.out.println("Introduce el limite superior");
            limSup = leer.nextInt();// se pide el limite superior
            System.out.println("Introduce el límite inferior");
            limInf = leer.nextInt(); // se pide el limite inferior
        }
        contador = limSup;
        while (limSup >= limInf) {
            while (contador > 0) {
                if (limSup % contador == 0) {
                    divisores++;
                    System.out.println();
                }
                contador--;
            }
            limSup--;
            contador = limSup;
        }
