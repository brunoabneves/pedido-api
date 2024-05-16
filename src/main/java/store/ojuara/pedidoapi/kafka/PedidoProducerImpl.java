package store.ojuara.pedidoapi.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducerImpl {

    private static final Logger logger = LoggerFactory.getLogger(PedidoProducerImpl.class);
    private final String topic;
    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public PedidoProducerImpl(@Value("${mensageria.kafka.topic.pedido.processado}") String topic, KafkaTemplate<Object, Object> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public <T> void send(T dados){
        kafkaTemplate.send(topic, dados).addCallback(
                success -> {
                    assert success != null;
                    logger.info("Mensagem enviada com sucesso" + success.getProducerRecord().value());
                },
                failure -> logger.info("Falha ao enviar mensagem" + failure.getMessage())
        );
    }
}
