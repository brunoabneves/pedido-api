package store.ojuara.pedidoapi.kafka;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import store.ojuara.pedidoapi.domain.dto.ItemPedidoDTO;
import store.ojuara.pedidoapi.domain.model.ItemPedido;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoProducerImpl implements KafkaProducer<List<ItemPedidoDTO>> {

    private static final Logger logger = LoggerFactory.getLogger(PedidoProducerImpl.class);

    @Value(value = "${mensageria.kafka.topic.pedido.processado}")
    private final String topic;
    private final KafkaTemplate<String, List<ItemPedidoDTO>> kafkaTemplate;

    @Override
    public void send(List<ItemPedidoDTO> itens){
        kafkaTemplate.send(topic, itens).addCallback(
                success -> {
                    assert success != null;
                    logger.info("Mensagem enviada com sucesso" + success.getProducerRecord().value());
                },
                failure -> logger.info("Falha ao enviar mensagem" + failure.getMessage())
        );
    }
}
