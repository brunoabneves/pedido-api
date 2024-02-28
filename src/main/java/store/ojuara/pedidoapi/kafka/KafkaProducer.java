package store.ojuara.pedidoapi.kafka;

import store.ojuara.pedidoapi.client.response.ProdutoResponse;

public interface KafkaProducer<T> {
    void send(T objectMessage);
}
