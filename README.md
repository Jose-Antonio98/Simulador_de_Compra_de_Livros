# Simulador de compras de livros

Projeto elaborado visando colocar em pratica conceitos estudados de POO.

Pensando em buscar maneiras de obter uma baixa acoplagem para que o codigo se torne manutenivel e mais flexivel, foi determinado que no pacote de entidades do projeto as classes teriam apenas atributos e metodos padão;

e seriam instanciadas em uma classe que simula um banco de dados e armazena e inicializa as entidades criadas além de possuir metodos de acrescimo de novos itens e de recuperação dos mesmos;

os metodos de adição e obtenção de novos itens por sua vez são manipulados e dentro de outro pacote com o nome de "acoes_negocio", que em suas classes possuem metodos mais elaborados para cadastrar, salvar, e verificar dados nas listas instanciadas dentro da classe que simula o banco de dados em conjunto com a classe do pacote de utilidades "LeitorDados" que é responsavel pela interação com o usuario;

das classes do pacote "acoes_negocio" cito em especial a classe "acoes_Pedido" que é responsavel pelos metodos que geram pedidos e cadastram novos clientes junto aos pedidos, e ao final criar um diretorio para armazenar arquivos .txt que simulam compravantes da compra contendo o nome do cliente, cpf, codigo do pedido, produtos e o valor total;

e por ultimo e não menos importante temos o pacote tela que contem a classe responsavel por inicializar o programa e proporcionar interação com o usuario.
