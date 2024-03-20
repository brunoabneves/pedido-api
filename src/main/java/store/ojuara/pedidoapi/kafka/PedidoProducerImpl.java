package store.ojuara.pedidoapi.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import store.ojuara.avro.pedidorealizado.ItemPedidoAvro;
import store.ojuara.pedidoapi.domain.dto.ItemPedidoDTO;

@Service
public class PedidoProducerImpl {

    private static final Logger logger = LoggerFactory.getLogger(PedidoProducerImpl.class);
    private final String topic;
    private final KafkaTemplate<String, ItemPedidoAvro> kafkaTemplate;

    public PedidoProducerImpl(@Value("${mensageria.kafka.topic.pedido.processado}") String topic, KafkaTemplate<String, ItemPedidoAvro> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(ItemPedidoDTO itemPedidoDTO){
        ItemPedidoAvro itemAvro = toAvro(itemPedidoDTO);
        kafkaTemplate.send(topic, itemAvro).addCallback(
                success -> {
                    assert success != null;
                    logger.info("Mensagem enviada com sucesso" + success.getProducerRecord().value());
                },
                failure -> logger.info("Falha ao enviar mensagem" + failure.getMessage())
        );
    }

    private ItemPedidoAvro toAvro(ItemPedidoDTO dto) {
        ItemPedidoAvro itemPedidoAvro = ItemPedidoAvro.newBuilder().build();
        itemPedidoAvro.setIdPedido((dto.getIdPedido().intValue()));
        itemPedidoAvro.setUuidProduto(dto.getUuidProduto().toString());
        itemPedidoAvro.setQuantidade(dto.getQuantidade());
        itemPedidoAvro.setSubtotal(dto.getSubtotal().toString());
        return itemPedidoAvro;
    }
}
