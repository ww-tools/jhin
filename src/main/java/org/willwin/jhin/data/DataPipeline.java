package org.willwin.jhin.data;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DataPipeline<K, V>
{

    private final List<DataStore<K, V>> dataStores;

}
