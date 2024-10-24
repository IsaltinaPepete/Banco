package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.ContaCorrenteDAO;
import Model.DAO.ContaPoupancaDAO;
import Model.DAO.TrabalhadorDAO;
import Model.Entidades.Cliente;
import Model.Entidades.ContaCorrente;
import Model.Entidades.ContaPoupanca;
import Model.Entidades.Trabalhador;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Banco ItsaJenny
 */
public class ValidacaoDados {

 static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

    public static boolean validarString(String msg) {
        if (msg == null) {
            return false;
        }

        return true;
    }

    public static char validarChar(String msg) {
        String res = "";
        do {
            try {
                System.out.print(msg);
                res = bfr.readLine();

                if (res.length() != 1) {
                    System.out.println("Escreva apenas uma letra.");
                }
            } catch (IOException ex) {
                System.out.println("Erro ao ler letra.");
            }
        } while (res.length() != 1);
        return res.charAt(0);
    }

    public static char validarCharAlternativas(String msg, char[] alternativas) {
        String res = "";
        boolean valido = false;
        do {
            try {
                System.out.print(msg);
                res = bfr.readLine().toUpperCase();

                for (int i = 0; i < alternativas.length; i++) {
                    if (res.charAt(0) == alternativas[i]) {
                        valido = true;
                        break;
                    }
                }

                if (res.length() != 1) {
                    System.out.println("Escreva apenas uma letra.");
                } else if (!valido) {
                    System.out.println("Opção invália.");
                }

            } catch (IOException ex) {
                System.out.print("Erro ao ler letra.");
            }

        } while (res.length() != 1 || !valido);

        return res.charAt(0);
    }

    public static Float validarFloat(String msg, float min, float max) {
        float res = 0;
        do {
            try {
                System.out.print(msg);
                res = Float.parseFloat(bfr.readLine());

                if (res < min || res > max) {
                    System.out.println("Intervalo inválido [" + min + "-" + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Tipo de número inválido.");
            } catch (IOException ex) {
                System.out.println("Erro ao ler número.");
            }
        } while (res < min || res > max);
        return res;
    }

    public static byte validarByte(String msg, byte min, byte max) {
        byte res = 0;
        do {
            try {
                System.out.print(msg);
                res = Byte.parseByte(bfr.readLine());

                if (res < min || res > max) {
                    System.out.println("Intervalo inválido [" + min + "-" + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Tipo de número inválido.");
            } catch (IOException ex) {
                System.out.println("Erro ao ler número.");
            }
        } while (res < min || res > max);
        return res;
    }

    public static short validarShort(String msg, short min, short max) {
        short res = 0;
        do {
            try {
                System.out.print(msg);
                res = Short.parseShort(bfr.readLine());

                if (res < min || res > max) {
                    System.out.println("Intervalo inválido [" + min + "-" + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Tipo de número inválido.");
            } catch (IOException ex) {
                System.out.println("Erro ao ler número.");
            }
        } while (res < min || res > max);
        return res;
    }

    public static int validarInt(String msg, int min, int max) {
        int res = 0;
        do {
            try {
                System.out.print(msg);
                res = Integer.parseInt(bfr.readLine());

                if (res < min || res > max) {
                    System.out.println("Intervalo inválido [" + min + "-" + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Tipo de número inválido.");
            } catch (IOException ex) {
                System.out.println("Erro ao ler número.");
            }
        } while (res < min || res > max);
        return res;
    }

    public static long validarLong(String msg, long min, long max) {
        long res = 0;
        do {
            try {
                System.out.print(msg);
                res = Long.parseLong(bfr.readLine());

                if (res < min || res > max) {
                    System.out.println("Intervalo inválido [" + min + "-" + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Tipo de número inválido.");
            } catch (IOException ex) {
                System.out.println("Erro ao ler número.");
            }
        } while (res < min || res > max);
        return res;
    }

    public static double validarDouble(String msg, double min, double max) {
        double res = 0;
        do {
            try {
                System.out.print(msg);
                res = Double.parseDouble(bfr.readLine());

                if (res < min || res > max) {
                    System.out.println("Intervalo inválido [" + min + "-" + max + "]");
                }

            } catch (NumberFormatException e) {
                System.out.println("Tipo de número inválido.");
            } catch (IOException ex) {
                System.out.println("Erro ao ler número.");
            }
        } while (res < min || res > max);
        return res;
    }

    public static boolean validarEmail(String message) {

        for (int i = 0; i < message.length() - 1; i++) {
            if (message.charAt(i) == '@'
                    && message.substring(message.length() - 4, message.length()).equalsIgnoreCase(".com")) {
                return true;
            }
        }

        return false;
    }

    public static String validarStringAlternativo(String message, String[] arr) {
        String content = "";
        byte existingIndex = 0;
        do {
            try {
                System.out.println(Arrays.toString(arr));
                System.out.print(message);
                content = bfr.readLine();

                for (byte i = 0; i < arr.length; i++) {
                    if (content.equalsIgnoreCase(arr[i])) {
                        existingIndex = i;
                        break;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Valor Inválido !");
            } catch (IOException ex) {
                System.out.println("Erro de conversão...");
            }

            if (!content.equalsIgnoreCase(arr[existingIndex])) {
                System.out.println("Digite uma das opções válidas...\n");
                //System.out.println(Arrays.toString(arr));
            }
        } while (!content.equalsIgnoreCase(arr[existingIndex]));
        return content.toUpperCase();
    }

    public static LocalDate validarDataLimite(String dia, String mes, String ano) {
        LocalDate data;
        byte d, m;
        int a;
        String aux;
        System.out.println("Data Limite: ");

        d = validarByte(dia, (byte) 1, (byte) 31);
        m = validarByte(mes, (byte) 1, (byte) 12);
        a = validarInt(ano, LocalDate.now().getYear(), 2200);
        aux = a + "-" + m + "-" + d;

        data = LocalDate.parse(aux);

        return data;

    }

    public static boolean validarTelefone(int numero) {
        
                
                if (numero >= 820000000 || numero  <= 879999999) {
                    return true;
                }
           
        return false;
    }

    public static LocalDate validarDataNascimento(String dia, String mes, String ano) {
        System.out.println("Data de Nascimento [DD/MM/AAAA]");
        LocalDate data;
        byte d, m;
        int a;
        String aux;

        d = validarByte(dia, (byte) 1, (byte) 31);
        m = validarByte(mes, (byte) 1, (byte) 12);
        a = validarInt(ano, 1920, LocalDate.now().getYear());
        aux = a + "-" + m + "-" + d;

        data = LocalDate.of(a, m, d);

        return data;

    }

//    public static boolean validarUsuario(String msg1, String msg2) {
//        String nomeUsuario, senha, info;
//        String[] lines;
//        boolean ans = false;
//        try {
//            System.out.println(msg1);
//            nomeUsuario = bfr.readLine();
//            System.out.println(msg2);
//            senha = bfr.readLine();
//            info = nomeUsuario + ";" + senha;
//
//            lines = (Ficheiros.lerFicheiroTxt("FICHEIROS/Textos/credenciais.txt")).split("\n");
//
//            for (String line : lines) {
//                if (line.equalsIgnoreCase(info)) {
//                    ans = true;
//                    break;
//                }
//            }
//
//        } catch (FileNotFoundException e1) {
//            System.out.println("Ficheiro não encontrado !");
//        } catch (IOException io) {
//            System.out.println(io.getMessage());
//        }
//        
//        if (ans == false) {
//            System.out.println("Nome de Usuario Ou Senha Incorretos !");
//        }
//        
//        return ans;
//    }

    static boolean validarIdContaPoupanca(int idConta) {
        ContaPoupancaDAO aux = new ContaPoupancaDAO();
        ArrayList<ContaPoupanca> lista = aux.todos();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getIdConta() == idConta)
                return true;
        }
        return false;
    }

    static boolean validarIdCliente(int idTitular) {
        ClienteDAO cli = new ClienteDAO();
        ArrayList<Cliente> lista = cli.todos();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getId() == idTitular)
                return true;
        }
        return false;
    }

    static boolean validarIdContaCorrente(int idConta) {
         ContaCorrenteDAO aux = new ContaCorrenteDAO();
        ArrayList<ContaCorrente> lista = aux.todos();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getIdConta() == idConta)
                return true;
        }
        return false;
    }

    static boolean validarIdFuncionario(int id) {
        TrabalhadorDAO aux = new TrabalhadorDAO();
        ArrayList<Trabalhador> lista = aux.todos();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getId() == id)
                return true;
        }
        return false;}
 static boolean validarIdFuncionarioDep(int id) {
//        if(id==0){
//            return true;
//        }
//         TrabalhadorDAO aux = new TrabalhadorDAO();
//        ArrayList<Trabalhador> lista = aux.todos();
//        for (int i = 0; i < lista.size(); i++) {
//            if(lista.get(i).getId() == id)
//                return true;
//        }
        return true;
    
    }}