package store.ojuara.pedidoapi.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import store.ojuara.avro.pedidorealizado.ItemPedidoAvro;
import store.ojuara.pedidoapi.domain.dto.ItemPedidoDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoProducerImpl {

    private static final Logger logger = LoggerFactory.getLogger(PedidoProducerImpl.class);
    private final String topic;
    private final KafkaTemplate<String, List<ItemPedidoAvro>> kafkaTemplate;

    public PedidoProducerImpl(@Value("${mensageria.kafka.topic.pedido.processado}") String topic, KafkaTemplate<String, List<ItemPedidoAvro>> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(List<ItemPedidoDTO> itens){
        List<ItemPedidoAvro> itensAvro = mapeiaAvro(itens);
        kafkaTemplate.send(topic, itensAvro).addCallback(
                success -> {
                    assert success != null;
                    logger.info("Mensagem enviada com sucesso" + success.getProducerRecord().value());
                },
                failure -> logger.info("Falha ao enviar mensagem" + failure.getMessage())
        );
    }

    private List<ItemPedidoAvro> mapeiaAvro(List<ItemPedidoDTO> itens) {
        List<ItemPedidoAvro> itensAvro = new ArrayList<>();
        itens.forEach(itemDTO -> {
            var itemPedidoAvro = toAvro(itemDTO);
            itensAvro.add(itemPedidoAvro);
        });

        return itensAvro;
    }
    private ItemPedidoAvro toAvro(ItemPedidoDTO dto) {
        return ItemPedidoAvro.newBuilder()
                .setIdPedido((dto.getIdPedido().intValue()))
                .setUuidProduto(dto.getUuidProduto().toString())
                .setQuantidade(dto.getQuantidade())
                .setSubtotal(dto.getSubtotal()).build();
    }
}
