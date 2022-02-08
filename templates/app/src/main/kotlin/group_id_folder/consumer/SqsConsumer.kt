package {{project_group_id}}.consumer

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy
import io.awspring.cloud.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Service

@Service
class SqsConsumer {

    @SqsListener(value = ["\${sqs.queue.consume}"], deletionPolicy = SqsMessageDeletionPolicy.{{inputs.sqs_message_deletion_policy}})
    fun consume(data: String) {
        println("Received: $data")
    }
}
