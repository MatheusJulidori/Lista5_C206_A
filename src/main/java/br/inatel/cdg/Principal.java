package br.inatel.cdg;

import br.inatel.cdg.utils.CSVUtils;
import java.nio.file.*;

public class Principal {

    public static void main(String[] args) {

        Path arquivo = Paths.get("funcionarios.csv");

        CSVUtils.generateCSVFuncs(arquivo);

    }

}
