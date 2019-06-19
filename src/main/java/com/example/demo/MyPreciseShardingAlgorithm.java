package com.example.demo;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * Created on 2019/6/19.
 *
 * @author yangsen
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

    /*PreciseShardingAlgorithm是必选的，用于处理=和IN的分片。
    RangeShardingAlgorithm是可选的，用于处理BETWEEN AND分片，如果不配置RangeShardingAlgorithm，SQL中的BETWEEN AND将按照全库路由处理。*/
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        for (String tableName : availableTargetNames) {
            if (tableName.endsWith(shardingValue.getValue() % 3 + "")) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }

}
