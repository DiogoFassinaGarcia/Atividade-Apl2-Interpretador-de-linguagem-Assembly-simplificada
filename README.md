# Interpretador de Assembly Simplificado – Apl2

Este projeto implementa um interpretador de linguagem Assembly simplificada com suporte a edição e execução interativa via REPL (Read–Evaluate–Print–Loop). 

-------------------------------------------------------------------------------------------------------------------------------------------
| Módulo                 | Responsável | Função principal                                                | Dependências                  |
|------------------------|--------------|-----------------------------------------------------------------|-------------------------------|
| ListaEncadeada.java    | -     | Implementa nós e operações básicas da lista (inserir, remover, atualizar, listar). | Nenhuma                       |
| Arquivo.java           | Diogo     | Carrega e salva arquivos .ed1 da linguagem.                    | ListaEncadeada                |
| Interpretador.java     |   Gustavo   | Executa as instruções da linguagem (mov, add, jnz, etc.).      | ListaEncadeada                |
| Validador.java         | Henrique     | Garante que comandos, registradores e linhas sejam válidos.    | Opcional                      |
| Main.java (REPL)       | -     | Controla entrada do usuário, interpreta comandos e conecta módulos. | Todos os anteriores          |
-------------------------------------------------------------------------------------------------------------------------------------------



