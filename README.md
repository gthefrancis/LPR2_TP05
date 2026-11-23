# LP2I4 (Java) – Trabalho Prático 5 (Threads e Interface Gráfica)
**Instituto Federal de Educação, Ciência e Tecnologia de São Paulo (IFSP) – Câmpus Cubatão**  
**Disciplina:** LP2 (Java) – ADS 471  
**Professor:** Wellington Tuler Moraes  

---

## 📋 Sobre o Projeto

Este projeto foi desenvolvido em estrita conformidade com as instruções do roteiro do **Trabalho Prático 5**:
1. **Estrutura sem classe principal padrão**: O projeto é um aplicativo Java padrão sem classe principal avulsa; o ponto de entrada (`main`) reside no formulário `JFramePrincipal`.
2. **Painel que implementa `Runnable`**: Foi criada a classe `PainelContador` que estende `javax.swing.JPanel` e implementa `java.lang.Runnable`. Cada instância gerencia sua própria lista (`JList` com `DefaultListModel`) e seu rótulo de conclusão (`Final`), além do laço de contagem concorrente.
3. **Formulário `JFramePrincipal`**:
   - Campo **Máximo**: define o teto da contagem das threads (ex.: `1000`).
   - Campos **Prioridade 1** e **Prioridade 2**: aceitam valores entre `1` (`Thread.MIN_PRIORITY`) e `10` (`Thread.MAX_PRIORITY`), com validação e mensagens amigáveis em caso de entrada fora dos limites.
   - Botão **Iniciar**: instancia e dispara as duas threads concorrentes com suas respectivas prioridades (`t1.setPriority(prio1)` e `t2.setPriority(prio2)`).
   - Listas 1 e 2: exibem os valores incrementados durante os laços das threads.
   - Rótulos **Final** (Fim1 e Fim2): permanecem ocultos durante a execução e só se tornam visíveis ao término da contagem de cada respectiva lista.
   - Botão **Limpar**: limpa as listas e oculta os rótulos de finalização.

---

## 📂 Estrutura de Arquivos

```text
TrabalhoPratico5/
├── src/
│   └── trabalhopratico5/
│       ├── JFramePrincipal.java       # Formulario principal JFrame (com metodo main e eventos)
│       ├── JFramePrincipal.form       # Definicao visual para o editor GUI (Matisse) do NetBeans
│       ├── PainelContador.java        # Painel que estende JPanel e implementa Runnable
│       └── PainelContador.form        # Definicao visual do painel no NetBeans
├── nbproject/                         # Configuracao nativa do NetBeans
│   ├── project.xml
│   └── project.properties
├── build.xml                          # Script de construcao Ant
├── manifest.mf                        # Manifesto do executavel
├── compilar_e_executar.bat            # Script em lote para teste rapido no Windows
└── README.md                          # Documentacao explicativa
```

---

## 🚀 Como Abrir e Executar no NetBeans

1. Abra o **Apache NetBeans IDE**.
2. Clique no menu **File** (Arquivo) > **Open Project...** (Abrir Projeto...).
3. Navegue até a pasta:
   ```text
   C:\Users\guian\.gemini\antigravity\scratch\TrabalhoPratico5
   ```
4. Selecione o projeto (ele aparecerá identificado com o ícone de xícara de café do Java) e clique em **Open Project**.
5. Para executar, basta pressionar **F6** (ou clicar com o botão direito sobre o projeto e selecionar **Run** / Executar).
6. Caso deseje visualizar e editar a interface visual:
   - Abra o pacote `trabalhopratico5`.
   - Dê um duplo clique em `JFramePrincipal.java` ou `PainelContador.java`.
   - Clique na aba **Design** na barra superior do editor.

---

## 💻 Como Compilar e Executar via Linha de Comando (Sem IDE)

Você pode executar o arquivo `.bat` ou rodar diretamente no terminal:

```cmd
cd C:\Users\guian\.gemini\antigravity\scratch\TrabalhoPratico5
compilar_e_executar.bat
```

Ou manualmente pelo terminal:
```bash
javac -encoding UTF-8 -d build/classes src/trabalhopratico5/PainelContador.java src/trabalhopratico5/JFramePrincipal.java
java -cp build/classes trabalhopratico5.JFramePrincipal
```
