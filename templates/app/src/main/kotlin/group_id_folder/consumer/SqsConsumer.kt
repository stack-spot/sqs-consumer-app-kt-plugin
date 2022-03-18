package {{project_group_id}}.consumer

import com.stackspot.logging.LoggerFactory
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy
import io.awspring.cloud.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Service

@Service
class SqsConsumer {

    private val logger = LoggerFactory.resource(SqsConsumer::class)

    @SqsListener(value = ["\${sqs.queue.consume}"], deletionPolicy = SqsMessageDeletionPolicy.{{inputs.sqs_message_deletion_policy}})
    fun consume(data: String) {
        logger.info{ "Received: $data" }
    }
}
