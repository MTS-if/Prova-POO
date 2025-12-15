1️⃣ Identifique o “PRODUTO BASE” do problema

Sempre pergunte:

Qual é o objeto principal que tudo gira em torno?

No seu código:

Produto → Hambúrguer

Em outros casos:
Prova	Produto base
Locadora	Filme
Farmácia	Medicamento
Cinema	Ingresso
Escola	Curso
Transporte	Passagem
Loja	Produto

👉 Esse objeto vira uma classe abstrata.

2️⃣ Tudo que é COMUM → classe abstrata

Pergunte:

O que TODOS esses objetos têm em comum?

Exemplo genérico:
abstract class ProdutoBase {
    protected String nome;
    protected double precoBase;
}


👉 Preço, nome, lista, status… tudo que se repete vai aqui.

3️⃣ Regras que VARIAM → métodos abstratos

No hambúrguer:

protected abstract int getLimiteAdicionais();

Em outro contexto:
🎬 Cinema
protected abstract double getTaxaServico();

🚗 Locadora
protected abstract int getDiasMaximos();


📌 Isso evita if/else gigante → OCP

4️⃣ Ações → Interfaces (ISP)

Pergunte:

O que o sistema FAZ?

Exemplos comuns de prova:
Ação	Interface
Adicionar	Adicionavel
Remover	Removivel
Calcular preço	Calculavel
Cancelar	Cancelavel
Renovar	Renovavel

👉 Só implementa quem precisa.

5️⃣ Regras quebradas → EXCEÇÕES

Sempre pense:

O que pode dar errado?

Hambúrguer:

Limite excedido

Cupom inválido

Outros exemplos:
Contexto	Exceção
Cinema	AssentoOcupadoException
Escola	NotaInvalidaException
Banco	SaldoInsuficienteException
Loja	EstoqueInsuficienteException

📌 Prova AMA exceções.

6️⃣ Classes concretas = variações do produto

Pergunte:

Quais tipos diferentes existem?

Hambúrguer:

Tradicional

Duplo

Outros casos:
Prova	Classes
Cinema	IngressoNormal, IngressoVIP
Escola	CursoTecnico, CursoSuperior
Banco	ContaCorrente, ContaPoupanca
Loja	ProdutoFisico, ProdutoDigital

👉 Todas extends ProdutoBase

7️⃣ Cálculo sempre segue o mesmo padrão

⚙️ Modelo universal de cálculo:

total = precoBase
      + adicionais
      + taxas
      - descontos;


💡 Isso se repete em TODA prova de POO.

8️⃣ MAIN = checklist de nota

Sempre faça:

✅ Criar objetos
✅ Usar métodos
✅ Mostrar resultados
✅ Forçar exceções

Exemplo genérico:

try {
    Produto p = new TipoConcreto();
    p.calcular();
} catch (Exception e) {
    System.out.println(e.getMessage());
}

🎯 EXEMPLO RÁPIDO DE TRANSFORMAÇÃO
🍔 Hambúrguer → 🎬 Cinema
Hambúrguer	Cinema
Produto	Ingresso
Adicional	Serviço extra
Tele-entrega	Taxa de conveniência
Cupom	Meia-entrada
Limite	Assentos disponíveis

💥 Mesma estrutura, outro nome.
