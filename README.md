# **SQS Consumer Kotlin Plugin** 

- **Descrição:** O plugin de `SQS Consumer` tem como objetivo provisionar a infraestrutura do SQS via CDK, e deixar a aplicação pronta para consumir uma fila da aws.
- **Categoria:** Mensageria. 
- **Stack:** zup-kotlin-stack.
- **Criado em:** 29/03/2022.
- **Última atualização:** 29/03/2022.
- **Download:** https://github.com/stack-spot/sqs-consumer-app-kt-plugin.git

## **Visão Geral**

O **sqs-consumer-app-kt-plugin** é um plugin que tem como objetivo o serviço de filas de mensagens gerenciado que permite o desacoplamento e a escalabilidade de microsserviços. Ao adicionar o plugin na aplicação é possível escolher a política de deleção das mensagens no SQS e informar o nome da fila.

### **Pré-requisitos**
- Para utilizar esse plugin, é necessário:
  -  Instalação do STK CLI da StackSpot.
  -  Importar a stack `zup-kotlin-stack` através do STK CLI.
     - `stk import https://github.com/stack-spot/zup-kotlin-stack`   
  - Ter uma aplicação criada pelo template da stack importada.
- Possuir Java 11 instalado na máquina.

### **Como o plugin funciona?** 

 Ao aplicar o plugin, serão adicionados os recursos necessários para que seja possível provisionar a infraestrutura do SQS via CDK na cloud, além de configurar um listener de SQS na aplicação e as suas dependências necessárias.
  - **Infraestrutura:** Utilizando CDK o plugin entrega uma [NestedStack](https://docs.aws.amazon.com/cdk/api/v2/docs/aws-cdk-lib.NestedStack.html) que provisiona na Cloud da AWS a criação da fila informada.
  - **App:** Como facilitador, o plugin entrega uma classe definida como um serviço (@Service), que contém um `listener` já preparado para consumir os dados da fila informada via `input`, porém o desenvolvedor tem total liberdade para customizar essa classe e listener conforme sua necessidade. Para mais informações sobre esse recurso acesse [stackspot - SqsConsumer.kt](https://github.com/stack-spot/sqs-consumer-app-kt-plugin/blob/main/templates/app/src/main/kotlin/group_id_folder/consumer/SqsConsumer.kt).

### **Como adicionar o plugin na aplicação?**

Para aplicar o plugin, primeiramente é necessário ter executado os passos do [Pré-requisitos](#Pré-requisitos). Após isso, crie sua a aplicação utilizando o CLI da StackSpot, acesse a pasta raiz do projeto e execute o comando abaixo para aplicar o plugin:
 
`os apply plugin zup-kotlin-stack/sqs-consumer-app-kt-plugin`


## **Configuração**

### **Inputs**

Os inputs necessários para utilizar o plugin são:
| **Campo**                   | **Valor**          | **Parâmetro**                           | **Descrição**                                 |
| :---------------------------| :------------------| :---------------------------------------| :---------------------------------------------|
| sqs_message_deletion_policy | Padrão: ON_SUCCESS | [ALWAYS, NEVER, NO_REDRIVE, ON_SUCCESS] | Política de deleção de mensagens do SQS       |
| sqs_consumer_queue_name     | N/A                | N/A                                     | Nome da fila que receberá as mensagens do SQS |

Mais informações sobre o input **sqs_message_deletion_policy** podem ser encontradas [na documentação do Spring Cloud](https://docs.awspring.io/spring-cloud-aws/docs/2.3.1-SNAPSHOT/apidocs/io/awspring/cloud/messaging/listener/SqsMessageDeletionPolicy.html).
