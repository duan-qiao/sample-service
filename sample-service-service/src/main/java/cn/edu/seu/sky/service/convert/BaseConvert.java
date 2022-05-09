package cn.edu.seu.sky.service.convert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaotian on 2022/5/9
 */
public interface BaseConvert<S, T> {
    /**
     * 类型转换
     * @param source source
     * @return target
     */
    T toTarget(S source);

    /**
     * 类型转换
     * @param target target
     * @return source
     */
    S toSource(T target);

    /**
     * 类型转换
     * @param sources sources
     * @return targets
     */
    default List<T> toTargets(List<S> sources) {
        return sources.stream().map(this::toTarget).collect(Collectors.toList());
    }

    /**
     * 类型转换
     * @param targets targets
     * @return sources
     */
    default List<S> toSources(List<T> targets) {
        return targets.stream().map(this::toSource).collect(Collectors.toList());
    }
}
