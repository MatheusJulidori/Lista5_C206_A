package br.inatel.cdg.utils;

import br.inatel.cdg.funcionario.Funcionario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class CSVUtils {


    private static ArrayList<Funcionario> readFileAndCreateFuncs(Path arquivo){

        try {
            List<String> conteudo = Files.readAllLines(arquivo);
            int size = conteudo.size();
            ArrayList<Funcionario> funcs = new ArrayList<>(size);
            int cont = 0;
            conteudo.forEach((linha) -> {
                String[] linhaQuebrada = linha.split(",");
                if (!linhaQuebrada[0].matches("[A-Za-z ]*")) {
                    Funcionario aux = new Funcionario(Integer.parseInt(linhaQuebrada[0]), Double.parseDouble(linhaQuebrada[4]), Integer.parseInt(linhaQuebrada[3]));
                    funcs.add(aux);
                }
            });
            return funcs;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    private static ArrayList<Funcionario> FilterFuncs(ArrayList<Funcionario> funcs){
        funcs.removeIf(func -> func.getNumFilhos() <= 0);
        return funcs;
    }

    public static void generateCSVFuncs(Path arquivo){
        ArrayList<Funcionario> funcs = null;
        try{
            funcs = readFileAndCreateFuncs(arquivo);
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Erro ao ler arquivo");
        }

        try {
            funcs = FilterFuncs(funcs);
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Erro ao filtrar funcionarios");
        }

        String nomeArquivo = "FuncionariosFiltrados.csv";
        String frase = "ID,Filhos,Salario\n";
        Path arquivoFinal = Paths.get(nomeArquivo);
        try {
            //Java11
            Files.writeString(arquivoFinal, frase);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try{
            for(Funcionario f : funcs){
                frase = f.getId()+","+f.getNumFilhos()+","+f.getSalario()+"\n";
                try {
                    //Java11
                    Files.writeString(arquivoFinal, frase, StandardOpenOption.APPEND);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Erro ao escrever no arquivo");
        }

    }
}
