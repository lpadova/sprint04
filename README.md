# Challenge 03

## Integrantes do Grupo:
- Luis Felipe Robbo - RM82762
- Felipe Roque      - RM86373
- Lucas Kazuo       - RM81223
- Lucas Padovani    - RM80203


## Objetivo do Projeto:
Aproposta da Challenge visa resolver oseguinteproblema “Como a internet das coisas(IoT) pode ajudar
na experiência do cliente?”. Com isso em mente, nosso grupo definiu como o objetivo principal do nosso
projeto o desenvolvimento de uma solução para melhorar e maximizar a experiência do usuário/cliente que
utilizam Wearables (Dispositivos vestíveis) no dia a dia.


## Escopo do projeto:
inhado aproposta da Challenge e o objetivo definido pela equipe, focaremos no uso dosWearables aplicado 
na saúde do usuário/cliente. Para isso, desenvolveremos um app que permitirá o usuário conectar todos os
seus Wearebles com o intuito de acompanhar e monitorar sua saúde. 

Os dados do weareble serão sincronizados
com o app, assim criando uma persona para o usuário/cliente. Comesses dados será possível criar um histórico
que nos permitirá analisar e monitorar as mudanças nasaúde do usuárioe informá-loquando identificarmos alguma
alteração significativa. 

O intuito do app é assegurar a saúde e incentivar osusuáriosa criarem uma rotina
saudável parasua vida, eles conseguirão mensurar suas evoluçõesou regressõesao longo do tempo.


## Definição da arquitetura:
Para a utilização da nossa solução o clientedeverá possuir um smartphone, um weareble válidoe 
acesso a internet,nosso app estará disponívelna google play e Apple store.

O weareble realizará
a conexão via Bluetooth como dispositivo mobile, onde nosso aplicativo irá colher as informações
disponibilizadas pelo IoT e enviar para a nuvem (Azure ou AWS) via protocolo HTTPS.

Após o recebimento dos dados na nuvem,eles serão encaminhados para nossa aplicação que rodará em uma
máquina virtual da nuvem, onde serão tratados, validados e armazenados em um bancode dados também em nuvem.

Com esse fluxo finalizado, os dados serãoretornadospara o aplicativo de forma simplificada, facilitando a
visualização e entendimento do usuário. As conexões entre o app, nuvem e aplicação será feita via REST
com protocolo HTTPS.


## Descrição das funcionalidades
O Backend será responsável por receber informação gerada pelo App / wearable e também disponibilizar dados 
processados ao App / Web, trazendo assim informações compactadas e resumidas, facilidando o entendimento do usuário.



## Tabela de Endpoints 

<ul>
    <h3>Usuário</h3>
    <li>01 -  localhost:8080/api/usuario......... - (POST). - Create</li>
    <li>02 -  localhost:8080/api/usuario......... - (GET)... - FindAll</li>
    <li>03 -  localhost:8080/api/usuario/{id}... - (GET)... - FindOne</li>
    <li>04 -  localhost:8080/api/usuario/{id}... - (PUT).... - Update</li>
</ul>

<ul>
    <h3>Estado</h3>
    <li>01 -  localhost:8080/api/estado.......... - (POST).. - Create</li>
    <li>02 -  localhost:8080/api/estado.......... - (GET).... - FindAll</li>
    <li>03 -  localhost:8080/api/estado/{id}.... - (GET).... - FindOne</li>
</ul>

<ul>
    <h3>Informações do Usuário</h3>
    <li>01 -  localhost:8080/api/infoUser.......... - (POST).. - Create</li>
    <li>02 -  localhost:8080/api/infoUser.......... - (GET).... - FindAll</li>
    <li>03 -  localhost:8080/api/infoUser/{id}.... - (GET).... - FindOne</li>
    <li>04 -  localhost:8080/api/infoUser/{id}.... - (PUT).... - Update</li>
</ul>

<ul>
    <h3>Consulta</h3>
    <li>01 - localhost:8080/api/consulta/?cpf=xxxx ..... - (GET) - ConsultaResumida</li>
</ul>


## JSON Criar usuário


```JSON
{
    "nome"  : "Rebeca",
    "email" : "rebeca@email.com",
    "senha" : "12345678",
    "dataNascimento" :  "2003-01-03", 
    "cpf" : "46398065003",
    "genero" : {
        "descricao" : "Feminino"
    },
    "estados": [
        {
        "numeroAtualizacao" : 1,
        "dataAtualizacao" : "2021-09-11",
        "pressaoArterial" : "12/08",
        "monitoramentoCardiaco" : "90",
        "temperatura" : "36.0"            
        },
        {
        "numeroAtualizacao" : 2,
        "dataAtualizacao" : "2021-09-11",
        "pressaoArterial" : "13/7",
        "monitoramentoCardiaco" : "85",
        "temperatura" : "37.2"            
        }
    ],
    "infoUsers" :[
        {
            "numeroAtualizacao" : 1,
            "dataAtualizacao" : "2021-09-09",
            "altura" : 1.83,
            "peso" : 90.0
        }
    ]
    
}
```

## JSON para atualizar usuário

```json
{
    "nome": "Rebeca Robbo",
    "email": "rr@email.com",
    "senha": "03012003"
}
```

## Json para criar estado

```json
[
    {
        "numeroAtualizacao" : 1,
        "dataAtualizacao" : "2021-09-09",
        "pressaoArterial" : "14/09",
        "monitoramentoCardiaco" : "90",
        "temperatura" : "36.0",
         "usuario": {
            "nome" : "Luis",
            "cpf" : "47071670803"
        }                           
    },
    {
        "numeroAtualizacao" : 2,
        "dataAtualizacao" : "2021-09-09",
        "pressaoArterial" : "14/10",
        "monitoramentoCardiaco" : "85",
        "temperatura" : "37.2",
         "usuario": {
            "nome" : "Luis",
            "cpf" : "47071670803"
        }                           
    }               
]
```

## JSON para criar Informações do usuário 
```json
[
    {
        "numeroAtualizacao" : 2,
        "dataAtualizacao" : "2021-09-09",
        "altura" : 1.83,
        "peso" : 90.0,
         "usuario": {
            "nome" : "Luis",
            "cpf" : "47071670803"
        }              
        
    }
]
```

## JSON para atualizar Informações do usuário
```json
  {
    "numeroAtualizacao": 2,
    "dataAtualizacao": "2021-09-10",
    "altura": 1.83,
    "peso": 94.0
}
```