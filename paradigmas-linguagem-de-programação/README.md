README

Passo a passo de como baixar e instalar o clisp, para rodar a aplicação.

No Windows

- Primeiro passo: Acesse o link: <https://sourceforge.net/projects/clisp/>, ao acessar o link clique no botão “Download” aguarde cinco segundos e o download será iniciado.
- Segundo passo: Após fazer o download, vamos precisar descompactar o arquivo que foi baixado, por padrão o arquivo vem no formato .zip, então o Windows consegue descompactar o download sem precisar baixar algum programa que faça essa função, caso o usuário tenha algum programa que descompacte arquivos ele pode ser usado sem problemas.
- Terceiro passo: Após descompactarmos os arquivos uma pasta é gerada, dentro dessa pasta o arquivo “clisp” é o aplicativo que irá executar os programas.
- Terceiro passo: Assim que o aplicativo for aberto, para executar o programa iremos usar o seguinte comando (load "...zubber/main.lisp"). No lugar da reticência iremos colocar o endereço onde está salvo os arquivos do programa. Exemplo: (load ".../zubber/main.lisp") usando esse exemplo também é necessário que seja mudado dentro do código o caminho onde os arquivos do programa estão salvos no seu computador, no arquivo Main, Warrior e Motorista o programa puxa esses 3 arquivos, segue um exemplo das linhas onde o programa puxa os arquivos.

Main

(load "/zubber/motorista.lisp")
(load "/zubber/usuario.lisp")
(load "/zubber/warrior.lisp")
(Ler_comercio "/zubber/arquivos/Itens_restaurantes.txt" 5)
(Ler_comercio "/zubber/arquivos/Itens_farmacias.txt" 4)
(Ler_comercio "/zubber/arquivos/Itens_supermercados.txt" 3)
(Ler_comercio "/zubber/arquivos/Itens_livrarias.txt" 2)

Warrior

(Escrever\_item "/zubber/arquivos/Itens\_restaurantes.txt" 5))
(Escrever\_item "/zubber/arquivos/Itens\_farmacias.txt" 4))
(Escrever\_item "/zubber/arquivos/Itens\_supermercados.txt" 3))
(Escrever\_item "/zubber/arquivos/Itens\_livrarias.txt" 2))

Motorista

(with-open-file (stream "/zubber/arquivos/Locais.txt")
(with-open-file (stream "/zubber/arquivos/Motoristas.txt")
(with-open-file (f "/zubber/arquivos/Motoristas.txt":direction :output :if-exists :append :if-does-not-exist :create)
(with-open-file (f "/zubber/arquivos/Locais.txt":direction :output :if-exists :append :if-does-not-exist :create)

Para que não ocorra erro, é necessário que seja alterado dentro do código para o local onde está salvo o programa dentro do computador do usuário.

No Linux

- Primeiro passo: Para baixar e instalar o clisp no seu Linux, abra o terminal, usaremos o seguinte comando sudo apt-get install clisp.
- Segundo passo: Para executarmos o programa iremos abrir o terminal e usar o comando clisp, com isso o programa irá executar em seu computador.
- Terceiro passo: Assim que o aplicativo for aberto, para executar o programa iremos usar o seguinte comando (load "...zubber/main.lisp"). No lugar da reticência iremos colocar o endereço onde está salvo os arquivos do programa. Exemplo: (load "...zubber/main.lisp") usando esse exemplo também é necessário que seja mudado dentro do código o caminho onde os arquivos do programa estão salvos no seu computador, no arquivo Main, Warrior e Motorista o programa puxa esses 3 arquivos, segue um exemplo das linhas onde o programa puxa os arquivos.

Main

(load "/zubber/motorista.lisp")
(load "/zubber/usuario.lisp")
(load "/zubber/warrior.lisp")
(Ler_comercio "/zubber/arquivos/Itens_restaurantes.txt" 5)
(Ler_comercio "/zubber/arquivos/Itens_farmacias.txt" 4)
(Ler_comercio "/zubber/arquivos/Itens_supermercados.txt" 3)
(Ler_comercio "/zubber/arquivos/Itens_livrarias.txt" 2)

Warrior

(Escrever\_item "/zubber/arquivos/Itens\_restaurantes.txt" 5))
(Escrever\_item "/zubber/arquivos/Itens\_farmacias.txt" 4))
(Escrever\_item "/zubber/arquivos/Itens\_supermercados.txt" 3))
(Escrever\_item "/zubber/arquivos/Itens\_livrarias.txt" 2))

Motorista

(with-open-file (stream "/zubber/arquivos/Locais.txt")
(with-open-file (stream "/zubber/arquivos/Motoristas.txt")
(with-open-file (f "/zubber/arquivos/Motoristas.txt":direction :output :if-exists :append :if-does-not-exist :create)
(with-open-file (f "/zubber/arquivos/Locais.txt":direction :output :if-exists :append :if-does-not-exist :create)

Para que não ocorra erro, é necessário que seja alterado dentro do código para o local onde está salvo o programa dentro do computador do usuário.

- Caso tenha dificuldade ou mais dúvidas sobre o processo de instalação do clisp, segue um link que poderá auxiliar no processo. <https://howtoinstall.co/pt/clisp> 

Executando o programa

- Assim que o programa for usado execute o comando (Pedir_servico), após executar esse comando iremos escolher o tipo do serviço que pode ser de entrega ou viagem. Caso seja escolhido o serviço de entrega, o usuário irá fornecer o local da compra, o local de entrega e escolher os itens da lista que serão comprados. Caso o usuário escolha o serviço de viagem, deverá fornecer a sua localização e o endereço de destino. Os nomes de locais solicitados pelo programa devem corresponder os descrito no arquivo txt “Locais” para que a execução ocorra corretamente, não encontrando a localização fornecida o programa solicitara a inclusão desse local e seus respectivos dados. Em ambos os serviços o programa irá escolher o motorista mais próximo do usuário e o status do motorista irá ser atualizado de “livre” para “ocupado”. Durante a execução do programa todos os motoristas, locais e itens estão em nossos arquivos TXT que vem junto com o código.

Finalizando um serviço

- Para finalizar o serviço devemos usar o comando (Finalizar ID), o motorista irá fornecer o seu ID de registro para o sistema, supondo que temos um ID igual a 5 que acaba de encerrar um serviço e o motorista deseja finalizá-lo será usada a função "(Finalizar 5)" dessa forma sua localização será atualizada para a atual e seu status estará disponível para novos serviços, finalizando assim o serviço.

