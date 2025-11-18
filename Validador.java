/* Validador.java */
/* Valida a sintaxe das instrucoes da linguagem assembly simplificada */

public class Validador {
    // valida instrucao
    public static boolean validarInstrucao(int ln, String inst, StringBuilder err) {

        // limpa erro
        limpaErro(err);
        // guarda original
        String instOrig = inst;

        if (inst == null) {
            addErro(err, "Linha " + ln + ": instrucao nula");
            return false;
        }

        // copia simples
        String s = inst + "";
        // tira espacos
        s = s.trim();

        if (s.length() == 0) {
            addErro(err, "Linha " + ln + ": instrucao vazia");
            return false;
        }

        // separa por espaco
        String[] p = s.split("\\s+");

        if (p.length == 0) {
            addErro(err, "Linha " + ln + ": instrucao invalida");
            return false;
        }

        // opcode
        String op = p[0];
        // minusculo
        op = op.toLowerCase();

        // num args
        int na = p.length - 1;
        if (na < 0) {
            addErro(err, "Linha " + ln + ": erro contagem args");
            return false;
        }

        // array args
        String[] a = new String[na];

        // preenche args
        int i = 0;
        while (i < na) {
            a[i] = p[i + 1];
            i = i + 1;
        }

        // escolhe funcao
        if (op.equals("mov")) {
            return validarMov(ln, a, err);
        } else if (op.equals("inc") || op.equals("dec")) {
            return validarIncOuDec(ln, op, a, err);
        } else if (op.equals("add") || op.equals("sub") ||
                   op.equals("mul") || op.equals("div")) {
            return validarOpBin(ln, op, a, err);
        } else if (op.equals("jnz")) {
            return validarJnz(ln, a, err);
        } else if (op.equals("out")) {
            return validarOut(ln, a, err);
        } else {
            addErro(err, "Linha " + ln + " - opcode desconhecido: " + op);
            return false;
        }
    }

    // valida mov
    private static boolean validarMov(int ln, String[] a, StringBuilder err) {

        if (a == null) {
            addErro(err, "Linha " + ln + ": args nulos mov");
            return false;
        }
        if (a.length != 2) {
            addErro(err, "Linha " + ln + ": mov precisa 2 args");
            return false;
        }
        // args
        String x = a[0];
        String y = a[1];

        // x deve ser registrador
        if (!regValido(x)) {
            addErro(err, "Linha " + ln + ": arg1 mov invalido: " + x);
            return false;
        }
        // checa y
        boolean yReg = regValido(y);
        boolean yInt = intValido(y);

        if (!yReg && !yInt) {
            addErro(err, "Linha " + ln + ": arg2 mov invalido: " + y);
            return false;
        }
        return true;
    }

    // valida inc/dec
    private static boolean validarIncOuDec(int ln, String op, String[] a, StringBuilder err) {

        if (a == null) {
            addErro(err, "Linha " + ln + ": args nulos " + op);
            return false;
        }
        if (a.length == 0) {
            addErro(err, "Linha " + ln + ": " + op + " sem args");
            return false;
        }
        if (a.length != 1) {
            addErro(err, "Linha " + ln + ": " + op + " precisa 1 arg");
            return false;
        }
        String x = a[0];

        if (!regValido(x)) {
            addErro(err, "Linha " + ln + ": reg invalido em " + op + ": " + x);
            return false;
        }
        return true;
    }


    // valida op binaria
    private static boolean validarOpBin(int ln, String op, String[] a, StringBuilder err) {

        if (a == null) {
            addErro(err, "Linha " + ln + ": args nulos " + op);
            return false;
        }
        if (a.length != 2) {
            addErro(err, "Linha " + ln + ": " + op + " precisa 2 args");
            return false;
        }
        String x = a[0];
        String y = a[1];

        // x registrdor
        if (!regValido(x)) {
            addErro(err, "Linha " + ln + ": arg1 invalido " + op + ": " + x);
            return false;
        }
        // y reg ou int.
        boolean yReg = regValido(y);
        boolean yInt = intValido(y);

        if (!yReg && !yInt) {
            addErro(err, "Linha " + ln + ": arg2 invalido " + op + ": " + y);
            return false;
        }
        return true;
    }

    // valida jnz
    private static boolean validarJnz(int ln, String[] a, StringBuilder err) {

        if (a == null) {
            addErro(err, "Linha " + ln + ": args nulos jnz");
            return false;
        }
        if (a.length != 2) {
            addErro(err, "Linha " + ln + ": jnz precisa 2 args");
            return false;
        }
        String x = a[0];
        String y = a[1];

        // x reg
        if (!regValido(x)) {
            addErro(err, "Linha " + ln + ": arg1 invalido jnz: " + x);
            return false;
        }
        // y int
        if (!intValido(y)) {
            addErro(err, "Linha " + ln + ": arg2 invalido jnz: " + y);
            return false;
        }
        return true;
    }

    // valida out
    private static boolean validarOut(int ln, String[] a, StringBuilder err) {

        if (a == null) {
            addErro(err, "Linha " + ln + ": args nulos out");
            return false;
        }
        if (a.length != 1) {
            addErro(err, "Linha " + ln + ": out precisa 1 arg");
            return false;
        }
        String x = a[0];

        // sem linha
        if (!regValido(x)) {
            addErro(err, "Reg invalido em out: " + x);
            return false;
        }
        return true;
    }

    // checa registrador
    private static boolean regValido(String s) {

        if (s == null) return false;
        if (s.length() != 1) return false;
        char c = Character.toUpperCase(s.charAt(0));
        return (c >= 'A' && c <= 'Z');
    }

    // checa inteiro
    private static boolean intValido(String s) {

        if (s == null) return false;
        if (s.length() == 0) return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // limpa erro
    private static void limpaErro(StringBuilder err) {
        if (err != null) err.setLength(0);
    }
    // adiciona erro
    private static void addErro(StringBuilder err, String msg) {
        if (err != null) err.append(msg);
    }
}
