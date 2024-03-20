package store.ojuara.pedidoapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import store.ojuara.pedidoapi.client.response.ProdutoResponse;

import java.util.UUID;

@FeignClient(name = "produto", url = "${feign.client.url.produto}")
public interface ProdutoClient {

    @RequestMapping("/produtos/{uuid}")
    ResponseEntity<ProdutoResponse> buscarProduto(@PathVariable UUID uuid);
}
