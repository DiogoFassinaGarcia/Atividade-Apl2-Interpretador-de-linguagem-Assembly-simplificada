# Interpretador de Assembly Simplificado – Apl2

Este projeto implementa um interpretador de linguagem Assembly simplificada com suporte a edição e execução interativa via REPL (Read–Evaluate–Print–Loop). 

-------------------------------------------------------------------------------------------------------------------------------------------
| Módulo                 | Responsável | Função principal                                                | Dependências                  |
|------------------------|--------------|-----------------------------------------------------------------|-------------------------------|
| ListaEncadeada.java    | Pessoa 1     | Implementa nós e operações básicas da lista (inserir, remover, atualizar, listar). | Nenhuma                       |
| Arquivo.java           | Pessoa 2     | Carrega e salva arquivos .ed1 da linguagem.                    | ListaEncadeada                |
| Interpretador.java     | Pessoa 3     | Executa as instruções da linguagem (mov, add, jnz, etc.).      | ListaEncadeada                |
| Validador.java         | Pessoa 4     | Garante que comandos, registradores e linhas sejam válidos.    | Opcional                      |
| Main.java (REPL)       | Pessoa 5     | Controla entrada do usuário, interpreta comandos e conecta módulos. | Todos os anteriores          |
-------------------------------------------------------------------------------------------------------------------------------------------



