package org.willwin.jhin.data;

import reactor.core.publisher.Mono;

import java.util.Optional;

public interface DataStore<K, V>
{

    Mono<Optional<V>> get(K key);

    Mono<Void> put(K key, V value);

    Mono<Void> delete(K key);

    Mono<Void> clear();

    Mono<Boolean> exists(K key);

}
