# musiccacheAPI
API demonstrativa para e-commerce de discos de vinil com programa de fidelidade baseado em cashback

#Frameworks, liguagens, tecnologias 

Java
Maven
SpringBoot
H2 Database
Rest
Spring Security

#DESCRIÇÃO 

Inicialmente o programa faz a carga de 50 discos de cada gênero musical provenientes do Spotify através de sua API de desenvolvimento. Para isso foi feito o cadastro do projeto no console spotify developer e utilizado a chave e chave secreta fornecidas. Para essa parte da integração foi utilizada a biblioteca michaelthelin.spotify
Os dados são inseridos na tabela tb_album do H2 database

Após a carga dos discos o programa carrega a tabela vigente de cashback previamente fornecida e faz o cadastro na TB_CASHBACK

No projeto foi feita uma implementação simples do spring security, dessa forma todas as requisições devem ser autorizadas através de um usuário e senha válido. Um usuário e senha foi a fim de demonstração foi criado em memória.

#Credenciais

Usuário: TESTE
Senha  : TESTE

#Orientações para Execução

Execute o jar através do comando:
java -jar musiccacheAPI-1.0.0-SNAPSHOT.jar
Acesse no navegador: http://localhost:8885/

 
Após a autenticação o usuário é redirecionado à página home que exibe a estrutura dos serviços presentes na API, orientando o usuário a como filtrar, ordernar e paginar os resultados.

#Exemplos

	-Consultar o catálogo de discos de forma paginada, filtrando por gênero e ordenando de forma crescente pelo nome do disco

http://localhost:8885/album?page=1
http://localhost:8885/album?genre=POP


	-Consultar o disco pelo seu identificador

http://localhost:8885/album/{id}


	-Consultar todas as vendas efetuadas de forma paginada, filtrando pelo range
de datas (inicial e final) da venda e ordenando de forma decrescente pela
data da venda

http://localhost:8885/venda
http://localhost:8885/vendas?page=0&from=2019-05-10&to=2019-05-10


	-Consultar uma venda pelo seu identificador
	
http://localhost:8885/venda/{id}

	-Registrar uma nova venda de discos calculando o valor total de cashback
considerando a tabela.

TIPO:POST
URL: http://localhost:8885/venda
Nota: A requisição deve ser autenticada (Basic Auth)
Exemplo json envio:

{
  "itensvenda": [
    {
      "album": {
        "id": 16002
      }
    },
    {
      "album": {
        "id": 4
      }
    },
    {
      "album": {
        "id": 16006
      }
    }
  ]
}


Exemplo json retorno com as informações da venda:

{
  "idvenda": 23498,
  "itensvenda": [
    {
      "id": 23495,
      "album": {
        "id": 16002,
        "name": "Pop Out (feat. Lil TJay)",
        "genre": "POP",
        "type": "album",
        "images": [
          {
            "id": 15999,
            "widht": 640,
            "hight": 640,
            "url": "https://i.scdn.co/image/37aafcece03a6c843175fca826cfd57d92f41c1a"
          },
          {
            "id": 16000,
            "widht": 300,
            "hight": 300,
            "url": "https://i.scdn.co/image/f8671cfabb24b021dd972667ba55b72515818632"
          },
          {
            "id": 16001,
            "widht": 64,
            "hight": 64,
            "url": "https://i.scdn.co/image/c788c447250123ac0e47052f993a62b30e950bf3"
          }
        ],
        "artists": "Polo G",
        "price": 34.1
      },
      "valor": 34.1,
      "valorcashback": 3.41,
      "perccashback": 10
    },
    {
      "id": 23496,
      "album": {
        "id": 4,
        "name": "Hold On Tight (Acoustic)",
        "genre": "ACOUSTIC",
        "type": "album",
        "images": [
          {
            "id": 1,
            "widht": 640,
            "hight": 640,
            "url": "https://i.scdn.co/image/d7115d384ea07105923302c6e1b052d2557d0d3e"
          },
          {
            "id": 2,
            "widht": 300,
            "hight": 300,
            "url": "https://i.scdn.co/image/9f64525932659946d8777854c6524387eac5c739"
          },
          {
            "id": 3,
            "widht": 64,
            "hight": 64,
            "url": "https://i.scdn.co/image/ca3adf48694200f0ed266b19aa3c57db3c9c9bc8"
          }
        ],
        "artists": "R3HAB",
        "price": 21.82
      },
      "valor": 21.82,
      "valorcashback": 0,
      "perccashback": 0
    },
    {
      "id": 23497,
      "album": {
        "id": 16006,
        "name": "Pop Food",
        "genre": "POP",
        "type": "album",
        "images": [
          {
            "id": 16003,
            "widht": 640,
            "hight": 640,
            "url": "https://i.scdn.co/image/f41c06343d2c077e588320e2d6872af99090edf1"
          },
          {
            "id": 16004,
            "widht": 300,
            "hight": 300,
            "url": "https://i.scdn.co/image/f53fd7676911e27f0420a5e895b164771614bf73"
          },
          {
            "id": 16005,
            "widht": 64,
            "hight": 64,
            "url": "https://i.scdn.co/image/24e52d4a12fa9e270b644ec11271a40b8e5fe18b"
          }
        ],
        "artists": "Jack Stauber",
        "price": 49.91
      },
      "valor": 49.91,
      "valorcashback": 4.991,
      "perccashback": 10
    }
  ],
  "dtvenda": "2019-05-10T01:08:08.082+0000",
  "vltotalcashback": 8.401,
  "vlTotal": 105.83,
  "vlFinal": 97.429
}




