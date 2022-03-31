## **Implementação**

### **Inputs**

Os inputs necessários para utilizar o plugin são:
| **Campo**                   | **Valor**          | **Parâmetro**                           | **Descrição**                                 |
| :---------------------------| :------------------| :---------------------------------------| :---------------------------------------------|
| sqs_message_deletion_policy | Padrão: ON_SUCCESS | [ALWAYS, NEVER, NO_REDRIVE, ON_SUCCESS] | Política de deleção de mensagens do SQS       |
| sqs_consumer_queue_name     | N/A                | N/A                                     | Nome da fila que receberá as mensagens do SQS |

Mais informações sobre o input **sqs_message_deletion_policy** podem ser encontradas [na documentação do Spring Cloud](https://docs.awspring.io/spring-cloud-aws/docs/2.3.1-SNAPSHOT/apidocs/io/awspring/cloud/messaging/listener/SqsMessageDeletionPolicy.html).