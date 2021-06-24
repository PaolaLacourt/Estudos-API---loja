# DesafioAPI - Programa Starter

Neste projeto será desenvolvida uma Rest API, que contem os métodos HTTP básicos (GET, POST, PUT e DELETE) para um sistema de controle de estoque e vendas de uma loja de roupas.

Acessos:
Perfil Loja:
"email" : "admin@gmail.com",
"senha" : "123456"

Perfil Cliente:
"ermail" : "client@hotmail.com",
"senha" : "123456"

Sobre o sistema:

- Todos os campos são validados.
- O endereço tem como campos obrigatórios: Logradouro, Número, Complemento, CEP, Bairro, Município e Estado.

•	Usuário do perfil Loja: 

- O usuário do perfil Loja cadastra produtos e fornecedores. 
- A Loja realiza compras para gerar estoque. Cada compra registrada acrescenta na quantidade do estoque. 
- Uma compra pode ter vários produtos(itens). 
- A única alteração no Estoque possível é a alteração do Valor de Venda. 

•	 Usuário do perfil Cliente: 

- Este usuário pode se registrar por conta própria, ou seja, sem autenticação. 
- O cliente consegue listar os produtos da loja, mas somente aqueles que tem em estoque e com Valor de Venda definido. 
- Quando efetuada uma venda, o sistema verifica se o produto possui estoque, e se não possuir, o sistema envia uma mensagem de erro para o usuário e não permiti a operação. 
- Uma venda podera ter vários produtos(itens). 
- Ao efetuar uma venda, será criado um Status: “Pendente”. O Cliente será responsável por confirmar o recebimento do produto.

Exceeds desse projeto:

- Filtro por nome do Produto, na busca dos produtos.
- Endpoints com ordenação alfabética (ascendente e descendente) e Paginação na busca dos produtos.
