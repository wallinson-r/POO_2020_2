import java.util.Scanner;

class Menu
{
    public String toString()
    {
        return "Digite a opcao desejada: " + "\n" + "1- Embarcar" + "\n" + "2- Desembarcar" + "\n" +
               "3- Abastecer" + "\n" + "4- Dirigir" + "\n" + "999- Sair";
    }
}

class Carro
{
    //Atributos
    int tanque = 0;
    int maxTanque = 100;
    int km = 0;
    int pessoa = 0;
    int maxPessoa = 2;

    boolean embarcar()
    {
        if( pessoa < maxPessoa )
        {
            pessoa++;
            return true;
        }

        System.out.println("fail: limite de pessoas atingido!");    
        return false;
    }

    boolean desembarcar()
    {
        if( pessoa > 0 && pessoa <= maxPessoa)
        {
            pessoa--;
            return true;
        }
        
        System.out.println("fail: nao ha ninguem no carro!");    
        return false;
    }

    void abastecer(int gasolina)
    {
        if( tanque < maxTanque )
        {
            tanque += gasolina;

            if( tanque > maxTanque )
                tanque = maxTanque;
        }
        
    }

    boolean dirigir(int distancia)
    {
        km = distancia;
        if( pessoa > 0 && tanque > 0 )
        {
            if(distancia > tanque)
            {
                System.out.println("fail: tanque vazio apos andar " + distancia + " km");
                tanque = 0;    
            }
            else
            {
                tanque -= distancia;
            }

            return true;
        }

        System.out.println("\n\nfail: tanque vazio!");
        return false;
    }

    public String toString()
    {
        return "\n\t     -- Saida --\n| Passageiros: " + pessoa + ", " + 
               "Gasolina: " + tanque + ", " + "Km: " + km + " |\n";
    }

    public static void main(String[] args) 
    {
        Carro carro = new Carro();
        Menu imp = new Menu();

        int combustivel;

        System.out.println("Deseja da um passeio pela cidade? S/N");
           
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();


        if( c.equals("S") )
        {
            boolean entra = true;
            while( entra )
            {   
                System.out.println(imp);
                Scanner dados = new Scanner(System.in);
                System.out.print("Digite uma opcao: ");
                int op = dados.nextInt();
                System.out.println("\n");

                switch(op)
                {
                    case 1:
                        carro.embarcar();
                        System.out.println(carro);
                        break;

                    case 2:
                        carro.desembarcar();
                        System.out.println(carro);
                        break;

                    case 3:
                        Scanner coleta1 = new Scanner(System.in);
                        System.out.println("Digite a quantidade de litros para abastecer: ");
                        int gasolina = dados.nextInt();
                        carro.abastecer(gasolina);
                        System.out.println(carro);
                        break;
                    
                    case 4: 
                        Scanner coleta2 = new Scanner(System.in);
                        System.out.println("Digite quantos quilômetros deseja percorrer: ");
                        int quilometragem = dados.nextInt();
                        carro.dirigir(quilometragem);
                        System.out.println(carro);
                        break;

                    case 999:
                        System.out.println("Até a próxima!");
                        entra = false;
                        break;
                    
                    default: 
                        System.out.println("Opcao invalida");
                        break;
                }
            }
        }
        System.out.println("Ok! Aguardarei-te mais tarde!");
    }
}

